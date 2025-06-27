package com.keerthi.atm;

import java.util.*;

public class AtmMain {

	Scanner scanner=new Scanner(System.in);
	
	 Atm atm=new Atm();
	 
	 
	public static void main(String[] args) {
		
		Datalayer.getInstance().loadCustomer();
		 Scanner sc=new Scanner(System.in);
		 
		 AtmMain atmMain=new AtmMain();
		 
	        while (true) { 
	            System.out.println("\n1-Load cash to Atm \n2-Show customer details \n3-Show atm operations");
	            
	                System.out.println("Enter choice:");
	                int choice=sc.nextInt();

	                switch(choice) {
	                    case 1:atmMain.loadCash();
	                            break;
	                    case 2:atmMain.showCustomerDetails();
	                            break;
	                    case 3:atmMain.showAtmProcess();
	                            break;
	                }
	            }
	        
	    }

	    private  void loadCash() {
	        System.out.println("Enter amount:");
	        int amount=scanner.nextInt()/100000;

	        atm.setCash1000(atm.getCash1000()+amount*20);
	        atm.setCash500(atm.getCash500()+amount*100);
	        atm.setCash100(atm.getCash100()+amount*300);
	        
	        System.out.println("Amount load successfully...");
	        System.out.println("Current Cash:");
	        System.out.println("1000 ₹ notes: " + atm.getCash1000());
	        System.out.println("500 ₹ notes: " + atm.getCash500());
	        System.out.println("100 ₹ notes: " + atm.getCash100());
	        System.out.println("Current Total Cash:"+atm.getTotal());
	    }

	    private void showCustomerDetails() {
	        Map<Integer,Customer> customerList=Datalayer.getInstance().getAllCustomer();

	         for(Customer each:customerList.values())
	             System.out.println(each.getAccNo()+" "+each.getName()+" "+each.getPinNo()+" "+each.getBalance());

	    }

	    private void showAtmProcess() {
	        System.out.println("Enter accNo");
	        int accNo=scanner.nextInt();
	        System.out.println("Enter password");
	        int password=scanner.nextInt();
	        Customer loginUser=Datalayer.getInstance().validate(accNo,password);
	        if(loginUser!=null)
	        	showCustomerMenu(loginUser);
	        else
	        	System.out.println("Invalid credentials");
	    }

		private void showCustomerMenu(Customer loginUser) {
			while(true) {
				System.out.println("\n1-Check Balance \n2-withdraw money \n3-Transfer money \n4-Mini statement \n5-go back");
				System.out.println("Enter choice:");
				int choice=scanner.nextInt();
				
				switch(choice) {
				case 1:checkBalance(loginUser);
						break;
						
				case 2:withdrawMoney(loginUser);
						break;
				case 3:transferMoney(loginUser);
						break;						
				case 4:miniStatement(loginUser);
						break;
						
				case 5:return;
				}
			}
		}

		private void miniStatement(Customer loginUser) {
			List<Transcation> ministmt=Datalayer.getInstance().getMiniStatement(loginUser);
			if(ministmt.size()==0) {
				System.out.println("No transaction...");
				return;
			}else {
				System.out.println("AccNo:"+loginUser.getAccNo()+"\n Account Holder:"+loginUser.getName()+"\n Balance:"+loginUser.getBalance());
				System.out.println("----------------------------------");
				System.out.println("Transaction Id"+" "+"Remark"+" "+"type"+" "+"amount");
				
				for(Transcation list:ministmt) {
					 System.out.println(list.getId()+" "+list.getRemark()+" "+list.getType()+" "+list.getAmount());
				}
				
			}
		}

		private void transferMoney(Customer loginUser) {
			System.out.println("Enter receriver account No:");
			int accNo=scanner.nextInt();
			Customer receiver=Datalayer.getInstance().checkReceiver(accNo);
			if(receiver!=null) {
				 System.out.println("Enter amount:");
				 int amount=scanner.nextInt();
				 
				 if(amount>=1000 && amount<=10000) {
					 loginUser.setBalance(loginUser.getBalance()-amount);
					 receiver.setBalance(receiver.getBalance()+amount);
					 System.out.println("Transfered Successfully"+receiver.getBalance()+"..reveriver.."+loginUser.getBalance()+"..sender");
					 Datalayer.getInstance().AddTranscation(loginUser.getAccNo(),"Transfer Account to :"+accNo,"debit",amount);
					 Datalayer.getInstance().AddTranscation(accNo,"credit amount from:","credit",amount);
				 }else {
					 System.out.println("Invalid amount");
						return;
				 }
			 }else {
				System.out.println("Invalid account number");
				return;
			}
		}

		private void withdrawMoney(Customer loginUser) {
			System.out.println("Enter pinNo:");
			int pinNo=scanner.nextInt();
			
			if(pinNo==loginUser.getPinNo()) {
				System.out.println("Enter Amount:");
				int amount=scanner.nextInt();
				
				 if(amount>=100 && amount<=10000) {
					if(atm.getTotal()<amount) {
						System.out.println("Atm balance is less  than your withdrwal amount");
						return;
					} if(loginUser.getBalance()<amount) {
						System.out.println("Your account balance is less than your withdrwal amount");
						return;
					}
					
					withdrawMoneyFromUser(amount,loginUser);
					Datalayer.getInstance().AddTranscation(loginUser.getAccNo(),"debited Account from atm"+amount,"debit",amount);
					
				} else {
					
					System.out.println("Your withdraw amount is Invalid");
					return ;
				}
					
			} else {
				System.out.println("Invalid pin No");
				return;
			}
		}

		
		public void withdrawMoneyFromUser(int amount, Customer loginUser) {
			  
		    loginUser.setBalance(loginUser.getBalance()-amount);
		    System.out.println(loginUser.getBalance());
		    
		     if(amount<5000) {
		    	 if(amount>=1000)
		    	 atm.setCash1000(atm.getCash1000()-1);
		    	 
		    	 amount=amount-1000;
		    	 
		    	 if(amount>=1000)
		    		 atm.setCash100(atm.getCash100()-10);

		    	 amount=amount-1000;
		    	 
		    	 System.out.println(amount+"amount111");
		    	 amount=amount/500;
		    	 System.out.println(amount+"amount111");
		    	 if(amount!=0)
		    	 atm.setCash500(atm.getCash500()-amount);
		    	 
		    	 
		    	 System.out.println("Current Cash:");
			        System.out.println("1000 ₹ notes: " + atm.getCash1000());
			        System.out.println("500 ₹ notes: " + atm.getCash500());
			        System.out.println("100 ₹ notes: " + atm.getCash100());
			        System.out.println("Current Total Cash:"+atm.getTotal());
		     } else {
			    	 atm.setCash1000(atm.getCash1000()-3);
			    	 
			    	 amount=amount-3000;
			    	 
			    	atm.setCash100(atm.getCash100()-10);

			    	 amount=amount-1000;
			    	 
			    	 amount=amount/500;
			    	 if(amount!=0)
			    	 atm.setCash500(atm.getCash500()-amount);
			    	 
			    	 
			    	 System.out.println("Current Cash:");
				        System.out.println("1000 ₹ notes: " + atm.getCash1000());
				        System.out.println("500 ₹ notes: " + atm.getCash500());
				        System.out.println("100 ₹ notes: " + atm.getCash100());
				        System.out.println("Current Total Cash:"+atm.getTotal());
		     }
		    
		     
	    }
		
		private void checkBalance(Customer loginUser) {
			 System.out.println("Your balance amount is:"+loginUser.getBalance());
		}

}
