package com.capgemini.bank.bean;

public class DemandDraft {
    public double Commission;

    private int transactionId;
    private String CustomerName;
    private String InFavorOf;
    private String PhoneNumber;
   private String DateOfTransaction;
    private double DDAmount;
    private double DDCommission;
    private String DDDescription;

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setCustomerName(String customerName) {
        this.CustomerName = customerName;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setInFavorOf(String inFavorOf) {
        this.InFavorOf = inFavorOf;
    }

    public String getInFavorOf() {
        return InFavorOf;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.PhoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

   public void setDateOfTransaction(String dateOfTransaction) {
        this.DateOfTransaction = dateOfTransaction;
    }

    public String getDateOfTransaction() {
        return DateOfTransaction;
    }

    public void setDDAmount(double DDAmount) {
        this.DDAmount = DDAmount;
    }

    public  double getDDAmount() {
        return DDAmount;
    }

    public void setDDCommission(double DDCommission) {
        this.DDCommission = DDCommission;
    }

    public double getDDCommission() {
        return DDCommission;
    }

    public void setDDDescription(String DDDescription) {
        this.DDDescription = DDDescription;
    }

    public String getDDDescription() {
        return DDDescription;
    }


}

