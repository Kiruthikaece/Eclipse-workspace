package com.keerthi.cabapplication;

import java.util.Scanner;

public class CabMain {
	
	Scanner scanner=new Scanner(System.in); 

	public static void main(String[] args) {
		
		  Scanner sc=new Scanner(System.in);
		  CabMain main=new CabMain();
		 
		   Datalayer.getInstance().printDriver();
		   Datalayer.getInstance().printCustomer();
		   Datalayer.getInstance().printLocation();
		   Datalayer.getInstance().printInitialLocation();
		   
		   while(true) {
			   System.out.println("\n1-Driver login \n2-customer login \n3-Administration login \n4-Quit");
			   System.out.println("Enter your choice:");
			   int choice=sc.nextInt();
			   switch(choice) {
			    case 1:main.login();
			    case 2:main.login();
			    case 3:main.login();
			    	   break;
			    case 4:return;
			   }
		   }
	}

	private void login() {
		System.out.println("Enter username");
		String username=scanner.next();
		System.out.println("Enter password:");
		String password=scanner.next();
		boolean res=Datalayer.getInstance().checkCustomer(username,password);
		if(res) {
			System.out.println("Cutsomer login successfully");
			bookingCab();
		}else {
			System.out.println("Invalid login");
			return;
		}
	}

	private void bookingCab() {
		System.out.println("Enter source:");
		char source=scanner.next().charAt(0);
		System.out.println("Enter Destination:");
		char destination=scanner.next().charAt(0);
		Datalayer.getInstance().bookCab(source,destination);
	}

}
