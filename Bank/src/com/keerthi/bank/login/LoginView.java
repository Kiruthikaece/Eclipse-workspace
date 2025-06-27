package com.keerthi.bank.login;

import java.util.Scanner;

import com.keerthi.bank.model.Customer;
import com.keerthi.bank.userManagement.UserManagementView;

public class LoginView {

	Customer loginuser=new Customer();
	private LoginModel loginModel;
	Scanner sc=new Scanner(System.in);
	
	public LoginView() {
		loginModel=new LoginModel(this);
	}
	
	public void initLogin() {
		while(true) {
			System.out.println("\n1-Account Login \n2-Purchase");
			System.out.println("Enter choice:");
			int choice=sc.nextInt();
			
			switch(choice) {
			  case 1:accountLogin();
			  		break;
			  		
			 // case 2:purchase();
			  //		 break;
			  		 
			  default:System.out.println("Invalid choice");
			  		return;
			}
			
		}
	}

	private void accountLogin() {
		
		while(true) {
			System.out.println("\n1-Signup \n2-Login");
			System.out.println("Enter choice:");
			int choice=sc.nextInt();
			
			switch(choice) {
			  case 1:createUser();
			  		break;
			  		
			  case 2:signUp();
			  		 break;
			  		 
			  default:System.out.println("Invalid choice");
			  		return;
			}
			
		}
		
	}

	public void createUser() {
		Customer user=new Customer();
		System.out.println("Enter customer id:");
		user.setCustomerId(sc.nextInt());
		System.out.println("Enter password:");
		user.setPassword(sc.next());
		loginModel.addUser(user);
	}
	
	public void signUp() {
		System.out.println("Enter customer id:");
		int customerId=sc.nextInt();
		System.out.println("Enter password:");
		String password=sc.next();
		loginModel.checkUser(customerId,password);
	}

	public void ShowMessage(String msg) {
		System.out.println(msg);
	}

	public void userMenu(Customer loginUser) {
		
		while(true) {
			System.out.println("\n1-Create gift card \n2-Topup \n3-Transaction history \n4-Bloack \n5-Logout");
			System.out.println("Enter choice:");
			int choice=sc.nextInt();
			
			switch(choice) {
			case 1: new UserManagementView().createGiftCard(loginUser);
					break;
					
			case 2:new UserManagementView().topUp(loginUser);
					break;
					
			case 3:new UserManagementView().getAllTransaction(loginUser);
					break;
					
			case 4:new UserManagementView().block(loginUser);
					break;
					
			case 5:System.out.println("Logout successfully..");
					return;
					
			}
		}
	}
}
