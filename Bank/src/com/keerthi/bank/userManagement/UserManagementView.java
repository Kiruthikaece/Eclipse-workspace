package com.keerthi.bank.userManagement;

import java.util.Scanner;

import com.keerthi.bank.model.Customer;
import com.keerthi.bank.model.GiftCard;

public class UserManagementView {
    
		Scanner sc=new Scanner(System.in);
	  private UserManagementModel userManagementModel;
	  
	  public UserManagementView() {
		  userManagementModel=new UserManagementModel(this);
	  }

	public void createGiftCard(Customer loginUser) {
		int min1=10000,max1=99999,min2=1000,max2=9999;
		GiftCard card=new GiftCard();
		card.setCardNo((int)(Math.random()*(max1-min1+1))-min1);
		card.setPinNo((int)(Math.random()*max2-min1+1)-min2);
		userManagementModel.checkGiftCard(card,loginUser);
	}

	public void topUp(Customer loginUser) {
		System.out.println("Enter card No:");
		int cardNo=sc.nextInt();
		System.out.println("Enter Pin No:");
		int pinNo=sc.nextInt();
		System.out.println("Enter balance:");
		int balance=sc.nextInt();
		userManagementModel.addTopup(cardNo,pinNo,balance,loginUser);
		
	}

	public void getAllTransaction(Customer loginUser) {
		// TODO Auto-generated method stub
		
	}

	public void block(Customer loginUser) {
		// TODO Auto-generated method stub
		
	}

	public void showMessage(String msg) {
		System.out.println(msg);
	}
}
