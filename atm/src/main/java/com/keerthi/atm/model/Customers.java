package com.keerthi.atm.model;

public class Customers {
    
    private String accNo;
    private String name;
    private int pinNo;
    private Long amount;
    
    public String getAccNo() {
        return accNo;
    }
    public void setAccNo(String accNo) {
        this.accNo = accNo;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getPinNo() {
        return pinNo;
    }
    public void setPinNo(int pinNo) {
        this.pinNo = pinNo;
    }
    public Long getAmount() {
        return amount;
    }
    public void setAmount(Long amount) {
        this.amount = amount;
    }


}
