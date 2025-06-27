package com.keerthi.atm;

import com.keerthi.atm.mainmenu.MainMenuView;

public class AtmMain {

    private static AtmMain atmMain;

    private static String appName="ATM";

    private static String appVersion="0.0.0";

    public static String getAppName() {
        return appName;
    }

    public static String getAppVersion() {
        return appVersion;
    }
    public static AtmMain getInstance() {
        if(atmMain==null)
        atmMain=new AtmMain();


        return atmMain;
    } 

    public void init() {
        MainMenuView mainMenuView = new MainMenuView();
        mainMenuView.showMenu();
    }
   
    public static void main(String[] args) {
        AtmMain.getInstance().init();
    }
}
