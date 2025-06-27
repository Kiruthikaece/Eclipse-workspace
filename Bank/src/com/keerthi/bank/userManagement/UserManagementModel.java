package com.keerthi.bank.userManagement;

import com.keerthi.bank.datalayer.FileManager;
import com.keerthi.bank.model.Customer;
import com.keerthi.bank.model.GiftCard;

public class UserManagementModel {

	  private UserManagementView userManagementView;
	  
	  public UserManagementModel(UserManagementView userManagementView) {
		  this.userManagementView=userManagementView;
	  }

	public void checkGiftCard(GiftCard card, Customer loginUser) {
		if(FileManager.getInstance().checkCard(card)) {
			userManagementView.showMessage("card created SuccessFully your card number is:"+card.getCardNo()+"your pin Number is:"+card.getPinNo());
			FileManager.getInstance().addGiftCard(card,loginUser);
			return;
		}else {
			userManagementView.createGiftCard(loginUser);
		}
	}

	public void addTopup(int cardNo, int pinNo, int balance, Customer loginUser) {
		if(validate(cardNo,pinNo,balance,loginUser)) {
			if(FileManager.getInstance().addTopupInFile(cardNo,pinNo,balance,loginUser)) {
				userManagementView.showMessage("TopUp successfull");

		    }else
				userManagementView.showMessage("TopUp failed");

		}
	    
	}

	private boolean validate(int cardNo, int pinNo, int balance, Customer loginUser) {
		   if(loginUser.getBalance()< balance) {
				userManagementView.showMessage("Insufficicent balance in your account");
				return false;
		   }
		   
		   return true;
	}
}
