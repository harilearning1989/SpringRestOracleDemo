package com.example.demo.dto;

public class CreditCardDTO {

    private String cardTypeCode;
    private String cardTypeFullName;
    private String issuingBank;
    private String cardNumber;
    private String cardHolderName;
    private String cVVCVV2;
    private String issueDate;
    private String expiryDate;
    private String billingDate;
    private String cardPIN;
    private String creditLimit;

    public String getCardTypeCode() {
        return cardTypeCode;
    }

    public void setCardTypeCode(String cardTypeCode) {
        this.cardTypeCode = cardTypeCode;
    }

    public String getCardTypeFullName() {
        return cardTypeFullName;
    }

    public void setCardTypeFullName(String cardTypeFullName) {
        this.cardTypeFullName = cardTypeFullName;
    }

    public String getIssuingBank() {
        return issuingBank;
    }

    public void setIssuingBank(String issuingBank) {
        this.issuingBank = issuingBank;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public String getcVVCVV2() {
        return cVVCVV2;
    }

    public void setcVVCVV2(String cVVCVV2) {
        this.cVVCVV2 = cVVCVV2;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getBillingDate() {
        return billingDate;
    }

    public void setBillingDate(String billingDate) {
        this.billingDate = billingDate;
    }

    public String getCardPIN() {
        return cardPIN;
    }

    public void setCardPIN(String cardPIN) {
        this.cardPIN = cardPIN;
    }

    public String getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(String creditLimit) {
        this.creditLimit = creditLimit;
    }
}
