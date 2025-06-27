package com.keerthi.atm;

public class Customer {
	    private int accNo;
	    private String name;
	    private int pinNo;
	    private int balance;

	    Customer(int accNo,String name,int pinNo,int balance) {
	        this.accNo=accNo;
	        this.name=name;
	        this.pinNo=pinNo;
	        this.balance=balance;
	    }
	    public int getAccNo() {
	        return accNo;
	    }
	    public void setAccNo(int accNo) {
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
	    public int getBalance() {
	        return balance;
	    }
	    public void setBalance(int balance) {
	        this.balance = balance;
	    }
}
