package com.keerthi.atm;

public class Atm {
	 private int cash1000;
	    private int cash500;
	    private int cash100;
	    
	    public int getTotal() {
	        return (cash1000*1000)+(cash500*500)+(cash100*100);
	    }
	    public int getCash1000() {
	        return cash1000;
	    }
	    public void setCash1000(int cash1000) {
	        this.cash1000 = cash1000;
	    }
	    public int getCash500() {
	        return cash500;
	    }
	    public void setCash500(int cash500) {
	        this.cash500 = cash500;
	    }
	    public int getCash100() {
	        return cash100;
	    }
	    public void setCash100(int cash100) {
	        this.cash100 = cash100;
	    }
		
}
