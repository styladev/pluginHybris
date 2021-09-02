
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
    "head",
    "body"
})
public class Html {

    @JsonProperty("head")
    private String head;
    @JsonProperty("body")
    private String body;
    protected final static Object NOT_FOUND_VALUE = new Object();

    /**
     * 
     * @return
     *     The head
     */
    @JsonProperty("head")
    public String getHead() {
        return head;
    }

    /**
     * 
     * @param head
     *     The head
     */
    @JsonProperty("head")
    public void setHead(String head) {
        this.head = head;
    }

    /**
     * 
     * @return
     *     The body
     */
    @JsonProperty("body")
    public String getBody() {
        return body;
    }

    /**
     * 
     * @param body
     *     The body
     */
    @JsonProperty("body")
    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @SuppressWarnings({
        "unchecked"
    })
    protected boolean declaredProperty(String name, Object value) {
        if ("head".equals(name)) {
            if (value instanceof String) {
                setHead(((String) value));
            } else {
                throw new IllegalArgumentException(("property \"head\" is of type \"java.lang.String\", but got "+ value.getClass().toString()));
            }
            return true;
        } else {
            if ("body".equals(name)) {
                if (value instanceof String) {
                    setBody(((String) value));
                } else {
                    throw new IllegalArgumentException(("property \"body\" is of type \"java.lang.String\", but got "+ value.getClass().toString()));
                }
                return true;
            } else {
                return false;
            }
        }
    }

    @SuppressWarnings({
        "unchecked"
    })
    protected Object declaredPropertyOrNotFound(String name, Object notFoundValue) {
        if ("head".equals(name)) {
            return getHead();
        } else {
            if ("body".equals(name)) {
                return getBody();
            } else {
                return notFoundValue;
            }
        }
    }

    @SuppressWarnings({
        "unchecked"
    })
    public<T >T get(String name) {
        Object value = declaredPropertyOrNotFound(name, Html.NOT_FOUND_VALUE);
        if (Html.NOT_FOUND_VALUE!= value) {
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
        return new HashCodeBuilder().append(head).append(body).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Html) == false) {
            return false;
        }
        Html rhs = ((Html) other);
        return new EqualsBuilder().append(head, rhs.head).append(body, rhs.body).isEquals();
    }

}
