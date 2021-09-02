package com.styla.service;

public interface StylaVersionService
{
	/**
	 * Determine the current version from styla's remote endpoint for a given user.
	 *
	 * @param username
	 *           The username to determine the current version for
	 * @return The version id
	 */
	String getVersion(final String username);
}
