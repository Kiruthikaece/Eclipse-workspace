package com.keerthi.taxcalculator.login;

import java.util.Scanner;

import com.keerthi.taxcalculator.admin.AdminView;

public class LoginView {
	
	private LoginModel loginModel;
	
	Scanner sc=new Scanner(System.in);

	public LoginView() {
		loginModel=new LoginModel(this);
	}
	
	public void showMainMenu() {
		while(true) {
			System.out.println("\n1-Admin \n2-TaxPayer \n3-logout");
			
			System.out.println("Enter choice:");
			int choice=sc.nextInt();
			switch(choice) {
			
			  case 1: showLogin();
			  			break;
			  case 2: new User().userInit();
			  		  break;
			  case 3: return;
			  
			  default:return;
			}
		}
	}

	private void showLogin() {
		System.out.println("Enter username:");
		String userName=sc.next();
		System.out.println("Enter Password:");
		String password=sc.next();
		loginModel.validateLogin(userName,password);
	}

	public void showAdminMenu() {
		while(true) {
			System.out.println("\n1-AddTax \n2-EditTax \n3-ViewTax \n4-goback");
			
			System.out.println("Enter choice:");
			int choice=sc.nextInt();
			switch(choice) {
			
			  case 1: new AdminView().addTax();
			  			break;
			  case 2: new AdminView().editTax();
			  		  break;
			  case 3: new AdminView().viewTax();
			  		  break;
			  		  
			  case 4:return;
			  
			  default:return;
			}
		}
	}
	
	
	
}
