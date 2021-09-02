
package com.styla.json;

import java.util.ArrayList;
import java.util.List;

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
{ "id", "label", "price", "oldPrice", "products" })
public class Option
{

	@JsonProperty("id")
	private String id;
	@JsonProperty("label")
	private String label;
	@JsonProperty("price")
	private String price;
	@JsonProperty("oldPrice")
	private String oldPrice;
	@JsonProperty("products")
	private List<ProductVariant> products = new ArrayList<ProductVariant>();
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
	 * @return The label
	 */
	@JsonProperty("label")
	public String getLabel()
	{
		return label;
	}

	/**
	 *
	 * @param label
	 *           The label
	 */
	@JsonProperty("label")
	public void setLabel(final String label)
	{
		this.label = label;
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

	/**
	 *
	 * @return The products
	 */
	@JsonProperty("products")
	public List<ProductVariant> getProducts()
	{
		return products;
	}

	/**
	 *
	 * @param products2
	 *           The products
	 */
	@JsonProperty("products")
	public void setProducts(final List<ProductVariant> products2)
	{
		this.products = products2;
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
			if ("label".equals(name))
			{
				if (value instanceof String)
				{
					setLabel(((String) value));
				}
				else
				{
					throw new IllegalArgumentException(
							("property \"label\" is of type \"java.lang.String\", but got " + value.getClass().toString()));
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
						if ("products".equals(name))
						{
							if (value instanceof List)
							{
								setProducts(((List<ProductVariant>) value));
							}
							else
							{
								throw new IllegalArgumentException(
										("property \"products\" is of type \"java.util.List<com.styla.json.Product_>\", but got "
												+ value.getClass().toString()));
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
			if ("label".equals(name))
			{
				return getLabel();
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
						if ("products".equals(name))
						{
							return getProducts();
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

	@SuppressWarnings(
	{ "unchecked" })
	public <T> T get(final String name)
	{
		final Object value = declaredPropertyOrNotFound(name, Option.NOT_FOUND_VALUE);
		if (Option.NOT_FOUND_VALUE != value)
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
		return new HashCodeBuilder().append(id).append(label).append(price).append(oldPrice).append(products).toHashCode();
	}

	@Override
	public boolean equals(final Object other)
	{
		if (other == this)
		{
			return true;
		}
		if ((other instanceof Option) == false)
		{
			return false;
		}
		final Option rhs = ((Option) other);
		return new EqualsBuilder().append(id, rhs.id).append(label, rhs.label).append(price, rhs.price)
				.append(oldPrice, rhs.oldPrice).append(products, rhs.products).isEquals();
	}

}
