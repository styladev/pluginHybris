/*
 * [y] hybris Platform
 *
 * Copyright (c) 2000-2015 hybris AG
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of hybris
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with hybris.
 *
 *
 */
package com.styla.controllers;

/**
 */
public interface StylaaddonControllerConstants
{
	interface Actions
	{
		interface Cms
		{
			String _Prefix = "/view/";
			String _Suffix = "Controller";

			String StylaComponent = _Prefix + "StylaComponent" + _Suffix;
		}
	}

	interface Views
	{
		interface Pages
		{
			String STYLA_MAGAZINE_CMS_PAGE = "stylamagazine";
			String ERROR_CMS_PAGE = "notFound";
		}
	}

	interface MagazineMappings
	{
		String MAGAZIN_ROOT = "/magazin";
		String MAGAZINE_ROOT = "/magazine";
		String STYLAPAGE_ROOT = "/s";
	}
}
