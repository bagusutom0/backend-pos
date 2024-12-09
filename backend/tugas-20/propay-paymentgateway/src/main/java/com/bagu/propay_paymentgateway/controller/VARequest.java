package com.bagu.propay_paymentgateway.controller;

public class VARequest {
    private String merchantName;
    private String customerName;
    private String description;
    private Double amount;
    private String paymentCallbackUri;

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getPaymentCallbackUri() {
        return paymentCallbackUri;
    }

    public void setPaymentCallbackUri(String paymentCallbackUri) {
        this.paymentCallbackUri = paymentCallbackUri;
    }
}
