package com.keerthi.taxcalculator.login;

public class LoginModel {

	private LoginView loginView;
	
	public LoginModel(LoginView loginView) {
		this.loginView=loginView;
	}

	public void validateLogin(String userName, String password) {
		if(userName.equals("admin")) {
			System.out.println("login successfull");
			loginView.showAdminMenu();
		} else {
			System.out.println("login failed");
			return;
		}
	}
	
	


}
