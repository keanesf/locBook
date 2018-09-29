package com.keanesf.locbook.models.search;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GooglePlaceResponse<T> {

    @SerializedName("html_attributions")
    private List<String> htmlAttributions;

    @SerializedName("next_page_token")
    private String nextPageToken;

    @SerializedName("results")
    private List<T> results;

    @SerializedName("status")
    private String status;

    public GooglePlaceResponse(List<String> htmlAttributions, String nextPageToken, List<T> results, String status) {
        this.htmlAttributions = htmlAttributions;
        this.nextPageToken = nextPageToken;
        this.results = results;
        this.status = status;
    }

    public List<String> getHtmlAttributions() {
        return htmlAttributions;
    }

    public void setHtmlAttributions(List<String> htmlAttributions) {
        this.htmlAttributions = htmlAttributions;
    }

    public String getNextPageToken() {
        return nextPageToken;
    }

    public void setNextPageToken(String nextPageToken) {
        this.nextPageToken = nextPageToken;
    }

    public List<T> getResults() {
        return results;
    }

    public void setResults(List<T> results) {
        this.results = results;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
