package com.keerthi.atm.customermanagement;
import java.util.Map;
import java.util.Scanner;
import com.keerthi.atm.model.Customers;

public class CustomerManagementView {

    Scanner sc=new Scanner(System.in);

    private CustomerManagementModel customerManagementModel;

    public CustomerManagementView() {
        customerManagementModel=new CustomerManagementModel(this);
    }

    public void showCustomerDetails() {
         while(true) {
            System.out.println("\n1- Add customers  \n2- Show customers \n3-go back");
            System.out.println("Enter choice:");
            int choice=sc.nextInt();

            switch(choice) {
                
                case 1: addCustomers();
                        break;

                case 2: showCustomers();
                        break;

                default: return;
            }
         }
    }

    private void showCustomers() {
        customerManagementModel.printCustomers();
    }

    private void addCustomers() {
        Customers customer=new Customers();
        System.out.println("Enter Account Number:");
        customer.setAccNo(sc.next());
        System.out.println("Enter Account holder name:");
        customer.setName(sc.next());
        System.out.println("Enter PIN number:");
        customer.setPinNo(sc.nextInt());
        System.out.println("Enter balance:");
        customer.setAmount(sc.nextLong());
        customerManagementModel.ValidateCustomers(customer);
    }

    public void showMessage(String message) {
      System.out.println(message);
    }

  
    public void ShowAllCustomers(Map<String, Customers> geAllCustomers) {
           
        if(geAllCustomers.size()>0)
        for(Map.Entry<String,Customers> entry:geAllCustomers.entrySet()) 
           System.out.println(entry.getKey()+" "+entry.getValue().getName()+" "+entry.getValue().getPinNo()+" "+entry.getValue().getAmount());
           
           else
           System.out.println("No customers");
    }

}
