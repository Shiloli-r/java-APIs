package com.validatepolicy.ValidatePolicy.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MessageRoute {
    @JsonProperty("interface")
    private String interfaceName;

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public String getExternalRefNumber() {
        return externalRefNumber;
    }

    public void setExternalRefNumber(String externalRefNumber) {
        this.externalRefNumber = externalRefNumber;
    }

    @JsonProperty("request_type")
    private String requestType;

    @JsonProperty("external_ref_number")
    private String externalRefNumber;

    // getters and setters

    public String getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }
}
