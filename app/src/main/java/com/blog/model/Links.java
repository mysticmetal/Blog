package com.blog.model;

/**
 * Created by tech6 on 4/18/16.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Links implements java.io.Serializable {

    private List<Self> self = new ArrayList<Self>();
    private List<Collection> collection = new ArrayList<Collection>();
    private List<About> about = new ArrayList<About>();
    private List<Author> author = new ArrayList<Author>();
    private List<Reply> replies = new ArrayList<Reply>();
    private List<VersionHistory> versionHistory = new ArrayList<VersionHistory>();
    private List<WpFeaturedmedium> wpFeaturedmedia = new ArrayList<WpFeaturedmedium>();
    private List<WpAttachment> wpAttachment = new ArrayList<WpAttachment>();
    private List<WpTerm> wpTerm = new ArrayList<WpTerm>();
    private List<Cury> curies = new ArrayList<Cury>();
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     * The self
     */
    public List<Self> getSelf() {
        return self;
    }

    /**
     *
     * @param self
     * The self
     */
    public void setSelf(List<Self> self) {
        this.self = self;
    }

    /**
     *
     * @return
     * The collection
     */
    public List<Collection> getCollection() {
        return collection;
    }

    /**
     *
     * @param collection
     * The collection
     */
    public void setCollection(List<Collection> collection) {
        this.collection = collection;
    }

    /**
     *
     * @return
     * The about
     */
    public List<About> getAbout() {
        return about;
    }

    /**
     *
     * @param about
     * The about
     */
    public void setAbout(List<About> about) {
        this.about = about;
    }

    /**
     *
     * @return
     * The author
     */
    public List<Author> getAuthor() {
        return author;
    }

    /**
     *
     * @param author
     * The author
     */
    public void setAuthor(List<Author> author) {
        this.author = author;
    }

    /**
     *
     * @return
     * The replies
     */
    public List<Reply> getReplies() {
        return replies;
    }

    /**
     *
     * @param replies
     * The replies
     */
    public void setReplies(List<Reply> replies) {
        this.replies = replies;
    }

    /**
     *
     * @return
     * The versionHistory
     */
    public List<VersionHistory> getVersionHistory() {
        return versionHistory;
    }

    /**
     *
     * @param versionHistory
     * The version-history
     */
    public void setVersionHistory(List<VersionHistory> versionHistory) {
        this.versionHistory = versionHistory;
    }

    /**
     *
     * @return
     * The wpFeaturedmedia
     */
    public List<WpFeaturedmedium> getWpFeaturedmedia() {
        return wpFeaturedmedia;
    }

    /**
     *
     * @param wpFeaturedmedia
     * The wp:featuredmedia
     */
    public void setWpFeaturedmedia(List<WpFeaturedmedium> wpFeaturedmedia) {
        this.wpFeaturedmedia = wpFeaturedmedia;
    }

    /**
     *
     * @return
     * The wpAttachment
     */
    public List<WpAttachment> getWpAttachment() {
        return wpAttachment;
    }

    /**
     *
     * @param wpAttachment
     * The wp:attachment
     */
    public void setWpAttachment(List<WpAttachment> wpAttachment) {
        this.wpAttachment = wpAttachment;
    }

    /**
     *
     * @return
     * The wpTerm
     */
    public List<WpTerm> getWpTerm() {
        return wpTerm;
    }

    /**
     *
     * @param wpTerm
     * The wp:term
     */
    public void setWpTerm(List<WpTerm> wpTerm) {
        this.wpTerm = wpTerm;
    }

    /**
     *
     * @return
     * The curies
     */
    public List<Cury> getCuries() {
        return curies;
    }

    /**
     *
     * @param curies
     * The curies
     */
    public void setCuries(List<Cury> curies) {
        this.curies = curies;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}