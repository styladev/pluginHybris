/**
 *
 */
package com.styla.ws.impl;

import de.hybris.platform.servicelayer.config.ConfigurationService;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import javax.annotation.PostConstruct;

import org.apache.commons.lang.StringUtils;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.fluent.Request;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;
import com.styla.constants.StylaConstants;
import com.styla.json.Seo;
import com.styla.ws.StylaWsClient;


/**
 *
 */
public class DefaultStylaWsClient implements StylaWsClient
{
	@Autowired
	ConfigurationService configurationService;

	private static String SEO_ENDPOINT;

	final private static Logger LOG = Logger.getLogger(DefaultStylaWsClient.class);

	@PostConstruct
	public void postConstruct()
	{
		SEO_ENDPOINT = configurationService.getConfiguration().getString(StylaConstants.STYLA_ENDPOINT_SEO);
	}

	@Override
	public Seo getSeo(final String username, final String param)
	{
		return toJson(doStylaRequest(username, param), Seo.class);
	}

	protected String doStylaRequest(final String username, final String urlParam)
	{
		final String url = SEO_ENDPOINT + "/" + username + urlParam;
		try
		{
			LOG.debug("Request: " + url);
			return Request.Get(url).addHeader("Accept", "application/json").addHeader("Content-Type", "application/json").execute()
					.returnContent().asString(StandardCharsets.UTF_8);
		}
		catch (final HttpResponseException h)
		{
			LOG.error("Requesting resource failed: " + url);
			LOG.error(h);
		}
		catch (final IOException e)
		{
			LOG.error(e);
		}

		return null;
	}

	private <T> T toJson(final String jsonString, final Class<T> clazz)
	{
		final Gson gson = new Gson();
		if (StringUtils.isNotEmpty(jsonString))
		{
			return gson.fromJson(jsonString, clazz);
		}
		return null;
	}

}
