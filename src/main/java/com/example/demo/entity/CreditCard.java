package com.example.demo.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "CREDIT_CARD")
public class CreditCard {

    @Id
    @Column(name = "CARD_ID")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private long cardId;
    @Column(name = "CARD_TYPE_CODE")
    private String cardTypeCode;
    @Column(name = "CARD_TYPE_FULL_NAME")
    private String cardTypeFullName;
    @Column(name = "ISSUING_BANK")
    private String issuingBank;
    @Column(name = "CARD_NUMBER")
    private long cardNumber;
    @Column(name = "CARD_HOLDER_NAME")
    private String cardHolderName;
    @Column(name = "CVV_CVV2")
    private int cVVCVV2;
    @Column(name = "ISSUE_DATE")
    private Date issueDate;
    @Column(name = "EXPIRY_DATE")
    private Date expiryDate;
    @Column(name = "BILLING_DATE")
    private int billingDate;
    @Column(name = "CARD_PIN")
    private int cardPIN;
    @Column(name = "CREDIT_LIMIT")
    private int creditLimit;

    public long getCardId() {
        return cardId;
    }

    public void setCardId(long cardId) {
        this.cardId = cardId;
    }

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

    public long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public int getcVVCVV2() {
        return cVVCVV2;
    }

    public void setcVVCVV2(int cVVCVV2) {
        this.cVVCVV2 = cVVCVV2;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public int getBillingDate() {
        return billingDate;
    }

    public void setBillingDate(int billingDate) {
        this.billingDate = billingDate;
    }

    public int getCardPIN() {
        return cardPIN;
    }

    public void setCardPIN(int cardPIN) {
        this.cardPIN = cardPIN;
    }

    public int getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(int creditLimit) {
        this.creditLimit = creditLimit;
    }
}
