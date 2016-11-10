package com.blog.model;

/**
 * Created by tech6 on 4/18/16.
 */
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Wp implements java.io.Serializable {

    private Integer id;
    private String date;
    @SerializedName("date_gmt")
    private String dateGmt;
    private Guid guid;
    private String modified;
    @SerializedName("modified_gmt")
    private String modifiedGmt;
    private String slug;
    private String type;
    private String link;
    private Title title;
    private Content content;
    private Excerpt excerpt;
    private Integer author;
    @SerializedName("featured_media")
    private Integer featuredMedia;
    @SerializedName("comment_status")
    private String commentStatus;
    @SerializedName("ping_status")
    private String pingStatus;
    private Boolean sticky;
    private String format;
    private List<Integer> categories = new ArrayList<Integer>();
    private List<Object> tags = new ArrayList<Object>();
    private com.blog.model.Links Links;
    @SerializedName("_embedded")
    private Embedded embedded;
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
     * The date_gmt
     */
    public String getDateGmt() {
        return dateGmt;
    }

    /**
     *
     * @param date_gmt
     * The date_gmt
     */
    public void setDateGmt(String dateGmt) {
        this.dateGmt = dateGmt;
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
        return modifiedGmt;
    }

    /**
     *
     * @param modifiedGmt
     * The modified_gmt
     */
    public void setModifiedGmt(String modifiedGmt) {
        this.modifiedGmt = modifiedGmt;
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
     * The content
     */
    public Content getContent() {
        return content;
    }

    /**
     *
     * @param content
     * The content
     */
    public void setContent(Content content) {
        this.content = content;
    }

    /**
     *
     * @return
     * The excerpt
     */
    public Excerpt getExcerpt() {
        return excerpt;
    }

    /**
     *
     * @param excerpt
     * The excerpt
     */
    public void setExcerpt(Excerpt excerpt) {
        this.excerpt = excerpt;
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
     * The featuredMedia
     */
    public Integer getFeaturedMedia() {
        return featuredMedia;
    }

    /**
     *
     * @param featuredMedia
     * The featured_media
     */
    public void setFeaturedMedia(Integer featuredMedia) {
        this.featuredMedia = featuredMedia;
    }

    /**
     *
     * @return
     * The commentStatus
     */
    public String getCommentStatus() {
        return commentStatus;
    }

    /**
     *
     * @param commentStatus
     * The comment_status
     */
    public void setCommentStatus(String commentStatus) {
        this.commentStatus = commentStatus;
    }

    /**
     *
     * @return
     * The pingStatus
     */
    public String getPingStatus() {
        return pingStatus;
    }

    /**
     *
     * @param pingStatus
     * The ping_status
     */
    public void setPingStatus(String pingStatus) {
        this.pingStatus = pingStatus;
    }

    /**
     *
     * @return
     * The sticky
     */
    public Boolean getSticky() {
        return sticky;
    }

    /**
     *
     * @param sticky
     * The sticky
     */
    public void setSticky(Boolean sticky) {
        this.sticky = sticky;
    }

    /**
     *
     * @return
     * The format
     */
    public String getFormat() {
        return format;
    }

    /**
     *
     * @param format
     * The format
     */
    public void setFormat(String format) {
        this.format = format;
    }

    /**
     *
     * @return
     * The categories
     */
    public List<Integer> getCategories() {
        return categories;
    }

    /**
     *
     * @param categories
     * The categories
     */
    public void setCategories(List<Integer> categories) {
        this.categories = categories;
    }

    /**
     *
     * @return
     * The tags
     */
    public List<Object> getTags() {
        return tags;
    }

    /**
     *
     * @param tags
     * The tags
     */
    public void setTags(List<Object> tags) {
        this.tags = tags;
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

    /**
     *
     * @return
     * The embedded
     */
    public Embedded getEmbedded() {
        return embedded;
    }

    /**
     *
     * @param embedded
     * The _embedded
     */
    public void setEmbedded(Embedded embedded) {
        this.embedded = embedded;
    }


    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}