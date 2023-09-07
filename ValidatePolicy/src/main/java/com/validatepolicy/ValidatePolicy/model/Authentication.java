package com.validatepolicy.ValidatePolicy.model;

public class Authentication {
    private String api_user;
    private String api_password;
    private String token;
    private String expiry;

    public Authentication() {
    }

    public Authentication(String api_user, String api_password) {
        this.api_user = api_user;
        this.api_password = api_password;
    }

    public Authentication(String api_user, String api_password, String token, String expiry) {
        this.api_user = api_user;
        this.api_password = api_password;
        this.token = token;
        this.expiry = expiry;
    }

    public String getApi_user() {
        return api_user;
    }

    public void setApi_user(String api_user) {
        this.api_user = api_user;
    }

    public String getApi_password() {
        return api_password;
    }

    public void setApi_password(String api_password) {
        this.api_password = api_password;
    }

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
