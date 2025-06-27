package com.keerthi.bank;

import com.keerthi.bank.datalayer.FileManager;
import com.keerthi.bank.login.LoginView;

public class BankMain {

	private static BankMain bankMain;
	
	public static BankMain getInstance() {
		if(bankMain==null)
			bankMain=new BankMain();
		
		return bankMain;
	}
	
	public static void main(String[] args) {
		
		FileManager.getInstance().staticCustomer();
		bankMain.getInstance().initSetup();
		
	}

	private void initSetup() {
		LoginView loginView=new LoginView();
		loginView.initLogin();
	}

}
