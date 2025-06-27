package com.keerthi.bank.login;

import com.keerthi.bank.datalayer.FileManager;
import com.keerthi.bank.model.Customer;

public class LoginModel {

	private LoginView loginView;
	
	public LoginModel(LoginView loginView) {
		this.loginView=loginView;
	}

	public void addUser(Customer user) {
		if(FileManager.getInstance().addUserInFile(user)) {
			loginView.ShowMessage("SignUp successfull");
			loginView.signUp();
		}else {
			loginView.ShowMessage("SignUp failed");
			return;
		}
			
	}

	public void checkUser(int customerId, String password) {
		
		Customer loginUser=FileManager.getInstance().checkUser(customerId,password);
		if(loginUser!=null) {
			System.out.println("1111");
			loginView.ShowMessage("login successfull");
			loginView.userMenu(loginUser);
		}else {
			System.out.println(customerId+"customerId"+password+"password");
			loginView.ShowMessage("login failed");
			return;
		}
	}

}
