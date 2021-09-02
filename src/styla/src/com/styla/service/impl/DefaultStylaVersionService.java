/**
 *
 */
package com.styla.service.impl;

import de.hybris.platform.servicelayer.config.ConfigurationService;

import java.io.IOException;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.PostConstruct;

import org.apache.commons.lang.StringUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.styla.constants.StylaConstants;


public class DefaultStylaVersionService implements com.styla.service.StylaVersionService
{
	private final static Logger LOG = Logger.getLogger(DefaultStylaVersionService.class);

	private final static String EXPIRES = "Expires";
	private final static String CACHE_CONTROL = "Cache-Control";

	private static String VERSION_BASEURL;

	private final Map<String, Version> versionCache = new HashMap<String, Version>();

	@Autowired
	ConfigurationService configurationService;

	@PostConstruct
	public void postConstruct()
	{
		VERSION_BASEURL = configurationService.getConfiguration().getString(StylaConstants.STYLA_ENDPOINT_VERSION);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.styla.service.StylaVersionService#getVersion(java.lang.String)
	 */
	@Override
	public String getVersion(final String username)
	{
		final Version cachedVersion = versionCache.get(username);

		if (cachedVersion != null && new Date().before(cachedVersion.expires))
		{
			return cachedVersion.versionId;
		}

		final Version version = getVersionFromResponse(doRequest(username));
		if (version != null)
		{
			if (version.versionId != null && version.expires != null)
			{
				versionCache.put(username, version);
			}

			return version.versionId;
		}

		return null;
	}

	private Version getVersionFromResponse(final HttpResponse response)
	{
		if (response == null)
		{
			return null;
		}

		final Date expiresDate = getExpiresDate(response);
		final String versionString = getVersionString(response);

		if (StringUtils.isNotBlank(versionString))
		{
			return new Version(versionString, expiresDate);
		}

		return null;
	}

	private String getVersionString(final HttpResponse response)
	{
		final HttpEntity entity = response.getEntity();
		final ContentType contentType = ContentType.getOrDefault(entity);
		final Charset charset = contentType.getCharset();
		try
		{
			return EntityUtils.toString(response.getEntity(), charset);
		}
		catch (org.apache.http.ParseException | IOException e)
		{
			e.printStackTrace();
		}

		return null;
	}

	private Date getExpiresDate(final HttpResponse response)
	{
		// check for max-age in cache control
		final Header cacheControlHeader = response.getFirstHeader(CACHE_CONTROL);
		if (cacheControlHeader != null && StringUtils.isNotBlank(cacheControlHeader.getValue()))
		{
			final Pattern pattern = Pattern.compile(".*max-age=(\\d+).*");
			final Matcher matcher = pattern.matcher(cacheControlHeader.getValue());
			if (matcher.matches())
			{
				final Calendar calender = Calendar.getInstance();
				calender.add(Calendar.SECOND, Integer.valueOf(matcher.group(1)).intValue());
				return calender.getTime();
			}
		}

		// fallback case if max-age is not defined
		final Header expiresHeader = response.getFirstHeader(EXPIRES);
		if (expiresHeader == null)
		{
			LOG.error("Expires header has been null");
			return null;
		}

		final SimpleDateFormat format = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.ENGLISH);
		try
		{
			return format.parse(expiresHeader.getValue());
		}
		catch (final ParseException e)
		{
			e.printStackTrace();
		}

		return null;
	}

	private HttpResponse doRequest(final String username)
	{
		final String url = VERSION_BASEURL + "/" + username;

		try
		{
			return Request.Get(url).execute().returnResponse();
		}
		catch (final IOException e)
		{
			e.printStackTrace();
		}

		return null;
	}

	static class Version
	{
		final Date expires;
		final String versionId;

		public Version(final String versionId, final Date expires)
		{
			this.versionId = versionId;
			this.expires = expires;
		}
	}

}
