
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
{ "tags", "html", "status" })
public class Seo
{

	@JsonProperty("tags")
	private List<Tag> tags = new ArrayList<Tag>();
	@JsonProperty("html")
	private Html html;
	@JsonProperty("status")
	private Integer status;
	private String titleTag;
	protected final static Object NOT_FOUND_VALUE = new Object();

	/**
	 *
	 * @return The tags
	 */
	@JsonProperty("tags")
	public List<Tag> getTags()
	{
		return tags;
	}

	/**
	 *
	 * @param tags
	 *           The tags
	 */
	@JsonProperty("tags")
	public void setTags(final List<Tag> tags)
	{
		this.tags = tags;
	}

	/**
	 *
	 * @return The html
	 */
	@JsonProperty("html")
	public Html getHtml()
	{
		return html;
	}

	/**
	 *
	 * @param html
	 *           The html
	 */
	@JsonProperty("html")
	public void setHtml(final Html html)
	{
		this.html = html;
	}

	/**
	 *
	 * @return The status
	 */
	@JsonProperty("status")
	public Integer getStatus()
	{
		return status;
	}

	/**
	 *
	 * @param status
	 *           The status
	 */
	@JsonProperty("status")
	public void setStatus(final Integer status)
	{
		this.status = status;
	}

	public String getTitle()
	{
		if (titleTag!=null)
		{
			return titleTag;
		} else
		{
   		if (tags != null)
   		{
   			for (final Tag tag : tags)

   			{
   				if ("title".equals(tag.getTag()))
   				{
   					titleTag = tag.getContent();
   					return titleTag;
   				}
   			}
   		}
		}
		return null;
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
		if ("tags".equals(name))
		{
			if (value instanceof List)
			{
				setTags(((List<Tag>) value));
			}
			else
			{
				throw new IllegalArgumentException(("property \"tags\" is of type \"java.util.List<com.styla.json.Tag>\", but got "
						+ value.getClass().toString()));
			}
			return true;
		}
		else
		{
			if ("html".equals(name))
			{
				if (value instanceof Html)
				{
					setHtml(((Html) value));
				}
				else
				{
					throw new IllegalArgumentException(
							("property \"html\" is of type \"com.styla.json.Html\", but got " + value.getClass().toString()));
				}
				return true;
			}
			else
			{
				if ("status".equals(name))
				{
					if (value instanceof Integer)
					{
						setStatus(((Integer) value));
					}
					else
					{
						throw new IllegalArgumentException(
								("property \"status\" is of type \"java.lang.Integer\", but got " + value.getClass().toString()));
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

	@SuppressWarnings(
	{ "unchecked" })
	protected Object declaredPropertyOrNotFound(final String name, final Object notFoundValue)
	{
		if ("tags".equals(name))
		{
			return getTags();
		}
		else
		{
			if ("html".equals(name))
			{
				return getHtml();
			}
			else
			{
				if ("status".equals(name))
				{
					return getStatus();
				}
				else
				{
					return notFoundValue;
				}
			}
		}
	}

	@SuppressWarnings(
	{ "unchecked" })
	public <T> T get(final String name)
	{
		final Object value = declaredPropertyOrNotFound(name, Seo.NOT_FOUND_VALUE);
		if (Seo.NOT_FOUND_VALUE != value)
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
		return new HashCodeBuilder().append(tags).append(html).append(status).toHashCode();
	}

	@Override
	public boolean equals(final Object other)
	{
		if (other == this)
		{
			return true;
		}
		if ((other instanceof Seo) == false)
		{
			return false;
		}
		final Seo rhs = ((Seo) other);
		return new EqualsBuilder().append(tags, rhs.tags).append(html, rhs.html).append(status, rhs.status).isEquals();
	}

}
