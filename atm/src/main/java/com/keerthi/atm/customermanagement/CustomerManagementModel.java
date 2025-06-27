package com.keerthi.atm.customermanagement;

import java.util.Map;

import com.keerthi.atm.datalayer.FileManagement;
import com.keerthi.atm.model.Customers;

public class CustomerManagementModel {

    private CustomerManagementView customerManagementView;

    public CustomerManagementModel(CustomerManagementView customerManagementView) {
       this.customerManagementView=customerManagementView;
    }

   
    public void ValidateCustomers(Customers customer) {
       if(FileManagement.getInstance().addCustomerToJson(customer))
       customerManagementView.showMessage("customers add successfully");
       else
       customerManagementView.showMessage("Already customers exist");
       
    }


    public void printCustomers() {
        customerManagementView.ShowAllCustomers(FileManagement.getInstance().geAllCustomers());
    }


}