package com.validatepolicy.ValidatePolicy.response;

public class ErrorDesc {
    private String token;
    private String expiry;

    // getters and setters

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getExpiry() {
        return expiry;
    }

    public void setExpiry(String expiry) {
        this.expiry = expiry;
    }
}
