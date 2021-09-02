
package com.styla.json;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "tag",
    "attributes",
    "content"
})
public class Tag {

    @JsonProperty("tag")
    private String tag;
    @JsonProperty("attributes")
    private Attributes attributes;
    @JsonProperty("content")
    private String content;
    protected final static Object NOT_FOUND_VALUE = new Object();

    /**
     * 
     * @return
     *     The tag
     */
    @JsonProperty("tag")
    public String getTag() {
        return tag;
    }

    /**
     * 
     * @param tag
     *     The tag
     */
    @JsonProperty("tag")
    public void setTag(String tag) {
        this.tag = tag;
    }

    /**
     * 
     * @return
     *     The attributes
     */
    @JsonProperty("attributes")
    public Attributes getAttributes() {
        return attributes;
    }

    /**
     * 
     * @param attributes
     *     The attributes
     */
    @JsonProperty("attributes")
    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }

    /**
     * 
     * @return
     *     The content
     */
    @JsonProperty("content")
    public String getContent() {
        return content;
    }

    /**
     * 
     * @param content
     *     The content
     */
    @JsonProperty("content")
    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @SuppressWarnings({
        "unchecked"
    })
    protected boolean declaredProperty(String name, Object value) {
        if ("tag".equals(name)) {
            if (value instanceof String) {
                setTag(((String) value));
            } else {
                throw new IllegalArgumentException(("property \"tag\" is of type \"java.lang.String\", but got "+ value.getClass().toString()));
            }
            return true;
        } else {
            if ("attributes".equals(name)) {
                if (value instanceof Attributes) {
                    setAttributes(((Attributes) value));
                } else {
                    throw new IllegalArgumentException(("property \"attributes\" is of type \"com.styla.json.Attributes\", but got "+ value.getClass().toString()));
                }
                return true;
            } else {
                if ("content".equals(name)) {
                    if (value instanceof String) {
                        setContent(((String) value));
                    } else {
                        throw new IllegalArgumentException(("property \"content\" is of type \"java.lang.String\", but got "+ value.getClass().toString()));
                    }
                    return true;
                } else {
                    return false;
                }
            }
        }
    }

    @SuppressWarnings({
        "unchecked"
    })
    protected Object declaredPropertyOrNotFound(String name, Object notFoundValue) {
        if ("tag".equals(name)) {
            return getTag();
        } else {
            if ("attributes".equals(name)) {
                return getAttributes();
            } else {
                if ("content".equals(name)) {
                    return getContent();
                } else {
                    return notFoundValue;
                }
            }
        }
    }

    @SuppressWarnings({
        "unchecked"
    })
    public<T >T get(String name) {
        Object value = declaredPropertyOrNotFound(name, Tag.NOT_FOUND_VALUE);
        if (Tag.NOT_FOUND_VALUE!= value) {
            return ((T) value);
        } else {
            throw new IllegalArgumentException((("property \""+ name)+"\" is not defined"));
        }
    }

    @SuppressWarnings({
        "unchecked"
    })
    public void set(String name, Object value) {
        if (!declaredProperty(name, value)) {
            throw new IllegalArgumentException((("property \""+ name)+"\" is not defined"));
        }
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(tag).append(attributes).append(content).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Tag) == false) {
            return false;
        }
        Tag rhs = ((Tag) other);
        return new EqualsBuilder().append(tag, rhs.tag).append(attributes, rhs.attributes).append(content, rhs.content).isEquals();
    }

}
