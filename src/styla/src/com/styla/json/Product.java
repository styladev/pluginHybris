
package com.styla.json;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Generated("org.jsonschema2pojo")
public class Product
{
	@JsonProperty("id")
	private String id;
	@JsonProperty("name")
	private String name;
	@JsonProperty("description")
	private String description;
	@JsonProperty("categories")
	private List<String> categories;
	@JsonProperty("saleable")
	private Boolean saleable;
	@JsonProperty("price")
	private String price;
	@JsonProperty("priceTemplate")
	private String priceTemplate;
	@JsonProperty("oldPrice")
	private String oldPrice;
	@JsonProperty("minqty")
	private String minqty;
	@JsonProperty("maxqty")
	private String maxqty;
	@JsonProperty("tax")
	private Tax tax;
	@JsonProperty("attributes")
	private List<Attribute> attributes = new ArrayList<Attribute>();
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
	 * @return The name
	 */
	@JsonProperty("name")
	public String getName()
	{
		return name;
	}

	/**
	 *
	 * @param name
	 *           The name
	 */
	@JsonProperty("name")
	public void setName(final String name)
	{
		this.name = name;
	}

	/**
	 * @return The description
	 */
	public String getDescription()
	{
		return description;
	}

	/**
	 * @param description
	 *           The description to set
	 */
	@JsonProperty("description")
	public void setDescription(final String description)
	{
		this.description = description;
	}

	/**
	 * @return The categories
	 */
	public List<String> getCategories()
	{
		return categories;
	}

	/**
	 * @param categories
	 *           The categories to set
	 */
	@JsonProperty("categories")
	public void setCategories(final List<String> categories)
	{
		this.categories = categories;
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
	 * @return The priceTemplate
	 */
	@JsonProperty("priceTemplate")
	public String getPriceTemplate()
	{
		return priceTemplate;
	}

	/**
	 *
	 * @param priceTemplate
	 *           The priceTemplate
	 */
	@JsonProperty("priceTemplate")
	public void setPriceTemplate(final String priceTemplate)
	{
		this.priceTemplate = priceTemplate;
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
	 * @return The minqty
	 */
	@JsonProperty("minqty")
	public String getMinqty()
	{
		return minqty;
	}

	/**
	 *
	 * @param minqty
	 *           The minqty
	 */
	@JsonProperty("minqty")
	public void setMinqty(final String minqty)
	{
		this.minqty = minqty;
	}

	/**
	 *
	 * @return The maxqty
	 */
	@JsonProperty("maxqty")
	public String getMaxqty()
	{
		return maxqty;
	}

	/**
	 *
	 * @param maxqty
	 *           The maxqty
	 */
	@JsonProperty("maxqty")
	public void setMaxqty(final String maxqty)
	{
		this.maxqty = maxqty;
	}

	/**
	 *
	 * @return The tax
	 */
	@JsonProperty("tax")
	public Tax getTax()
	{
		return tax;
	}

	/**
	 *
	 * @param tax
	 *           The tax
	 */
	@JsonProperty("tax")
	public void setTax(final Tax tax)
	{
		this.tax = tax;
	}

	/**
	 *
	 * @return The attributes
	 */
	@JsonProperty("attributes")
	public List<Attribute> getAttributes()
	{
		return attributes;
	}

	/**
	 *
	 * @param attributes
	 *           The attributes
	 */
	@JsonProperty("attributes")
	public void setAttributes(final List<Attribute> attributes)
	{
		this.attributes = attributes;
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
			if ("name".equals(name))
			{
				if (value instanceof String)
				{
					setName(((String) value));
				}
				else
				{
					throw new IllegalArgumentException(
							("property \"name\" is of type \"java.lang.String\", but got " + value.getClass().toString()));
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
						if ("priceTemplate".equals(name))
						{
							if (value instanceof String)
							{
								setPriceTemplate(((String) value));
							}
							else
							{
								throw new IllegalArgumentException(("property \"priceTemplate\" is of type \"java.lang.String\", but got "
										+ value.getClass().toString()));
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
									throw new IllegalArgumentException(("property \"oldPrice\" is of type \"java.lang.String\", but got "
											+ value.getClass().toString()));
								}
								return true;
							}
							else
							{
								if ("minqty".equals(name))
								{
									if (value instanceof String)
									{
										setMinqty(((String) value));
									}
									else
									{
										throw new IllegalArgumentException(("property \"minqty\" is of type \"java.lang.String\", but got "
												+ value.getClass().toString()));
									}
									return true;
								}
								else
								{
									if ("maxqty".equals(name))
									{
										if (value instanceof String)
										{
											setMaxqty(((String) value));
										}
										else
										{
											throw new IllegalArgumentException(
													("property \"maxqty\" is of type \"java.lang.String\", but got "
															+ value.getClass().toString()));
										}
										return true;
									}
									else
									{
										if ("tax".equals(name))
										{
											if (value instanceof Tax)
											{
												setTax(((Tax) value));
											}
											else
											{
												throw new IllegalArgumentException(
														("property \"tax\" is of type \"com.styla.json.Tax\", but got "
																+ value.getClass().toString()));
											}
											return true;
										}
										else
										{
											if ("attributes".equals(name))
											{
												if (value instanceof List)
												{
													setAttributes(((List<Attribute>) value));
												}
												else
												{
													throw new IllegalArgumentException(
															("property \"attributes\" is of type \"java.util.List<com.styla.json.Attribute>\", but got "
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
			if ("name".equals(name))
			{
				return getName();
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
						if ("priceTemplate".equals(name))
						{
							return getPriceTemplate();
						}
						else
						{
							if ("oldPrice".equals(name))
							{
								return getOldPrice();
							}
							else
							{
								if ("minqty".equals(name))
								{
									return getMinqty();
								}
								else
								{
									if ("maxqty".equals(name))
									{
										return getMaxqty();
									}
									else
									{
										if ("tax".equals(name))
										{
											return getTax();
										}
										else
										{
											if ("attributes".equals(name))
											{
												return getAttributes();
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
				}
			}
		}
	}

	@SuppressWarnings(
	{ "unchecked" })
	public <T> T get(final String name)
	{
		final Object value = declaredPropertyOrNotFound(name, Product.NOT_FOUND_VALUE);
		if (Product.NOT_FOUND_VALUE != value)
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
		return new HashCodeBuilder().append(id).append(name).append(saleable).append(price).append(priceTemplate).append(oldPrice)
				.append(minqty).append(maxqty).append(tax).append(attributes).toHashCode();
	}

	@Override
	public boolean equals(final Object other)
	{
		if (other == this)
		{
			return true;
		}
		if ((other instanceof Product) == false)
		{
			return false;
		}
		final Product rhs = ((Product) other);
		return new EqualsBuilder().append(id, rhs.id).append(name, rhs.name).append(description, rhs.description)
				.append(categories, rhs.categories).append(saleable, rhs.saleable).append(price, rhs.price)
				.append(priceTemplate, rhs.priceTemplate).append(oldPrice, rhs.oldPrice).append(minqty, rhs.minqty)
				.append(maxqty, rhs.maxqty).append(tax, rhs.tax).append(attributes, rhs.attributes).isEquals();
	}

}
