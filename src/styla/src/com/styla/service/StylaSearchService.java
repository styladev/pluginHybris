/**
 *
 */
package com.styla.service;

import java.util.List;

import com.styla.json.ProductImage;


/**
 *
 */
public interface StylaSearchService
{
	/**
	 * Returns for a given searchterm and category value a list of productimage objects.
	 *
	 * @param category
	 *           the category that should be searched for productimages
	 * @param searchTerm
	 *           the searchterm
	 * @param limit
	 *           the page size, i.e. maximum number of products per page
	 * @param offset
	 *           the number of product images to be skipped from the original result list
	 * @return the list of product images satisfying the search criteria
	 */
	List<ProductImage> getProducts(String category, String searchTerm, int limit, int offset);

}
