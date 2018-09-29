package com.keanesf.locbook.models.details;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GooglePlaceDetailResponse {

    @SerializedName("html_attributions")
    private List<String> htmlAttributions;

    @SerializedName("result")
    private Place result;

    @SerializedName("status")
    private String status;

    public GooglePlaceDetailResponse(List<String> htmlAttributions, Place result, String status) {
        this.htmlAttributions = htmlAttributions;
        this.result = result;
        this.status = status;
    }

    public List<String> getHtmlAttributions() {
        return htmlAttributions;
    }

    public void setHtmlAttributions(List<String> htmlAttributions) {
        this.htmlAttributions = htmlAttributions;
    }

    public Place getResult() {
        return result;
    }

    public void setResult(Place result) {
        this.result = result;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
