package com.keerthi.bank.model;

public class Customer {

	private int customerId;
	
	private String password;
	
	private int balance;
	
	public Customer() {
		
	}
	public Customer(int Id,String pwd,int bal) {
		customerId=Id;
		password=pwd;
		balance=bal;
	}
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
}
