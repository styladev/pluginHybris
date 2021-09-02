/**
 *
 */
package com.styla.service.impl;

import de.hybris.platform.acceleratorcms.model.components.NavigationBarCollectionComponentModel;
import de.hybris.platform.acceleratorcms.model.components.NavigationBarComponentModel;
import de.hybris.platform.category.model.CategoryModel;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.cms2.model.contents.components.CMSLinkComponentModel;
import de.hybris.platform.cms2.model.contents.components.SimpleCMSComponentModel;
import de.hybris.platform.cms2.model.navigation.CMSNavigationNodeModel;
import de.hybris.platform.cms2.servicelayer.services.CMSComponentService;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.styla.json.Category;
import com.styla.service.StylaCategoryProvider;


/**
 *
 */
public class DefaultStylaCategoryProvider implements StylaCategoryProvider
{
	@Autowired
	private CMSComponentService cmsComponentService;

	private final String NAVIGATIONBAR_COLLECTION_COMPONENT = "NavBarComponent";

	private final static Logger LOG = Logger.getLogger(DefaultStylaCategoryProvider.class);

	@Override
	public List<Category> getCategories()
	{
		try
		{
			final SimpleCMSComponentModel cmsComponent = cmsComponentService
					.getSimpleCMSComponent(NAVIGATIONBAR_COLLECTION_COMPONENT);
			if (cmsComponent instanceof NavigationBarCollectionComponentModel)
			{
				final List<Category> stylaCategories = new ArrayList<Category>();
				final NavigationBarCollectionComponentModel navigationBarCollection = (NavigationBarCollectionComponentModel) cmsComponent;
				final List<NavigationBarComponentModel> topCategories = navigationBarCollection.getComponents();

				for (final NavigationBarComponentModel component : topCategories)
				{
					if (component.getLink().getCategory() != null)
					{
						final CategoryModel category = component.getLink().getCategory();
						final Category stylaCategory = new Category();
						stylaCategory.setName(component.getLink().getLinkName());
						stylaCategory.setId(category.getCode());
						//stylaCategory.setImage(null);
						stylaCategory.setChildren(getChildren(component.getNavigationNode()));

						stylaCategories.add(stylaCategory);
					}
				}

				return stylaCategories;
			}
		}
		catch (final CMSItemNotFoundException c)
		{
			LOG.warn("Couldn't find cmsComponent with code '" + NAVIGATIONBAR_COLLECTION_COMPONENT + "'");
		}

		return null;
	}

	private List<Category> getChildren(final CMSNavigationNodeModel node)
	{
		final List<Category> children = new ArrayList<Category>();

		if (node != null)
		{
			for (final CMSNavigationNodeModel subNode : node.getChildren())
			{
				final String prefix = node.getChildren().size() == 1 ? "" : subNode.getTitle() + " - ";
				for (final CMSLinkComponentModel link : subNode.getLinks())
				{
					if (link.getCategory() != null)
					{
						final CategoryModel category = link.getCategory();
						final Category stylaCategory = new Category();
						stylaCategory.setName(prefix + link.getLinkName());
						stylaCategory.setId(category.getCode());
						//stylaCategory.setImage(null);

						children.add(stylaCategory);
					}
				}
			}
		}

		return children;
	}
}
