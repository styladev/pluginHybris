/**
 *
 */
package com.styla.service;

import java.util.List;

import com.styla.json.Category;


/**
 *
 */
public interface StylaCategoryProvider
{
	/**
	 * Returns a list of categories.
	 *
	 * @return the categories
	 */
	List<Category> getCategories();
}
