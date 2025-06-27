package com.keerthi.atm.atmoperation;

import com.keerthi.atm.datalayer.FileManagement;
import com.keerthi.atm.model.Atm;
import com.keerthi.atm.model.Customers;
import com.keerthi.atm.model.Transaction;

public class AtmOperationModel {

    private AtmOperationView atmOperationView;

    public AtmOperationModel(AtmOperationView atmOperationView) {
        this.atmOperationView=atmOperationView;
    }

    public void seperateAmount(Atm atm) {
        long amount=atm.getLoadAmount();
        
    }
    
    public boolean isValidCustomer(Customers customer) {
    	return FileManagement.getInstance().checkCustomers(customer);
    }
    
    public Customers getCustomer() {
    	return FileManagement.getInstance().getCurrentCustomer();
    }
    
    public boolean isValidAmount(int amount) {
    	return amount>=100 && amount<=10000;
    }

	public boolean validPin(int pinNo, Customers customer) {
		return pinNo==customer.getPinNo();
	}

	public boolean checkBalanceAmount(Customers customer, int amount) {
	    return amount<customer.getAmount();
	}

	public void updateAmount(Customers customer, int amount) {
		FileManagement.getInstance().updateAmountInCustomers(customer,amount);
	}

	public boolean checkReceiver(String receiverAccNo) {
		return FileManagement.getInstance().checkReceiverExist(receiverAccNo);
	}

	public boolean checkTrancactionAmount(int amount) {
		return amount>=1000 && amount<=10000;
	}

	public void updateTransaction(String receiverAccNo, Customers customer, int amount) {
		FileManagement.getInstance().updateTransactionSender(receiverAccNo,customer,amount);
		
	}

	public void checkBalanceCustomers(String accNo) {
		atmOperationView.showBalance(FileManagement.getInstance().checkBalanceForCustomer(accNo));
	}

	public void getAllTransaction(Customers customer) {
		atmOperationView.printMiniStatement(FileManagement.getInstance().getAllTransaction(customer));
	}

	public void ValidateTransactionStmt(Transaction receiver,Transaction sender, String receiverAccNo, Customers customer, int amount) {
		FileManagement.getInstance().addMiniStatement(receiver,sender,receiverAccNo,customer,amount);
	}

	
}
