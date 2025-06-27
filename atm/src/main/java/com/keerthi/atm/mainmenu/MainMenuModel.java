package com.keerthi.atm.mainmenu;

import com.keerthi.atm.datalayer.FileManagement;

public class MainMenuModel {

    private MainMenuView mainMenuView;

    public MainMenuModel(MainMenuView mainMenuView) {
        this.mainMenuView=mainMenuView;
    }
    
    public void getAllData() {
    	FileManagement.getInstance().getAllDataFromJson();
    }


}
