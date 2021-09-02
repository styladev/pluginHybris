/**
 *
 */
package com.styla.service.utils;

import de.hybris.platform.cms2.servicelayer.services.CMSSiteService;
import de.hybris.platform.commerceservices.i18n.CommerceCommonI18NService;
import de.hybris.platform.servicelayer.config.ConfigurationService;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.styla.constants.StylaConstants;
import com.styla.service.StylaVersionService;


/**
 *
 */
public class StylaUtilities
{
	private final static Logger LOG = Logger.getLogger(StylaUtilities.class);

	@Autowired
	private ConfigurationService configurationService;

	@Autowired
	private CMSSiteService cmsSiteService;

	@Autowired
	private StylaVersionService stylaVersionService;

	@Autowired
	private CommerceCommonI18NService commerceCommonI18NService;

	private String getStylaUsernamePropertyKey()
	{
		if (StringUtils.isNotBlank(cmsSiteService.getCurrentSite().getUid())
				&& StringUtils.isNotBlank(commerceCommonI18NService.getCurrentLanguage().getIsocode()))
		{
			return StylaConstants.STYLA_USERNAME + "." + getSiteWithLanguage();
		}

		return null;
	}

	private String getSiteWithLanguage()
	{
		return (cmsSiteService.getCurrentSite().getUid() + "." + commerceCommonI18NService.getCurrentLanguage().getIsocode())
				.toLowerCase();
	}

	private static String addTrailingSlash(String url)
	{
		if (url.charAt(url.length() - 1) != '/')
		{
			url += '/';
		}
		return url;
	}

	public String getJsUrl()
	{
		final String username = getStylaUsername();
		String jsUrl = configurationService.getConfiguration().getString(StylaConstants.STYLA_SCRIPTS_BASEURL);
		jsUrl = addTrailingSlash(jsUrl);
		jsUrl += username + ".js?v=" + stylaVersionService.getVersion(username);
		return jsUrl;
	}

	public String getCssUrl()
	{
		final String username = getStylaUsername();
		String cssUrl = configurationService.getConfiguration().getString(StylaConstants.STYLA_STYLES_BASEURL);
		cssUrl = addTrailingSlash(cssUrl);
		cssUrl += username + ".css?v=" + stylaVersionService.getVersion(username);
		return cssUrl;
	}

	public String getStylaUsername()
	{
		final String username = configurationService.getConfiguration().getString(getStylaUsernamePropertyKey());
		if (StringUtils.isBlank(username))
		{
			LOG.error("No valid property defined [" + getStylaUsernamePropertyKey() + "]");
			return null;
		}

		return username;
	}

	public String getStylaLandingpagesPropertyKey()
	{
		if (StringUtils.isNotBlank(cmsSiteService.getCurrentSite().getUid())
				&& StringUtils.isNotBlank(commerceCommonI18NService.getCurrentLanguage().getIsocode()))
		{
			return StylaConstants.STYLA_PREFIX + "." + getSiteWithLanguage() + "." + StylaConstants.STYLA_ENABLE_LANDINGPAGE;
		}

		return null;
	}


}
