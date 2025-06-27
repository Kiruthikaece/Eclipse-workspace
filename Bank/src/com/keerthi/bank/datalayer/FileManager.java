package com.keerthi.bank.datalayer;

import com.keerthi.bank.model.Customer;
import com.keerthi.bank.model.GiftCard;

import java.util.*;

public class FileManager {
    
	private static FileManager fileManager;
	
	List<Customer> userList=new ArrayList<>();
	Map<Integer,List<GiftCard>> giftCardList=new HashMap<>();
	
	
	public void staticCustomer() {
		Customer customer1=new Customer(123,"123",2000);
		userList.add(customer1);
		
		Customer customer2=new Customer(111,"111",5000);
		userList.add(customer2);
	}
	public static FileManager getInstance() {
		if(fileManager==null)
			fileManager=new FileManager();
		
		return fileManager;
	}

	public boolean addUserInFile(Customer user) {
		
		boolean isNewUser=true;
		
		for(Customer customer:userList) {
			if(customer.getCustomerId()==user.getCustomerId() && customer.getPassword().equals(user.getPassword()))
				isNewUser=false;	
		}
		
		if(!isNewUser)
			return false;
		else {
			userList.add(user);
			return true;
		}
			
	}

	public Customer checkUser(int customerId, String password) {
		
		for(Customer customer:userList) {
			System.out.println("111");
			if(customer.getCustomerId()==customerId && customer.getPassword().equals(password))
				return customer;	
		}
		
		return null;
	}

	public boolean checkCard(GiftCard card) {
		for(Map.Entry<Integer,List<GiftCard>> map:giftCardList.entrySet()) {
			for(GiftCard list:map.getValue()) {
				if(list.getCardNo()==card.getCardNo() && list.getPinNo()==card.getPinNo())
					return false;
			}
		} 
		
		return true;
	}

	public void addGiftCard(GiftCard card, Customer loginUser) {
	    
		  if(giftCardList.containsKey(loginUser.getCustomerId())) {
			  giftCardList.get(loginUser.getCustomerId()).add(card);
		  }else {
			  List<GiftCard> list=new ArrayList<>();
			  list.add(card);
			  giftCardList.put(loginUser.getCustomerId(), list);
		  }
		
	}

	public boolean addTopupInFile(int cardNo, int pinNo, int balance, Customer loginUser) {
		     
		   boolean isCredit=false;
		for(Customer customer:userList) {
			if(customer.getCustomerId()==loginUser.getCustomerId()) {
				if(giftCardList.containsKey(loginUser.getCustomerId())) {
					List<GiftCard> giftCard = giftCardList.get(loginUser.getCustomerId());
					
					for(GiftCard list:giftCard) {
						if(list.getCardNo()==cardNo && list.getPinNo()==pinNo) {
							list.setAmount(balance);
							isCredit=true;
						}
						
					}
					
				}
			}
		}
		
		if(isCredit) {
			loginUser.setBalance(loginUser.getBalance()-balance);
			return true;
		}
		
		return false;
	}
	
	
}
