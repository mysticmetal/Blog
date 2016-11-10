package com.blog.model;

/**
 * Created by tech6 on 4/18/16.
 */

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Excerpt implements java.io.Serializable {

    private String rendered;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     * The rendered
     */
    public String getRendered() {
        return rendered;
    }

    /**
     *
     * @param rendered
     * The rendered
     */
    public void setRendered(String rendered) {
        this.rendered = rendered;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}