package com.validatepolicy.ValidatePolicy.model;

import java.time.LocalDate;

public class Policy {
    private String refNo;
    private String accNo;
    private String customerName;
    private String outStandingAmount;
    private LocalDate dueDate;
    private String policyNo;
    private String bankCode;

    public Policy() {
    }

    public Policy(String refNo, String accNo, String customerName, String outStandingAmount, LocalDate dueDate, String policyNo, String bankCode) {
        this.refNo = refNo;
        this.accNo = accNo;
        this.customerName = customerName;
        this.outStandingAmount = outStandingAmount;
        this.dueDate = dueDate;
        this.policyNo = policyNo;
        this.bankCode = bankCode;
    }

    public Policy(String refNo, String accNo, String customerName, String policyNo, String bankCode) {
        this.refNo = refNo;
        this.accNo = accNo;
        this.customerName = customerName;
        this.policyNo = policyNo;
        this.bankCode = bankCode;
    }

    public String getRefNo() {
        return refNo;
    }

    public void setRefNo(String refNo) {
        this.refNo = refNo;
    }

    public String getAccNo() {
        return accNo;
    }

    public void setAccNo(String accNo) {
        this.accNo = accNo;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getOutStandingAmount() {
        return outStandingAmount;
    }

    public void setOutStandingAmount(String outStandingAmount) {
        this.outStandingAmount = outStandingAmount;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

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
}
