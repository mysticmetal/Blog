package com.blog.model;

/**
 * Created by tosin on 8/13/2016.
 */
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Embedded implements java.io.Serializable {

    private List<Author_> author = new ArrayList<Author_>();
    @SerializedName("wp:featuredmedia")
    private List<WpFeaturedmedium_> wpFeaturedmedia = new ArrayList<WpFeaturedmedium_>();
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     * The author
     */
    public List<Author_> getAuthor() {
        return author;
    }

    /**
     *
     * @param author
     * The author
     */
    public void setAuthor(List<Author_> author) {
        this.author = author;
    }

    /**
     *
     * @return
     * The wpFeaturedmedia
     */
    public List<WpFeaturedmedium_> getWpFeaturedmedia() {
        return wpFeaturedmedia;
    }

    /**
     *
     * @param wpFeaturedmedia
     * The wp:featuredmedia
     */
    public void setWpFeaturedmedia(List<WpFeaturedmedium_> wpFeaturedmedia) {
        this.wpFeaturedmedia = wpFeaturedmedia;
    }


    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
