package com.validatepolicy.ValidatePolicy.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorDesc {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String token;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String expiry;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String message;

    @JsonProperty("ReferenceNumber")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String referenceNumber;

    @JsonProperty("AccountNo")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String accountNo;

    @JsonProperty("CustomerName")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String customerName;

    @JsonProperty("OutstandingAmount")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String outstandingAmount;

    @JsonProperty("DueDate")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String dueDate;

    @JsonProperty("StatusCode")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String statusCode;

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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getOutstandingAmount() {
        return outstandingAmount;
    }

    public void setOutstandingAmount(String outstandingAmount) {
        this.outstandingAmount = outstandingAmount;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }
}
