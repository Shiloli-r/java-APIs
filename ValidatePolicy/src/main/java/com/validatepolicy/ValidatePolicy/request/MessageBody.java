package com.validatepolicy.ValidatePolicy.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MessageBody {
    @JsonProperty("PolicyNo")
    private String policyNo;

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    @JsonProperty("BankCode")
    private String bankCode;
}
