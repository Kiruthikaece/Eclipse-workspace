package com.keerthi.atm.mainmenu;

import java.util.Scanner;

import com.keerthi.atm.atmoperation.*;
import com.keerthi.atm.customermanagement.CustomerManagementView;

public class MainMenuView {

    private MainMenuModel mainMenuModel;

    public MainMenuView() {
        mainMenuModel=new MainMenuModel(this);
    }

    Scanner sc=new Scanner(System.in);
    
    public void showMenu() {
    	mainMenuModel.getAllData();
        while(true) {
            System.out.println("-----------------------");
            System.err.println("\n1- Load cash  \n2-Show Customer Details \n3- Show Atm Operations \n4-Exit");
            System.out.println("-----------------------");

            System.out.println("Enter choice:");
            int choice=sc.nextInt();
            
            switch(choice) {
                case 1: new AtmOperationView().loadCashToAtm();
                        break;
                case 2: new CustomerManagementView().showCustomerDetails();
                        break;
                case 3:new AtmOperationView().showAtmOperations();
                        break;

                case 4:System.err.println("Thank you!");
                        return;

                default:return;
            }
        }
    }


    
}
