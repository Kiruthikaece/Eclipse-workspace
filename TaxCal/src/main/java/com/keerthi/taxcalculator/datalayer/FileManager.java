package com.keerthi.taxcalculator.datalayer;

import java.util.*;

import com.keerthi.taxcalculator.model.Tax;

public class FileManager {
	
	Map<Long,Tax>  taxList=new HashMap<>();
	
	
      
	
	private static FileManager fileManager;
	
	
	 private FileManager() {
	        Tax tax1 = new Tax();
	        tax1.setAmount1(0L);
	        tax1.setAmount2(10000L);
	        tax1.setTax(10);
	        taxList.put(tax1.getAmount1(), tax1);

	        Tax tax2 = new Tax();
	        tax2.setAmount1(10001L);
	        tax2.setAmount2(50000L);
	        tax2.setTax(20);
	        taxList.put(tax2.getAmount1(), tax2);
	    }

	 
	public static FileManager getInstance() {
		if(fileManager==null)
			fileManager=new FileManager();
		
		return fileManager;
		
		
	}

	public boolean AddTaxFile(Tax tax) {
		
		   for(Map.Entry<Long,Tax> mpp:taxList.entrySet()) {
			   if(mpp.getKey()==tax.getAmount1())
				   return false;
		   }
		   taxList.put(tax.getAmount1(),tax);
		   
		   return true;
	}
	
	
}
