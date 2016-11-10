package com.blog.model.media;

/**
 * Created by tosin on 8/18/2016.
 */
import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Sizes implements java.io.Serializable {

    private Thumbnail thumbnail;
    private Medium medium;
    @SerializedName("post-thumbnail")
    private PostThumbnail postThumbnail;
    private Full full;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     * The thumbnail
     */
    public Thumbnail getThumbnail() {
        return thumbnail;
    }

    /**
     *
     * @param thumbnail
     * The thumbnail
     */
    public void setThumbnail(Thumbnail thumbnail) {
        this.thumbnail = thumbnail;
    }

    /**
     *
     * @return
     * The medium
     */
    public Medium getMedium() {
        return medium;
    }

    /**
     *
     * @param medium
     * The medium
     */
    public void setMedium(Medium medium) {
        this.medium = medium;
    }

    /**
     *
     * @return
     * The postThumbnail
     */
    public PostThumbnail getPostThumbnail() {
        return postThumbnail;
    }

    /**
     *post-thumbnail
     * @param postThumbnail
     * The
     */
    public void setPostThumbnail(PostThumbnail postThumbnail) {
        this.postThumbnail = postThumbnail;
    }

    /**
     *
     * @return
     * The full
     */
    public Full getFull() {
        return full;
    }

    /**
     *
     * @param full
     * The full
     */
    public void setFull(Full full) {
        this.full = full;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}

