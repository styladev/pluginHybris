
package com.styla.json;

import javax.annotation.Generated;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder(
{ "shopId", "caption", "image", "imageSmall", "pageUrl", "shop" })
public class ProductImage
{

	@JsonProperty("shopId")
	private String shopId;
	@JsonProperty("caption")
	private String caption;
	@JsonProperty("image")
	private String image;
	@JsonProperty("imageSmall")
	private String imageSmall;
	@JsonProperty("pageUrl")
	private String pageUrl;
	@JsonProperty("shop")
	private Boolean shop;
	protected final static Object NOT_FOUND_VALUE = new Object();

	/**
	 *
	 * @return The shopId
	 */
	@JsonProperty("shopId")
	public String getShopId()
	{
		return shopId;
	}

	/**
	 *
	 * @param shopId
	 *           The shopId
	 */
	@JsonProperty("shopId")
	public void setShopId(final String shopId)
	{
		this.shopId = shopId;
	}

	/**
	 *
	 * @return The caption
	 */
	@JsonProperty("caption")
	public String getCaption()
	{
		return caption;
	}

	/**
	 *
	 * @param caption
	 *           The caption
	 */
	@JsonProperty("caption")
	public void setCaption(final String caption)
	{
		this.caption = caption;
	}

	/**
	 *
	 * @return The image
	 */
	@JsonProperty("image")
	public String getImage()
	{
		return image;
	}

	/**
	 *
	 * @param image
	 *           The image
	 */
	@JsonProperty("image")
	public void setImage(final String image)
	{
		this.image = image;
	}

	/**
	 *
	 * @return The imageSmall
	 */
	@JsonProperty("imageSmall")
	public String getImageSmall()
	{
		return imageSmall;
	}

	/**
	 *
	 * @param imageSmall
	 *           The imageSmall
	 */
	@JsonProperty("imageSmall")
	public void setImageSmall(final String imageSmall)
	{
		this.imageSmall = imageSmall;
	}

	/**
	 *
	 * @return The pageUrl
	 */
	@JsonProperty("pageUrl")
	public String getPageUrl()
	{
		return pageUrl;
	}

	/**
	 *
	 * @param pageUrl
	 *           The pageUrl
	 */
	@JsonProperty("pageUrl")
	public void setPageUrl(final String pageUrl)
	{
		this.pageUrl = pageUrl;
	}

	/**
	 *
	 * @return The shop
	 */
	@JsonProperty("shop")
	public Boolean getShop()
	{
		return shop;
	}

	/**
	 *
	 * @param shop
	 *           The shop
	 */
	@JsonProperty("shop")
	public void setShop(final Boolean shop)
	{
		this.shop = shop;
	}

	@Override
	public String toString()
	{
		return ToStringBuilder.reflectionToString(this);
	}

	@SuppressWarnings(
	{ "unchecked" })
	protected boolean declaredProperty(final String name, final Object value)
	{
		if ("shopId".equals(name))
		{
			if (value instanceof String)
			{
				setShopId(((String) value));
			}
			else
			{
				throw new IllegalArgumentException(
						("property \"shopId\" is of type \"java.lang.String\", but got " + value.getClass().toString()));
			}
			return true;
		}
		else
		{
			if ("caption".equals(name))
			{
				if (value instanceof String)
				{
					setCaption(((String) value));
				}
				else
				{
					throw new IllegalArgumentException(
							("property \"caption\" is of type \"java.lang.String\", but got " + value.getClass().toString()));
				}
				return true;
			}
			else
			{
				if ("image".equals(name))
				{
					if (value instanceof String)
					{
						setImage(((String) value));
					}
					else
					{
						throw new IllegalArgumentException(
								("property \"image\" is of type \"java.lang.String\", but got " + value.getClass().toString()));
					}
					return true;
				}
				else
				{
					if ("imageSmall".equals(name))
					{
						if (value instanceof String)
						{
							setImageSmall(((String) value));
						}
						else
						{
							throw new IllegalArgumentException(
									("property \"imageSmall\" is of type \"java.lang.String\", but got " + value.getClass().toString()));
						}
						return true;
					}
					else
					{
						if ("pageUrl".equals(name))
						{
							if (value instanceof String)
							{
								setPageUrl(((String) value));
							}
							else
							{
								throw new IllegalArgumentException(
										("property \"pageUrl\" is of type \"java.lang.String\", but got " + value.getClass().toString()));
							}
							return true;
						}
						else
						{
							if ("shop".equals(name))
							{
								if (value instanceof Boolean)
								{
									setShop(((Boolean) value));
								}
								else
								{
									throw new IllegalArgumentException(
											("property \"shop\" is of type \"java.lang.String\", but got " + value.getClass().toString()));
								}
								return true;
							}
							else
							{
								return false;
							}
						}
					}
				}
			}
		}
	}

	@SuppressWarnings(
	{ "unchecked" })
	protected Object declaredPropertyOrNotFound(final String name, final Object notFoundValue)
	{
		if ("shopId".equals(name))
		{
			return getShopId();
		}
		else
		{
			if ("caption".equals(name))
			{
				return getCaption();
			}
			else
			{
				if ("image".equals(name))
				{
					return getImage();
				}
				else
				{
					if ("imageSmall".equals(name))
					{
						return getImageSmall();
					}
					else
					{
						if ("pageUrl".equals(name))
						{
							return getPageUrl();
						}
						else
						{
							if ("shop".equals(name))
							{
								return getShop();
							}
							else
							{
								return notFoundValue;
							}
						}
					}
				}
			}
		}
	}

	@SuppressWarnings(
	{ "unchecked" })
	public <T> T get(final String name)
	{
		final Object value = declaredPropertyOrNotFound(name, ProductImage.NOT_FOUND_VALUE);
		if (ProductImage.NOT_FOUND_VALUE != value)
		{
			return ((T) value);
		}
		else
		{
			throw new IllegalArgumentException((("property \"" + name) + "\" is not defined"));
		}
	}

	@SuppressWarnings(
	{ "unchecked" })
	public void set(final String name, final Object value)
	{
		if (!declaredProperty(name, value))
		{
			throw new IllegalArgumentException((("property \"" + name) + "\" is not defined"));
		}
	}

	@Override
	public int hashCode()
	{
		return new HashCodeBuilder().append(shopId).append(caption).append(image).append(imageSmall).append(pageUrl).append(shop)
				.toHashCode();
	}

	@Override
	public boolean equals(final Object other)
	{
		if (other == this)
		{
			return true;
		}
		if ((other instanceof ProductImage) == false)
		{
			return false;
		}
		final ProductImage rhs = ((ProductImage) other);
		return new EqualsBuilder().append(shopId, rhs.shopId).append(caption, rhs.caption).append(image, rhs.image)
				.append(imageSmall, rhs.imageSmall).append(pageUrl, rhs.pageUrl).append(shop, rhs.shop).isEquals();
	}

}
