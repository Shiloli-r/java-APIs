package com.validatepolicy.ValidatePolicy.response;

public class AuthResponsePayload {
    private String error_code;
    private ErrorDesc error_desc;

    // getters and setters

    public String getError_code() {
        return error_code;
    }

    public void setError_code(String error_code) {
        this.error_code = error_code;
    }

    public ErrorDesc getError_desc() {
        return error_desc;
    }

    public void setError_desc(ErrorDesc error_desc) {
        this.error_desc = error_desc;
    }
}

