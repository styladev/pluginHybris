/**
 *
 */
package com.styla.service;

import com.styla.json.Seo;


/**
 *
 */
public interface StylaSeoService
{
	/**
	 * Return a seo object for a specific styla-user and query
	 *
	 * @param username
	 *           The username of the styla account
	 * @param query
	 *           The query that should be send to stlya's SEO endpoint
	 * @return The SEO object wrapping the requested information
	 */
	Seo getSeoForUser(String username, String query);

}
