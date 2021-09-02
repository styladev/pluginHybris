/**
 *
 */
package com.styla.service.impl;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import com.google.common.cache.CacheBuilder;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.styla.json.Seo;
import com.styla.service.StylaSeoService;
import com.styla.ws.StylaWsClient;

import javax.annotation.Resource;


/**
 *
 */
public class DefaultStylaSeoService implements StylaSeoService
{
	private final static Logger LOG = Logger.getLogger(DefaultStylaSeoService.class);
	public static final String UTF_8 = "UTF-8";
	public static final String STYLA_SEO_CACHE_NAME = "stylaSeoCache";
	public static final String STYLA_CACHE_PREFIX = "styla_";
	public static final String STYLA_CACHE_PARAM_SEPARATOR = "_";

	@Autowired
	private StylaWsClient stylaWsClient;

	@Resource
	private CacheManager stylaCacheManager;

	@Override
	public Seo getSeoForUser(final String username, final String param)
	{
		Assert.notNull(username, "Parameter [username] must not be null");
		Assert.notNull(param, "Parameter [param] must not be null");
		final String cacheKey = STYLA_CACHE_PREFIX + username + STYLA_CACHE_PARAM_SEPARATOR + param;
		Cache.ValueWrapper value = getStylaSeoCache(cacheKey);
		if (value != null && value.get() != null) {
			return (Seo) value.get();
		}

		LOG.debug("Request to get SEO for  " + username + "  param " + param);
		try
		{
			final String seoQueryParameter = "?url=" + URLEncoder.encode(param, UTF_8);
			LOG.debug(seoQueryParameter);
			Seo seo = stylaWsClient.getSeo(username, seoQueryParameter);
			putStylaSeoCache(cacheKey, seo);
			return seo;
		}
		catch (final UnsupportedEncodingException e)
		{
			LOG.error("Failed to urlencode '" + param + "'");
		}

		return null;
	}

	private void putStylaSeoCache(String cacheKey, Seo seo) {
		getStylaSeoCache().put(cacheKey, seo);
	}

	private Cache.ValueWrapper getStylaSeoCache(String cacheKey) {
		return getStylaSeoCache().get(cacheKey);
	}

	private Cache getStylaSeoCache() {
		return stylaCacheManager.getCache(STYLA_SEO_CACHE_NAME);
	}
}
