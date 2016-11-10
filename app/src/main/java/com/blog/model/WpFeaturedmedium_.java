package com.blog.model;

/**
 * Created by tosin on 8/13/2016.
 */

import com.blog.model.media.MediaDetails;
import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class WpFeaturedmedium_ implements java.io.Serializable {

    private Integer id;
    private String date;
    private String slug;
    private String type;
    private String link;
    private Integer author;
    @SerializedName("alt_text")
    private String altText;
    @SerializedName("media_type")
    private String mediaType;
    @SerializedName("mime_type")
    private String mimeType;
    @SerializedName("media_details")
    private MediaDetails mediaDetails;
    @SerializedName("source_url")
    private String sourceUrl;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     * The id
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The date
     */
    public String getDate() {
        return date;
    }

    /**
     *
     * @param date
     * The date
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     *
     * @return
     * The slug
     */
    public String getSlug() {
        return slug;
    }

    /**
     *
     * @param slug
     * The slug
     */
    public void setSlug(String slug) {
        this.slug = slug;
    }

    /**
     *
     * @return
     * The type
     */
    public String getType() {
        return type;
    }

    /**
     *
     * @param type
     * The type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     *
     * @return
     * The link
     */
    public String getLink() {
        return link;
    }

    /**
     *
     * @param link
     * The link
     */
    public void setLink(String link) {
        this.link = link;
    }

    /**
     *
     * @return
     * The author
     */
    public Integer getAuthor() {
        return author;
    }

    /**
     *
     * @param author
     * The author
     */
    public void setAuthor(Integer author) {
        this.author = author;
    }

    /**
     *
     * @return
     * The altText
     */
    public String getAltText() {
        return altText;
    }

    /**
     *
     * @param altText
     * The alt_text
     */
    public void setAltText(String altText) {
        this.altText = altText;
    }

    /**
     *
     * @return
     * The mediaType
     */
    public String getMediaType() {
        return mediaType;
    }

    /**
     *
     * @param mediaType
     * The media_type
     */
    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    /**
     *
     * @return
     * The mimeType
     */
    public String getMimeType() {
        return mimeType;
    }

    /**
     *
     * @param mimeType
     * The mime_type
     */
    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    /**
     *
     * @return
     * The mediaDetails
     */
    public MediaDetails getMediaDetails() {
        return mediaDetails;
    }

    /**
     *
     * @param mediaDetails
     * The media_details
     */
    public void setMediaDetails(MediaDetails mediaDetails) {
        this.mediaDetails = mediaDetails;
    }

    /**
     *
     * @return
     * The sourceUrl
     */
    public String getSourceUrl() {
        return sourceUrl;
    }

    /**
     *
     * @param sourceUrl
     * The source_url
     */
    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}