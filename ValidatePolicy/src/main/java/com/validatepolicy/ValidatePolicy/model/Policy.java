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
}
