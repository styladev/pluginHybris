/**
 *
 */
package com.styla.service.impl;

import de.hybris.platform.acceleratorservices.urlresolver.SiteBaseUrlResolutionService;
import de.hybris.platform.commercefacades.product.data.ImageData;
import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.commercefacades.search.ProductSearchFacade;
import de.hybris.platform.commercefacades.search.data.SearchQueryData;
import de.hybris.platform.commercefacades.search.data.SearchStateData;
import de.hybris.platform.commerceservices.search.facetdata.ProductSearchPageData;
import de.hybris.platform.commerceservices.search.pagedata.PageableData;
import de.hybris.platform.site.BaseSiteService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.styla.json.ProductImage;
import com.styla.service.StylaSearchService;


/**
 *
 */
public class DefaultStylaSearchService implements StylaSearchService
{
	@Autowired
	ProductSearchFacade<ProductData> productSearchFacade;

	@Autowired
	SiteBaseUrlResolutionService siteBaseUrlResolutionService;

	@Autowired
	BaseSiteService baseSiteService;

	private static final Logger LOG = Logger.getLogger(DefaultStylaSearchService.class);

	/*
	 * (non-Javadoc)
	 *
	 * @see com.styla.service.StylaSearchService#getProducts(java.lang.String, java.lang.String, int)
	 */
	@Override
	public List<ProductImage> getProducts(final String category, final String searchTerm, final int limit, final int offset)
	{
		final int page = offset / limit;
		final ProductSearchPageData<?, ProductData> productSearchPageData;
		if (StringUtils.isNotEmpty(searchTerm))
		{
			productSearchPageData = performTextSearch(category, searchTerm, page, limit);
		}
		else
		{
			productSearchPageData = performCategorySearch(category, page, limit);
		}

		if (!productSearchPageData.getResults().isEmpty())
		{
			final List<ProductImage> stylaProducts = new ArrayList<ProductImage>(productSearchPageData.getResults().size());

			for (final ProductData product : productSearchPageData.getResults())
			{
				final ProductImage stylaProductImage = new ProductImage();
				stylaProductImage.setShopId(product.getCode());

				final Collection<ImageData> images = product.getImages();
				if (!images.isEmpty())
				{
					for (final ImageData image : images)
					{
						if (stylaProductImage.getImageSmall() == null && "thumbnail".equals(image.getFormat()))
						{
							stylaProductImage.setImageSmall(getAbsoluteMediaUrl(image.getUrl()));
						}
						else if (stylaProductImage.getImage() == null && "product".equals(image.getFormat()))
						{
							if (image.getAltText() == null)
							{
								LOG.info(
										"Image for product " + product.getCode() + " has no alt-text defined. Using product name instead.");
							}
							stylaProductImage.setCaption(product.getName());
							stylaProductImage.setImage(getAbsoluteMediaUrl(image.getUrl()));
						}

						if (stylaProductImage.getImage() != null && stylaProductImage.getImageSmall() != null)
						{
							break;
						}
					}
				}
				stylaProductImage.setPageUrl(getAbsoluteUrl(product.getUrl()));
				stylaProductImage.setShop(product.getPurchasable());
				stylaProducts.add(stylaProductImage);
			}
			return stylaProducts;
		}
		return Collections.emptyList();
	}

	protected ProductSearchPageData<SearchStateData, ProductData> performTextSearch(final String category, final String searchTerm,
			final int page, final int pageSize)
	{
		final StringBuilder sb = new StringBuilder();
		if (!StringUtils.isEmpty(searchTerm))
		{
			sb.append(searchTerm);
		}
		sb.append(StringUtils.isEmpty(sb.toString()) ? "" : ":");
		sb.append("relevance");
		if (!StringUtils.isEmpty(category))
		{
			sb.append(StringUtils.isEmpty(sb.toString()) ? "" : ":");
			sb.append("category:");
			sb.append(category);
		}

		LOG.debug("Searchstring: " + sb.toString());

		final PageableData pageableData = createPageableData(page, pageSize, true);

		final SearchStateData searchState = new SearchStateData();
		final SearchQueryData searchQueryData = new SearchQueryData();
		searchQueryData.setValue(sb.toString());
		searchState.setQuery(searchQueryData);

		return productSearchFacade.textSearch(searchState, pageableData);
	}

	protected ProductSearchPageData<SearchStateData, ProductData> performCategorySearch(final String categoryCode, final int page,
			final int pageSize)
	{
		final PageableData pageableData = createPageableData(page, pageSize, true);
		final SearchStateData searchState = new SearchStateData();
		return productSearchFacade.categorySearch(categoryCode, searchState, pageableData);
	}

	protected PageableData createPageableData(final int pageNumber, final int pageSize, final boolean paginate)
	{
		final PageableData pageableData = new PageableData();
		pageableData.setCurrentPage(pageNumber);

		if (paginate)
		{
			pageableData.setPageSize(pageSize);
		}
		else
		{
			pageableData.setPageSize(100);
		}
		return pageableData;
	}

	private String getAbsoluteMediaUrl(final String path)
	{
		return siteBaseUrlResolutionService.getMediaUrlForSite(baseSiteService.getCurrentBaseSite(), false, path);
	}

	private String getAbsoluteUrl(final String path)
	{
		return siteBaseUrlResolutionService.getWebsiteUrlForSite(baseSiteService.getCurrentBaseSite(), false, path);
	}

}
