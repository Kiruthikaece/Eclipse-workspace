package com.keerthi.atm.atmoperation;

import java.util.List;
import java.util.Scanner;

import com.keerthi.atm.model.Atm;
import com.keerthi.atm.model.Customers;
import com.keerthi.atm.model.Transaction;

public class AtmOperationView {

    private AtmOperationModel atmOperationModel;
    
    private Customers currentCustomer;

    public AtmOperationView() {
        atmOperationModel = new AtmOperationModel(this);
    }

    Scanner sc=new Scanner(System.in);
    


    public void loadCashToAtm() {   
        Atm atm=new Atm(); 
        System.out.println("Enter amount:");
        atm.setLoadAmount(sc.nextLong());
        atmOperationModel.seperateAmount(atm);
    }

    public void showAtmOperations() {
    	
    	Customers customer=new Customers();
    	System.out.println("Enter account Number:");
    	customer.setAccNo(sc.next());
    	System.out.println("Enter PIN number:");
    	customer.setPinNo(sc.nextInt());
    	System.out.println(customer.getAccNo()+"    ....."+customer.getPinNo());
    	boolean isvalid=atmOperationModel.isValidCustomer(customer);
    	if(isvalid) {
    		
    		currentCustomer=atmOperationModel.getCustomer();
    		System.out.println(currentCustomer.getName()+"current-customer");
    		while(true) {
        		System.out.println("\n1-check balance \n2-Withdraw money \n3-Transfer money \n4-mini statement \n5-go back");
        		System.out.println("Enter choice:");
        		int choice=sc.nextInt();
        		
        		switch(choice) {
        		case 1: checkBalance(currentCustomer);
        				break;
        		case 2: withdrawMoney(currentCustomer);
        			   break;
        		case 3: transferMoney(currentCustomer);
        				break;
        		case 4:miniStatement(currentCustomer);
        				break;
        		case 5:return;
        		default:return;
        		}
        	}
    	}else
    	System.out.println("InValid Account number and pin number");
    	
    }
    
    private void miniStatement(Customers customer) {
    	atmOperationModel.getAllTransaction(customer);
	}

	private void transferMoney(Customers customer) {
	    
    	System.out.println("Enter account number for receiver:");
    	String receiverAccNo=sc.next();
   if(atmOperationModel.checkReceiver(receiverAccNo)) {
    		System.out.println("Enter amount:");
        	int amount=sc.nextInt();
       if(atmOperationModel.checkTrancactionAmount(amount)) {
        		if(atmOperationModel.checkBalanceAmount(customer,amount)) {
        			atmOperationModel.updateTransaction(receiverAccNo,customer,amount);
        			addTransactionStatement(receiverAccNo,customer,amount);
        			System.out.println("Tranaction successfull! Thank you....");
            	}else {
            		System.out.println("Not sufficient amount in you account");
            		return;
            	}
       } else {
        		System.out.println("Invalid transaction amount");
        		return;
        	}
        	
        		
        	
   } else
    		System.out.println("Invalid account number");
    		return;
		
	}

	private void addTransactionStatement(String receiverAccNo, Customers customer, int amount) {
		Transaction transaction=new Transaction();
		transaction.setType("credit");
		transaction.setAmount(amount);
		transaction.setAccNo(receiverAccNo);
		transaction.setRemark("funds tranfer from"+customer.getAccNo());
		
		Transaction transaction2=new Transaction();
		transaction2.setType("Debit");
		transaction2.setAmount(amount);
		transaction2.setRemark("funds tranfer to"+receiverAccNo);
		transaction.setAccNo(customer.getAccNo());
		atmOperationModel.ValidateTransactionStmt(transaction,transaction2,receiverAccNo,customer,amount);
		
		
		
	}

	public void withdrawMoney(Customers customer) {
    	System.out.println("Enter amount:");
    	int amount=sc.nextInt();
   if(atmOperationModel.isValidAmount(amount)) {
    		System.out.println("Enter pin Number:");
    		int pinNo=sc.nextInt();
    	if(atmOperationModel.validPin(pinNo,customer)) {
    			
    			
    			if(atmOperationModel.checkBalanceAmount(customer,amount)) {
    				System.out.println("Successfully amount withdraw! Thank you.......");
    				atmOperationModel.updateAmount(customer,amount);
    			} else {
    				System.out.println("Not sufficicent balance for withdrawal");
        			return;
    			}
    			
    			
    		}else {
    			System.out.println("Invalid pin No");
    			return;
    		}
    		
  } else {
    		if(amount<100)
    			System.out.println("less than Minimum withdraw");
    		else
    			System.out.println("Maxinum withdraw amount");
    		
    		return;
   }
    	
    	
    }
    
    
	public void checkBalance(Customers customer) {
		atmOperationModel.checkBalanceCustomers(customer.getAccNo());
    }

	public void showBalance(Long amount) {
		System.out.println("your balance is :"+ amount);
	}

	public void printMiniStatement(List<List<Transaction>> allTransaction) {
		System.out.println("Transaction Id"+" "+"Type"+" "+"Amount"+" "+"Remark");
	    for(List<Transaction> oneTrans:allTransaction) {
	    	for(Transaction trans:oneTrans) {
	    		System.out.print(trans.getTransactionId()+" "+trans.getType()+" "+trans.getAmount()+""+trans.getRemark());
		    	System.out.println();
	    	}
	    	
	    }
	    	
	}
	
	
}
