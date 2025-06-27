package com.keerthi.taxcalculator;

import com.keerthi.taxcalculator.login.LoginView;

public class TaxMain {
	
	   private static TaxMain taxMain;
	   
	   public static TaxMain getInstance() {
		   if(taxMain==null)
		   taxMain = new TaxMain();
		   
		   return taxMain;
	   }
	   
	   public void init() {
		   LoginView login=new LoginView();
		   login.showMainMenu();
	   }
	   
	   public static void main(String[] args) {
		     TaxMain.getInstance().init();
	   }
}
