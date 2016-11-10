package com.blog.model.media;

/**
 * Created by Tosin Onikute on 4/20/16.
 */

import com.blog.model.Guid;
import com.blog.model.Title;
import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Media implements java.io.Serializable {

    private Integer id;
    private String date;
    private String date_gmt;
    private Guid guid;
    private String modified;
    private String modified_gmt;
    private String slug;
    private String type;
    private String link;
    private Title title;
    private Integer author;
    @SerializedName("commentStatus")
    private String comment_status;
    @SerializedName("pingStatus")
    private String ping_status;
    private String altText;
    private String caption;
    private String description;
    @SerializedName("media_type")
    private String mediaType;
    @SerializedName("mime_type")
    private String mimeType;
    @SerializedName("media_details")
    private MediaDetails mediaDetails;
    private Object post;
    @SerializedName("source_url")
    private String sourceUrl;
    private com.blog.model.Links Links;
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
     * The dateGmt
     */
    public String getDateGmt() {
        return date_gmt;
    }

    /**
     *
     * @param dateGmt
     * The date_gmt
     */
    public void setDateGmt(String dateGmt) {
        this.date_gmt = date_gmt;
    }

    /**
     *
     * @return
     * The guid
     */
    public Guid getGuid() {
        return guid;
    }

    /**
     *
     * @param guid
     * The guid
     */
    public void setGuid(Guid guid) {
        this.guid = guid;
    }

    /**
     *
     * @return
     * The modified
     */
    public String getModified() {
        return modified;
    }

    /**
     *
     * @param modified
     * The modified
     */
    public void setModified(String modified) {
        this.modified = modified;
    }

    /**
     *
     * @return
     * The modifiedGmt
     */
    public String getModifiedGmt() {
        return modified_gmt;
    }

    /**
     *
     * @param modifiedGmt
     * The modified_gmt
     */
    public void setModifiedGmt(String modified_gmt) {
        this.modified_gmt = modified_gmt;
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
     * The title
     */
    public Title getTitle() {
        return title;
    }

    /**
     *
     * @param title
     * The title
     */
    public void setTitle(Title title) {
        this.title = title;
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
     * The commentStatus
     */
    public String getCommentStatus() {
        return comment_status;
    }

    /**
     *
     * @param commentStatus
     * The comment_status
     */
    public void setCommentStatus(String comment_status) {
        this.comment_status = comment_status;
    }

    /**
     *
     * @return
     * The pingStatus
     */
    public String getPingStatus() {
        return ping_status;
    }

    /**
     *
     * @param pingStatus
     * The ping_status
     */
    public void setPingStatus(String pingStatus) {
        this.ping_status = pingStatus;
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
     * The caption
     */
    public String getCaption() {
        return caption;
    }

    /**
     *
     * @param caption
     * The caption
     */
    public void setCaption(String caption) {
        this.caption = caption;
    }

    /**
     *
     * @return
     * The description
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description
     * The description
     */
    public void setDescription(String description) {
        this.description = description;
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
     * The post
     */
    public Object getPost() {
        return post;
    }

    /**
     *
     * @param post
     * The post
     */
    public void setPost(Object post) {
        this.post = post;
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

    /**
     *
     * @return
     * The Links
     */
    public com.blog.model.Links getLinks() {
        return Links;
    }

    /**
     *
     * @param Links
     * The _links
     */
    public void setLinks(com.blog.model.Links Links) {
        this.Links = Links;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
