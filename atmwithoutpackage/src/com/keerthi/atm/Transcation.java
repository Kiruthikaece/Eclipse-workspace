package com.keerthi.atm;

public class Transcation {

	
	private int id;
	private String remark;
	private String type;
	private int amount;
	
	public Transcation(String remark2, String type2, int amount2) {
		remark=remark2;
		type=type2;
		amount=amount2;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
}
