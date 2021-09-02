/**
 *
 */
package com.styla.cache;

/**
 *
 */
public class CachedObject<T>
{
	private static long expirationTime;

	final public long creationTime = System.currentTimeMillis();

	public T value;

	public CachedObject(final T value)
	{
		this.value = value;
	}
}
