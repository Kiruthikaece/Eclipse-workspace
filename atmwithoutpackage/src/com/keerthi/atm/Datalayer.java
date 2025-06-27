package com.keerthi.atm;

import java.util.*;

import javax.sql.rowset.spi.TransactionalWriter;

public class Datalayer {
	private static Datalayer datalayer;

    Map<Integer,Customer> customerList=new HashMap<>();
    List<Atm> money=new ArrayList<>();
    
    Map<Integer,List<Transcation>> transcationList=new HashMap<>();

    public static Datalayer getInstance() {
        if(datalayer==null)
        datalayer=new Datalayer();

        return datalayer;
    }
    
    public void loadCustomer() {
        customerList.put(101,new Customer(101,"suresh",2343,25234));
        customerList.put(102,new Customer(102,"ganesh",5432,34123));
        customerList.put(103,new Customer(103,"magesh",7854,26100));
        customerList.put(104,new Customer(104,"naresh",2345,80000));
        customerList.put(105,new Customer(105,"harish",1997,103400));

    }

    public Map<Integer,Customer> getAllCustomer() {
        return customerList;
    }

	public Customer validate(int accNo, int password) {
		  for(Map.Entry<Integer,Customer> customer:customerList.entrySet()) {
			  if(customer.getValue().getAccNo()==accNo && customer.getValue().getPinNo()==password)
				  return customer.getValue();
		  }
		  
		  return null;
	}

	public Customer checkReceiver(int accNo) {
		 for(Map.Entry<Integer,Customer> customer:customerList.entrySet()) {
			  if(customer.getValue().getAccNo()==accNo)
				  return customer.getValue();
		  }
		  
		  return null;
	}

	public void AddTranscation(int accNo, String remark, String type, int amount) {
		
		Transcation transaction=new Transcation(remark,type,amount);
		
		if(transcationList.containsKey(accNo))  {
			transaction.setId(transcationList.get(accNo).size()+1);
			transcationList.get(accNo).add(transaction);
		}
			
		
		else {
			transaction.setId(1);
			 List<Transcation> transactionList = new ArrayList<>();
		       transactionList.add(transaction);
		       transcationList.put(accNo, transactionList);
		}
		
		
	}

	public List<Transcation>  getMiniStatement(Customer loginUser) {
		
		List<Transcation> transaction=new ArrayList<>();
		
		for(Map.Entry<Integer,List<Transcation>> customer:transcationList.entrySet()) {
			if(loginUser.getAccNo()==customer.getKey()) {
				transaction=customer.getValue();
			}
		}
		
		return transaction;
	}

	

	

	
}
