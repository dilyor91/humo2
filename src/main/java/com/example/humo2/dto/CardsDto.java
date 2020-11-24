package com.example.humo2.dto;

import java.util.Date;

/*
 *
 *  @A Sabirov Jakhongir
 *
 */
public class CardsDto {
    private  String cardType;
    private  String account;
    private  double balance;
    private  String branch;
    private  String cardBelonging;
    private  String cardKind;
    private  int cardListVist;
    private  String cardNumberMask;
    private  String cardSort;
    private  String cardHolderName;
    private  String currencyCode;
    private  String currencyIsoCode;
    private  String embossedName;
    private  Date expirationDate;
    private  String extId;
    private  int rejection;
    private  String serviceTerms;
    private  String state;
    private  int tempBlocking;
    private  String type;
    private   int visibleAccount;
    private  String phoneNumber;
    private  String cardNumber;
    private  int clientId;
    private  int contractId;
    private  int isAbroadUsing;
    private  int isInternetUsing;
    private  int replwoutConv;
    private  int withdraw;

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getCardBelonging() {
        return cardBelonging;
    }

    public void setCardBelonging(String cardBelonging) {
        this.cardBelonging = cardBelonging;
    }

    public String getCardKind() {
        return cardKind;
    }

    public void setCardKind(String cardKind) {
        this.cardKind = cardKind;
    }

    public int getCardListVist() {
        return cardListVist;
    }

    public void setCardListVist(int cardListVist) {
        this.cardListVist = cardListVist;
    }

    public String getCardNumberMask() {
        return cardNumberMask;
    }

    public void setCardNumberMask(String cardNumberMask) {
        this.cardNumberMask = cardNumberMask;
    }

    public String getCardSort() {
        return cardSort;
    }

    public void setCardSort(String cardSort) {
        this.cardSort = cardSort;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyIsoCode() {
        return currencyIsoCode;
    }

    public void setCurrencyIsoCode(String currencyIsoCode) {
        this.currencyIsoCode = currencyIsoCode;
    }

    public String getEmbossedName() {
        return embossedName;
    }

    public void setEmbossedName(String embossedName) {
        this.embossedName = embossedName;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getExtId() {
        return extId;
    }

    public void setExtId(String extId) {
        this.extId = extId;
    }

    public int getRejection() {
        return rejection;
    }

    public void setRejection(int rejection) {
        this.rejection = rejection;
    }

    public String getServiceTerms() {
        return serviceTerms;
    }

    public void setServiceTerms(String serviceTerms) {
        this.serviceTerms = serviceTerms;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getTempBlocking() {
        return tempBlocking;
    }

    public void setTempBlocking(int tempBlocking) {
        this.tempBlocking = tempBlocking;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getVisibleAccount() {
        return visibleAccount;
    }

    public void setVisibleAccount(int visibleAccount) {
        this.visibleAccount = visibleAccount;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getContractId() {
        return contractId;
    }

    public void setContractId(int contractId) {
        this.contractId = contractId;
    }

    public int getIsAbroadUsing() {
        return isAbroadUsing;
    }

    public void setIsAbroadUsing(int isAbroadUsing) {
        this.isAbroadUsing = isAbroadUsing;
    }

    public int getIsInternetUsing() {
        return isInternetUsing;
    }

    public void setIsInternetUsing(int isInternetUsing) {
        this.isInternetUsing = isInternetUsing;
    }

    public int getReplwoutConv() {
        return replwoutConv;
    }

    public void setReplwoutConv(int replwoutConv) {
        this.replwoutConv = replwoutConv;
    }

    public int getWithdraw() {
        return withdraw;
    }

    public void setWithdraw(int withdraw) {
        this.withdraw = withdraw;
    }

    public CardsDto() {
    }

    @Override
    public String toString() {
        return "CardsDto{" +
                "cardType='" + cardType + '\'' +
                ", account='" + account + '\'' +
                ", balance=" + balance +
                ", branch='" + branch + '\'' +
                ", cardBelonging='" + cardBelonging + '\'' +
                ", cardKind='" + cardKind + '\'' +
                ", cardListVist=" + cardListVist +
                ", cardNumberMask='" + cardNumberMask + '\'' +
                ", cardSort='" + cardSort + '\'' +
                ", cardHolderName='" + cardHolderName + '\'' +
                ", currencyCode='" + currencyCode + '\'' +
                ", currencyIsoCode='" + currencyIsoCode + '\'' +
                ", embossedName='" + embossedName + '\'' +
                ", expirationDate=" + expirationDate +
                ", extId='" + extId + '\'' +
                ", rejection=" + rejection +
                ", serviceTerms='" + serviceTerms + '\'' +
                ", state='" + state + '\'' +
                ", tempBlocking=" + tempBlocking +
                ", type='" + type + '\'' +
                ", visibleAccount=" + visibleAccount +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", clientId=" + clientId +
                ", contractId=" + contractId +
                ", isAbroadUsing=" + isAbroadUsing +
                ", isInternetUsing=" + isInternetUsing +
                ", replwoutConv=" + replwoutConv +
                ", withdraw=" + withdraw +
                '}';
    }
}
