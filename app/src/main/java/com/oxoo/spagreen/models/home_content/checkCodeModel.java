
package com.oxoo.spagreen.models.home_content;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class checkCodeModel {







    @SerializedName("code")
    @Expose
    private String code;

    @SerializedName("device_id")
    @Expose
    private String device_id;

    @SerializedName("registration_end_at")
    @Expose
    private String registration_end_at;

    public String getRegistration_end_at() {
        return registration_end_at;
    }

    public void setRegistration_end_at(String registration_end_at) {
        this.registration_end_at = registration_end_at;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDevice_id() {
        return device_id;
    }

    public void setDevice_id(String device_id) {
        this.device_id = device_id;
    }
}
