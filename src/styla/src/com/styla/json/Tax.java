
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
{ "rate", "label", "taxIncluded", "showLabel" })
public class Tax
{

	@JsonProperty("rate")
	private String rate;
	@JsonProperty("label")
	private String label;
	@JsonProperty("taxIncluded")
	private String taxIncluded;
	@JsonProperty("showLabel")
	private Boolean showLabel;
	protected final static Object NOT_FOUND_VALUE = new Object();

	/**
	 * 
	 * @return The rate
	 */
	@JsonProperty("rate")
	public String getRate()
	{
		return rate;
	}

	/**
	 * 
	 * @param rate
	 *           The rate
	 */
	@JsonProperty("rate")
	public void setRate(final String rate)
	{
		this.rate = rate;
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
	 * @return The taxIncluded
	 */
	@JsonProperty("taxIncluded")
	public String getTaxIncluded()
	{
		return taxIncluded;
	}

	/**
	 * 
	 * @param taxIncluded
	 *           The taxIncluded
	 */
	@JsonProperty("taxIncluded")
	public void setTaxIncluded(final String taxIncluded)
	{
		this.taxIncluded = taxIncluded;
	}

	/**
	 * 
	 * @return The showLabel
	 */
	@JsonProperty("showLabel")
	public Boolean getShowLabel()
	{
		return showLabel;
	}

	/**
	 * 
	 * @param showLabel
	 *           The showLabel
	 */
	@JsonProperty("showLabel")
	public void setShowLabel(final Boolean showLabel)
	{
		this.showLabel = showLabel;
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
		if ("rate".equals(name))
		{
			if (value instanceof String)
			{
				setRate(((String) value));
			}
			else
			{
				throw new IllegalArgumentException(
						("property \"rate\" is of type \"java.lang.String\", but got " + value.getClass().toString()));
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
				if ("taxIncluded".equals(name))
				{
					if (value instanceof String)
					{
						setTaxIncluded(((String) value));
					}
					else
					{
						throw new IllegalArgumentException(
								("property \"taxIncluded\" is of type \"java.lang.String\", but got " + value.getClass().toString()));
					}
					return true;
				}
				else
				{
					if ("showLabel".equals(name))
					{
						if (value instanceof Boolean)
						{
							setShowLabel(((Boolean) value));
						}
						else
						{
							throw new IllegalArgumentException(
									("property \"showLabel\" is of type \"java.lang.String\", but got " + value.getClass().toString()));
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
		if ("rate".equals(name))
		{
			return getRate();
		}
		else
		{
			if ("label".equals(name))
			{
				return getLabel();
			}
			else
			{
				if ("taxIncluded".equals(name))
				{
					return getTaxIncluded();
				}
				else
				{
					if ("showLabel".equals(name))
					{
						return getShowLabel();
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
		final Object value = declaredPropertyOrNotFound(name, Tax.NOT_FOUND_VALUE);
		if (Tax.NOT_FOUND_VALUE != value)
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
		return new HashCodeBuilder().append(rate).append(label).append(taxIncluded).append(showLabel).toHashCode();
	}

	@Override
	public boolean equals(final Object other)
	{
		if (other == this)
		{
			return true;
		}
		if ((other instanceof Tax) == false)
		{
			return false;
		}
		final Tax rhs = ((Tax) other);
		return new EqualsBuilder().append(rate, rhs.rate).append(label, rhs.label).append(taxIncluded, rhs.taxIncluded)
				.append(showLabel, rhs.showLabel).isEquals();
	}

}
