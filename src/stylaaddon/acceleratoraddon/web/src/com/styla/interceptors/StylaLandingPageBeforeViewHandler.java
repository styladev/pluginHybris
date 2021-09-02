/**
 *
 */
package com.styla.interceptors;

import de.hybris.platform.addonsupport.interceptors.BeforeViewHandlerAdaptee;
import de.hybris.platform.servicelayer.config.ConfigurationService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.util.Assert;

import com.styla.json.Seo;
import com.styla.service.StylaSeoService;
import com.styla.service.utils.StylaUtilities;


/**
 *
 */

public class StylaLandingPageBeforeViewHandler implements BeforeViewHandlerAdaptee
{
	private final static Logger LOG = Logger.getLogger(StylaLandingPageBeforeViewHandler.class);

	@Autowired
	private StylaSeoService stylaSeoService;

	@Autowired
	private StylaUtilities stylaUtilities;

	@Autowired
	private ConfigurationService configurationService;

	@Override
	public String beforeView(final HttpServletRequest request, final HttpServletResponse response, final ModelMap model,
			final String viewName) throws Exception
	{
		final String stylaEnableLandingPagePropertyKey = stylaUtilities.getStylaLandingpagesPropertyKey();

		if (StringUtils.isBlank(request.getServletPath())
				&& configurationService.getConfiguration().getBoolean(stylaEnableLandingPagePropertyKey, false))
		{
			final long start = System.currentTimeMillis();
			final Seo seo = getSeo(request, stylaUtilities.getStylaUsername());
			final long stop = System.currentTimeMillis();
			LOG.debug("Getting SEO took " + String.valueOf(stop - start) + "ms");
			if (seo != null && seo.getHtml() != null)
			{
				model.addAttribute("pageTitle", seo.getTitle());
				LOG.debug("Setting title to: " + seo.getTitle());
				model.addAttribute("stylaHtmlHead", seo.getHtml().getHead());
				LOG.debug("Setting head to: " + seo.getHtml().getHead());
				model.addAttribute("stylaHtmlBody", seo.getHtml().getBody());
				LOG.debug("Setting body to: " + seo.getHtml().getBody());
			}
			model.addAttribute("stylaJsUrl", stylaUtilities.getJsUrl());
			model.addAttribute("stylaCssUrl", stylaUtilities.getCssUrl());
		}

		return viewName;
	}

	protected Seo getSeo(final HttpServletRequest request, final String username)
	{
		Assert.notNull(request, "Parameter [request] must not be null");
		Assert.notNull(username, "Parameter [username] must not be null");
		return stylaSeoService.getSeoForUser(username, request.getContextPath());
	}
}
