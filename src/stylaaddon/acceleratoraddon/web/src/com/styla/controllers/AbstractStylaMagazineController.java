package com.styla.controllers;


import de.hybris.platform.acceleratorstorefrontcommons.controllers.ThirdPartyConstants;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractPageController;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.util.GlobalMessages;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.cms2.model.pages.ContentPageModel;
import de.hybris.platform.cms2.servicelayer.services.CMSSiteService;
import de.hybris.platform.commerceservices.i18n.CommerceCommonI18NService;
import de.hybris.platform.servicelayer.config.ConfigurationService;
import de.hybris.platform.yacceleratorstorefront.controllers.ControllerConstants;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import com.styla.json.Seo;
import com.styla.service.StylaSeoService;
import com.styla.service.StylaVersionService;
import com.styla.service.utils.StylaUtilities;


public abstract class AbstractStylaMagazineController extends AbstractPageController
{
	private static final Logger LOG = Logger.getLogger(AbstractStylaMagazineController.class);

	@Autowired
	private ConfigurationService configurationService;

	@Autowired
	private StylaSeoService stylaSeoService;

	@Autowired
	private CMSSiteService cmsSiteService;

	@Autowired
	private CommerceCommonI18NService commerceCommonI18NService;

	@Autowired
	private StylaVersionService stylaVersionService;

	@Autowired
	private StylaUtilities stylaUtilities;

	protected String getViewForConfiguredPage(final String requestMapping, final Model model, final HttpServletRequest request,
			final HttpServletResponse response) throws CMSItemNotFoundException
	{
		// get the part of the mapped path after the magazine-root
		final String restOfMagazinePath = request.getServletPath().replaceFirst(requestMapping, "");
		LOG.debug("RestOfMagazinePath: " + restOfMagazinePath);

		final String queryParameter = request.getRequestURI();
		final Seo seo = stylaSeoService.getSeoForUser(stylaUtilities.getStylaUsername(), queryParameter);

		if ((seo == null || (seo.getStatus() != null && seo.getStatus().intValue() == HttpServletResponse.SC_NOT_FOUND))
				&& !"styla".equalsIgnoreCase(configurationService.getConfiguration().getString("styla.seo.notfound.page", "hybris")))
		{
			LOG.warn("Couldn't get valid SEO from API (user: " + stylaUtilities.getStylaUsername() + ", query: " + queryParameter);
			final ContentPageModel errorPage = getContentPageForLabelOrId(StylaaddonControllerConstants.Views.Pages.ERROR_CMS_PAGE);
			storeCmsPageInModel(model, errorPage);
			setUpMetaDataForContentPage(model, errorPage);

			if (seo != null)
			{
				model.addAttribute(CMS_PAGE_TITLE, seo.getTitle());
			}
			model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);
			GlobalMessages.addErrorMessage(model, "system.error.page.not.found");
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);

			return ControllerConstants.Views.Pages.Error.ErrorNotFoundPage;
		}

		modelSetup(model);
		addSeoContentToModel(seo, model);
		return getViewForPage(model);
	}

	protected void modelSetup(final Model model)
	{
		try
		{
			final ContentPageModel magazinePage = getContentPageForLabelOrId(
					StylaaddonControllerConstants.Views.Pages.STYLA_MAGAZINE_CMS_PAGE);
			storeCmsPageInModel(model, magazinePage);
			setUpMetaDataForContentPage(model, magazinePage);
			model.addAttribute("stylaJsUrl", stylaUtilities.getJsUrl());
			model.addAttribute("stylaCssUrl", stylaUtilities.getCssUrl());
		}
		catch (final CMSItemNotFoundException e)
		{
			LOG.warn(e);
		}
	}

	protected void addSeoContentToModel(final Seo seo, final Model model)
	{
		if (seo != null)
		{
			storeContentPageTitleInModel(model, seo.getTitle());
			model.addAttribute("stylaHtmlHead", seo.getHtml().getHead());
			model.addAttribute("stylaHtmlBody", seo.getHtml().getBody());
		}
	}
}