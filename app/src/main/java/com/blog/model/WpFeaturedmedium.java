package com.blog.model;

/**
 * Created by tech6 on 4/18/16.
 */

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class WpFeaturedmedium implements java.io.Serializable {

    private Boolean embeddable;
    private String href;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     * The embeddable
     */
    public Boolean getEmbeddable() {
        return embeddable;
    }

    /**
     *
     * @param embeddable
     * The embeddable
     */
    public void setEmbeddable(Boolean embeddable) {
        this.embeddable = embeddable;
    }

    /**
     *
     * @return
     * The href
     */
    public String getHref() {
        return href;
    }

    /**
     *
     * @param href
     * The href
     */
    public void setHref(String href) {
        this.href = href;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}