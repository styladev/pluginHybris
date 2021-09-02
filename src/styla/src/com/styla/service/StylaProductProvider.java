/**
 *
 */
package com.styla.service;

import com.styla.json.Product;


/**
 *
 */
public interface StylaProductProvider
{
	/**
	 * Returns a product for a given product code if exists.
	 *
	 * @param id
	 *           the product code
	 * @return the product
	 */
	Product getProduct(final String id);
}
