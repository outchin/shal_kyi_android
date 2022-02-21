
package com.oxoo.spagreen.models.single_details_tv;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.oxoo.spagreen.models.home_content.Slider;

public class SingleDetailsTV {

    @SerializedName("live_tv_id")
    @Expose
    private String liveTvId;

    @SerializedName("slider_details")
    @Expose
    private Slider slider_details;



    @SerializedName("tv_name")
    @Expose
    private String tvName;

    @SerializedName("expire_date")
    @Expose
    private String expire_date;

    @SerializedName("is_free_user")
    @Expose
    private boolean is_free_user;

    @SerializedName("is_eighteen")
    @Expose
    private String is_eighteen;




    public String getExpire_date() {
        return expire_date;
    }

    public void setExpire_date(String expire_date) {
        this.expire_date = expire_date;
    }

    public boolean isIs_free_user() {
        return is_free_user;
    }

    public void setIs_free_user(boolean is_free_user) {
        this.is_free_user = is_free_user;
    }

    @SerializedName("is_paid")
    @Expose
    private String isPaid;

    public String getIs_eighteen() {
        return is_eighteen;
    }

    public void setIs_eighteen(String is_eighteen) {
        this.is_eighteen = is_eighteen;
    }

    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("slug")
    @Expose
    private String slug;
    @SerializedName("stream_from")
    @Expose
    private String streamFrom;
    @SerializedName("stream_label")
    @Expose
    private String streamLabel;
    @SerializedName("stream_url")
    @Expose
    private String streamUrl;
    @SerializedName("thumbnail_url")
    @Expose
    private String thumbnailUrl;
    @SerializedName("poster_url")
    @Expose
    private String posterUrl;
    @SerializedName("additional_media_source")
    @Expose
    private List<AdditionalMediaSource> additionalMediaSource = null;
    @SerializedName("all_tv_channel")
    @Expose
    private List<AllTvChannel> allTvChannel = null;
    @SerializedName("current_program_title")
    @Expose
    private String currentProgramTitle;
    @SerializedName("current_program_time")
    @Expose
    private String currentProgramTime;
    @SerializedName("program_guide")
    @Expose
    private List<ProgramGuide> programGuide = null;

    public String getLiveTvId() {
        return liveTvId;
    }

    public void setLiveTvId(String liveTvId) {
        this.liveTvId = liveTvId;
    }

    public String getTvName() {
        return tvName;
    }

    public void setTvName(String tvName) {
        this.tvName = tvName;
    }

    public String getIsPaid() {
        return isPaid;
    }

    public void setIsPaid(String isPaid) {
        this.isPaid = isPaid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getStreamFrom() {
        return streamFrom;
    }

    public void setStreamFrom(String streamFrom) {
        this.streamFrom = streamFrom;
    }

    public String getStreamLabel() {
        return streamLabel;
    }

    public void setStreamLabel(String streamLabel) {
        this.streamLabel = streamLabel;
    }

    public String getStreamUrl() {
        return streamUrl;
    }

    public void setStreamUrl(String streamUrl) {
        this.streamUrl = streamUrl;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }

    public List<AdditionalMediaSource> getAdditionalMediaSource() {
        return additionalMediaSource;
    }

    public void setAdditionalMediaSource(List<AdditionalMediaSource> additionalMediaSource) {
        this.additionalMediaSource = additionalMediaSource;
    }

    public List<AllTvChannel> getAllTvChannel() {
        return allTvChannel;
    }

    public void setAllTvChannel(List<AllTvChannel> allTvChannel) {
        this.allTvChannel = allTvChannel;
    }

    public String getCurrentProgramTitle() {
        return currentProgramTitle;
    }

    public void setCurrentProgramTitle(String currentProgramTitle) {
        this.currentProgramTitle = currentProgramTitle;
    }

    public String getCurrentProgramTime() {
        return currentProgramTime;
    }

    public void setCurrentProgramTime(String currentProgramTime) {
        this.currentProgramTime = currentProgramTime;
    }

    public List<ProgramGuide> getProgramGuide() {
        return programGuide;
    }

    public void setProgramGuide(List<ProgramGuide> programGuide) {
        this.programGuide = programGuide;
    }

    public Slider getSlider_details() {
        return slider_details;
    }
    public void setSlider_details(Slider slider_details) {
        this.slider_details = slider_details;
    }

}