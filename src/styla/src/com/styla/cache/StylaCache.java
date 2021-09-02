/**
 *
 */
package com.styla.cache;

import java.util.ArrayList;

import org.apache.commons.collections.MapIterator;
import org.apache.commons.collections.map.LRUMap;
import org.apache.log4j.Logger;


/**
 *
 */
public class StylaCache<K, T>
{
	private final static Logger LOG = Logger.getLogger(StylaCache.class);

	public final long timeToLive;

	private final LRUMap cachedObjectsMap;

	/**
	 *
	 * @param timeToLive
	 *           the time (in seconds) a cached object should be hold in cache
	 * @param maxItems
	 *           the maximum number of cached objects
	 * @param timerInterval
	 *           the inverval (in seconds) for the cache cleanup method
	 */
	public StylaCache(final long timeToLive, final int maxItems, final long timerInterval)
	{
		this.timeToLive = timeToLive * 1000;

		cachedObjectsMap = new LRUMap(maxItems);

		if (timeToLive > 0 && timerInterval > 0)
		{

			final Thread t = new Thread(new Runnable()
			{
				public void run()
				{
					while (true)
					{
						try
						{
							Thread.sleep(timerInterval * 1000);
						}
						catch (final InterruptedException ex)
						{
							LOG.error(ex);
						}
						cleanup();
					}
				}
			});

			t.setDaemon(true);
			t.start();
		}
	}

	/**
	 * Add an object to the cache.
	 *
	 * @param key
	 *           the hash key for the object
	 * @param value
	 *           the value
	 */
	public void put(final K key, final T value)
	{
		synchronized (cachedObjectsMap)
		{
			cachedObjectsMap.put(key, new CachedObject(value));
		}
	}

	/**
	 * Return the object for a given key if is cached.
	 *
	 * @param key
	 *           the hash key for the object
	 * @return the cached object if exists
	 */
	@SuppressWarnings("unchecked")
	public T get(final K key)
	{
		synchronized (cachedObjectsMap)
		{
			final CachedObject c = (CachedObject) cachedObjectsMap.get(key);

			if (c == null)
			{
				return null;
			}
			else
			{
				return (T) c.value;
			}
		}
	}

	/**
	 * Remove an object from cache for a given key.
	 *
	 * @param key
	 *           The hash key of the cached object
	 */
	public void remove(final K key)
	{
		synchronized (cachedObjectsMap)
		{
			cachedObjectsMap.remove(key);
		}
	}

	public int size()
	{
		synchronized (cachedObjectsMap)
		{
			return cachedObjectsMap.size();
		}
	}

	/**
	 * Cleans cache from outdated objects.
	 */
	@SuppressWarnings("unchecked")
	public void cleanup()
	{
		final long now = System.currentTimeMillis();
		ArrayList<K> deleteKeys = null;

		synchronized (cachedObjectsMap)
		{
			final MapIterator itr = cachedObjectsMap.mapIterator();

			deleteKeys = new ArrayList<K>(cachedObjectsMap.size() / 2);
			K key = null;
			CachedObject c = null;

			while (itr.hasNext())
			{
				key = (K) itr.next();
				c = (CachedObject) itr.getValue();

				if (c != null && isExpired(now, c))
				{
					deleteKeys.add(key);
				}
			}
		}

		for (final K key : deleteKeys)
		{
			synchronized (cachedObjectsMap)
			{
				cachedObjectsMap.remove(key);
			}

			Thread.yield();
		}
	}

	private boolean isExpired(final long now, final CachedObject<T> cachedObject)
	{
		return now > timeToLive + cachedObject.creationTime;
	}
}
