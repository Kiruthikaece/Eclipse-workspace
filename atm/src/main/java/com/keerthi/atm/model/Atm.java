package com.keerthi.atm.model;

public class Atm {
    
    private int id;
    private  long loadAmount;
    private long currentAmount;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public long getLoadAmount() {
        return loadAmount;
    }
    public void setLoadAmount(long loadAmount) {
        this.loadAmount = loadAmount;
    }
    public long getCurrentAmount() {
        return currentAmount;
    }
    public void setCurrentAmount(long currentAmount) {
        this.currentAmount = currentAmount;
    }


}
