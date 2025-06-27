package com.keerthi.taxcalculator.admin;

import com.keerthi.taxcalculator.datalayer.FileManager;
import com.keerthi.taxcalculator.model.Tax;

public class AdminModel {
	
	private AdminView adminView;

	public AdminModel(AdminView adminView) {
		this.adminView=adminView;
	}

	public void validateTax(Tax tax) {
		if(FileManager.getInstance().AddTaxFile(tax)) {
			adminView.showMessage("Amount added successfully");
		}else
			adminView.showMessage("Amount added failed");
	}

}
