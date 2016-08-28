package com.stanley.data;

import java.sql.Date;

public class Donation {
//donor_id, date, amount, type
	private String donor_Id;
	private String date;
	private double amount;
	private String type;
	
	//getters and setters
	public double getAmount() {
		return amount;
	}
	public void setAmount(Double string) {
		this.amount = string;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String data) {
		this.date = data;
	}
	public String getDonor_Id() {
		return donor_Id;
	}
	public void setDonor_Id(String donor_Id) {
		this.donor_Id = donor_Id;
	}
}
