package com.keerthi.taxcalculator.admin;

import java.util.Scanner;

import com.keerthi.taxcalculator.model.Tax;

public class AdminView {
	
	private AdminModel adminModel;
	
	Scanner sc=new Scanner(System.in);
	
	public AdminView() {
		adminModel=new AdminModel(this);
	}

	public void addTax() {
		Tax tax=new Tax();
		System.out.println("Enter inital amount");
		tax.setAmount1(sc.nextLong());
		System.out.println("Enter last amount");
		tax.setAmount2(sc.nextLong());
		System.out.println("Enter tax:");
		tax.setTax(sc.nextInt());
		
		adminModel.validateTax(tax);
	}

	public void editTax() {
		// TODO Auto-generated method stub
		
	}

	public void viewTax() {
		// TODO Auto-generated method stub
		
	}

	public void showMessage(String message) {
		System.out.println(message);
	}

}
