
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
{ "id", "name", "image", "children" })
public class Category
{

	@JsonProperty("id")
	private String id;
	@JsonProperty("name")
	private String name;
	@JsonProperty("image")
	private String image;
	@JsonProperty("children")
	private List<Category> children = new ArrayList<Category>();
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
	 * @return The children
	 */
	@JsonProperty("children")
	public List<Category> getChildren()
	{
		return children;
	}

	/**
	 *
	 * @param list
	 *           The children
	 */
	@JsonProperty("children")
	public void setChildren(final List<Category> list)
	{
		this.children = list;
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
					if ("children".equals(name))
					{
						if (value instanceof List)
						{
							setChildren(((List<Category>) value));
						}
						else
						{
							throw new IllegalArgumentException(
									("property \"children\" is of type \"java.util.List<com.styla.json.Child>\", but got "
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
				if ("image".equals(name))
				{
					return getImage();
				}
				else
				{
					if ("children".equals(name))
					{
						return getChildren();
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
		final Object value = declaredPropertyOrNotFound(name, Category.NOT_FOUND_VALUE);
		if (Category.NOT_FOUND_VALUE != value)
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
		return new HashCodeBuilder().append(id).append(name).append(image).append(children).toHashCode();
	}

	@Override
	public boolean equals(final Object other)
	{
		if (other == this)
		{
			return true;
		}
		if ((other instanceof Category) == false)
		{
			return false;
		}
		final Category rhs = ((Category) other);
		return new EqualsBuilder().append(id, rhs.id).append(name, rhs.name).append(image, rhs.image).append(children, rhs.children)
				.isEquals();
	}

}
