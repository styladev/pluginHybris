/**
 *
 */
package com.styla.controllers;

import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.cms2.servicelayer.services.CMSSiteService;
import de.hybris.platform.servicelayer.config.ConfigurationService;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.styla.constants.StylaConstants;
import com.styla.json.Category;
import com.styla.json.Product;
import com.styla.json.ProductImage;
import com.styla.service.StylaCategoryProvider;
import com.styla.service.StylaProductProvider;
import com.styla.service.StylaSearchService;



/**
 *
 */
@Controller
@Scope("tenant")
@RequestMapping(value = "/styla")
public class StylaController
{
	@Autowired
	StylaProductProvider stylaProductProvider;

	@Autowired
	StylaCategoryProvider stylaCategoryProvider;

	@Autowired
	StylaSearchService stylaSearchService;

	@Autowired
	ConfigurationService configurationService;

	@Autowired
	CMSSiteService cmsSiteService;

	@RequestMapping(value = "/categories", method = RequestMethod.GET)
	@ResponseBody
	public List<Category> getCategories(final HttpServletResponse response,
			@RequestParam(value = "key", required = false) final String key) throws CMSItemNotFoundException
	{
		if (configurationService.getConfiguration().getString(getKey()).equals(key))
		{
			return stylaCategoryProvider.getCategories();
		}
		else
		{
			try
			{
				response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
			}
			catch (final IOException i)
			{
				//
			}
		}
		return Collections.emptyList();
	}

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	@ResponseBody
	public List<ProductImage> getProducts(final HttpServletResponse response,
			@RequestParam(value = "category", required = false) final String category,
			@RequestParam(value = "search", required = false) final String searchTerm,
			@RequestParam(value = "limit", required = false, defaultValue = "10") final int limit,
			@RequestParam(value = "offset", required = false, defaultValue = "0") final int offset,
			@RequestParam(value = "key", required = false) final String key) throws CMSItemNotFoundException
	{
		if (configurationService.getConfiguration().getString(getKey()).equals(key))
		{
			return stylaSearchService.getProducts(category, searchTerm, limit, offset);
		}
		else
		{
			try
			{
				response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
			}
			catch (final IOException i)
			{
				//
			}
		}
		return Collections.emptyList();
	}

	@RequestMapping(value = "/product", method = RequestMethod.GET)
	@ResponseBody
	public Product getProducts(@RequestParam("id") final String productCode) throws CMSItemNotFoundException
	{
		return stylaProductProvider.getProduct(productCode);
	}

	@RequestMapping(value = "/version", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, String> getApiVersion() throws CMSItemNotFoundException
	{
		final String stylaApiVersion = configurationService.getConfiguration().getString("styla.api.version", "");
		final String stylaaddonApiVersion = configurationService.getConfiguration().getString("stylaaddon.api.version", "");

		String versionString = isEmpty(stylaApiVersion) ? "" : "styla: " + stylaApiVersion;
		versionString += (isEmpty(versionString) && isEmpty(stylaaddonApiVersion)) ? "" : "; ";
		versionString += isEmpty(stylaaddonApiVersion) ? "" : "stylaaddon: " + stylaaddonApiVersion;

		return Collections.singletonMap("version", versionString);
	}

	private String getKey()
	{


		return StylaConstants.STYLA_PRODUCT_API_KEY + "." + cmsSiteService.getCurrentSite().getUid();
	}

	private boolean isEmpty(final String s)
	{
		return s == null || "".equals(s.trim());
	}
}
