package com.validatepolicy.ValidatePolicy.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MessageValidation {
    @JsonProperty("api_user")
    private String apiUser;

    @JsonProperty("api_password")
    private String apiPassword;

    // getters and setters

    public String getApiUser() {
        return apiUser;
    }

    public void setApiUser(String apiUser) {
        this.apiUser = apiUser;
    }

    public String getApiPassword() {
        return apiPassword;
    }

    public void setApiPassword(String apiPassword) {
        this.apiPassword = apiPassword;
    }
}
