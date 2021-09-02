package com.styla.controllers;


import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 *
 */
@Controller
@Scope("tenant")
@RequestMapping(value = StylaaddonControllerConstants.MagazineMappings.STYLAPAGE_ROOT)
public class StylaPageController extends AbstractStylaMagazineController
{
	private static final Logger LOG = Logger.getLogger(StylaPageController.class);

	@RequestMapping(value = "/**", method = RequestMethod.GET)
	public String getStylaPage(final Model model, final HttpServletRequest request, final HttpServletResponse response)
			throws CMSItemNotFoundException
	{
		final String view = getViewForConfiguredPage(StylaaddonControllerConstants.MagazineMappings.STYLAPAGE_ROOT, model, request,
				response);
		return view;
	}
}
