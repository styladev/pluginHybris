
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
{ "id", "saleable", "price", "oldPrice" })
public class ProductVariant
{

	@JsonProperty("id")
	private String id;
	@JsonProperty("saleable")
	private Boolean saleable;
	@JsonProperty("price")
	private String price;
	@JsonProperty("oldPrice")
	private String oldPrice;
	protected final static Object NOT_FOUND_VALUE = new Object();

	/**
	 *
	 * @return The id
	 */
	@JsonProperty("id")
	public String getId()
	{
		return id;
	}

	/**
	 *
	 * @param id
	 *           The id
	 */
	@JsonProperty("id")
	public void setId(final String id)
	{
		this.id = id;
	}

	/**
	 *
	 * @return The saleable
	 */
	@JsonProperty("saleable")
	public Boolean getSaleable()
	{
		return saleable;
	}

	/**
	 *
	 * @param saleable
	 *           The saleable
	 */
	@JsonProperty("saleable")
	public void setSaleable(final Boolean saleable)
	{
		this.saleable = saleable;
	}

	/**
	 *
	 * @return The price
	 */
	@JsonProperty("price")
	public String getPrice()
	{
		return price;
	}

	/**
	 *
	 * @param price
	 *           The price
	 */
	@JsonProperty("price")
	public void setPrice(final String price)
	{
		this.price = price;
	}

	/**
	 *
	 * @return The oldPrice
	 */
	@JsonProperty("oldPrice")
	public String getOldPrice()
	{
		return oldPrice;
	}

	/**
	 *
	 * @param oldPrice
	 *           The oldPrice
	 */
	@JsonProperty("oldPrice")
	public void setOldPrice(final String oldPrice)
	{
		this.oldPrice = oldPrice;
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
		if ("id".equals(name))
		{
			if (value instanceof String)
			{
				setId(((String) value));
			}
			else
			{
				throw new IllegalArgumentException(
						("property \"id\" is of type \"java.lang.String\", but got " + value.getClass().toString()));
			}
			return true;
		}
		else
		{
			if ("saleable".equals(name))
			{
				if (value instanceof Boolean)
				{
					setSaleable(((Boolean) value));
				}
				else
				{
					throw new IllegalArgumentException(
							("property \"saleable\" is of type \"java.lang.String\", but got " + value.getClass().toString()));
				}
				return true;
			}
			else
			{
				if ("price".equals(name))
				{
					if (value instanceof String)
					{
						setPrice(((String) value));
					}
					else
					{
						throw new IllegalArgumentException(
								("property \"price\" is of type \"java.lang.String\", but got " + value.getClass().toString()));
					}
					return true;
				}
				else
				{
					if ("oldPrice".equals(name))
					{
						if (value instanceof String)
						{
							setOldPrice(((String) value));
						}
						else
						{
							throw new IllegalArgumentException(
									("property \"oldPrice\" is of type \"java.lang.String\", but got " + value.getClass().toString()));
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

	@SuppressWarnings(
	{ "unchecked" })
	protected Object declaredPropertyOrNotFound(final String name, final Object notFoundValue)
	{
		if ("id".equals(name))
		{
			return getId();
		}
		else
		{
			if ("saleable".equals(name))
			{
				return getSaleable();
			}
			else
			{
				if ("price".equals(name))
				{
					return getPrice();
				}
				else
				{
					if ("oldPrice".equals(name))
					{
						return getOldPrice();
					}
					else
					{
						return notFoundValue;
					}
				}
			}
		}
	}

	@SuppressWarnings(
	{ "unchecked" })
	public <T> T get(final String name)
	{
		final Object value = declaredPropertyOrNotFound(name, ProductVariant.NOT_FOUND_VALUE);
		if (ProductVariant.NOT_FOUND_VALUE != value)
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
		return new HashCodeBuilder().append(id).append(saleable).append(price).append(oldPrice).toHashCode();
	}

	@Override
	public boolean equals(final Object other)
	{
		if (other == this)
		{
			return true;
		}
		if ((other instanceof ProductVariant) == false)
		{
			return false;
		}
		final ProductVariant rhs = ((ProductVariant) other);
		return new EqualsBuilder().append(id, rhs.id).append(saleable, rhs.saleable).append(price, rhs.price)
				.append(oldPrice, rhs.oldPrice).isEquals();
	}

}
