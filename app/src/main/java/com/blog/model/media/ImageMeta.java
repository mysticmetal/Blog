package com.blog.model.media;

/**
 * Created by Tosin Onikute on 4/20/16.
 */
import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class ImageMeta implements java.io.Serializable {

    public Integer aperture;
    public String credit;
    public String camera;
    public String caption;
    @SerializedName("created_timestamp")
    public Integer createdTimestamp;
    public String copyright;
    @SerializedName("focal_length")
    public Integer focalLength;
    public Integer iso;
    @SerializedName("shutter_speed")
    public Integer shutterSpeed;
    public String title;
    public Integer orientation;
    public Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     * The aperture
     */
    public Integer getAperture() {
        return aperture;
    }

    /**
     *
     * @param aperture
     * The aperture
     */
    public void setAperture(Integer aperture) {
        this.aperture = aperture;
    }

    /**
     *
     * @return
     * The credit
     */
    public String getCredit() {
        return credit;
    }

    /**
     *
     * @param credit
     * The credit
     */
    public void setCredit(String credit) {
        this.credit = credit;
    }

    /**
     *
     * @return
     * The camera
     */
    public String getCamera() {
        return camera;
    }

    /**
     *
     * @param camera
     * The camera
     */
    public void setCamera(String camera) {
        this.camera = camera;
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
     * The createdTimestamp
     */
    public Integer getCreatedTimestamp() {
        return createdTimestamp;
    }

    /**
     *
     * @param createdTimestamp
     * The created_timestamp
     */
    public void setCreatedTimestamp(Integer createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
    }

    /**
     *
     * @return
     * The copyright
     */
    public String getCopyright() {
        return copyright;
    }

    /**
     *
     * @param copyright
     * The copyright
     */
    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    /**
     *
     * @return
     * The focalLength
     */
    public Integer getFocalLength() {
        return focalLength;
    }

    /**
     *
     * @param focalLength
     * The focal_length
     */
    public void setFocalLength(Integer focalLength) {
        this.focalLength = focalLength;
    }

    /**
     *
     * @return
     * The iso
     */
    public Integer getIso() {
        return iso;
    }

    /**
     *
     * @param iso
     * The iso
     */
    public void setIso(Integer iso) {
        this.iso = iso;
    }

    /**
     *
     * @return
     * The shutterSpeed
     */
    public Integer getShutterSpeed() {
        return shutterSpeed;
    }

    /**
     *
     * @param shutterSpeed
     * The shutter_speed
     */
    public void setShutterSpeed(Integer shutterSpeed) {
        this.shutterSpeed = shutterSpeed;
    }

    /**
     *
     * @return
     * The title
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @param title
     * The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     *
     * @return
     * The orientation
     */
    public Integer getOrientation() {
        return orientation;
    }

    /**
     *
     * @param orientation
     * The orientation
     */
    public void setOrientation(Integer orientation) {
        this.orientation = orientation;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}