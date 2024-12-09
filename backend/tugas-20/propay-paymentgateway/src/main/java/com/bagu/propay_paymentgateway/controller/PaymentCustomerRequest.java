package com.bagu.propay_paymentgateway.controller;

public class PaymentCustomerRequest {
    private String vaNumber;
    private Boolean paid;

    public PaymentCustomerRequest(String vaNumber, Boolean paid) {
        this.vaNumber = vaNumber;
        this.paid = paid;
    }

    public PaymentCustomerRequest() {}

    public String getVaNumber() {
        return vaNumber;
    }

    public void setVaNumber(String vaNumber) {
        this.vaNumber = vaNumber;
    }

    public Boolean getPaid() {
        return paid;
    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }
}
