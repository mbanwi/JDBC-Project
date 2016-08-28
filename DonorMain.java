package com.stanley.tests;

import com.stanley.data.Donation;
import com.stanley.data.Donor;
import com.stanley.databasemanagers.DonationDBManager;
import com.stanley.databasemanagers.DonorDbManager;

public class DonorMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DonorDbManager donorManager = new DonorDbManager();
		
		Donor donorInput = new Donor();
		donorInput.setFirstname("jacob");
		donorInput.setLastname("ekoko");
		donorInput.setAddress("2313 Glandrile");
		donorInput.setEmail("ekwa@haha.ca");
		donorInput.setPhone("512-33-2222");
		
		//insert
		String donorId = donorManager.insertDonor(donorInput);
		
		//get
		Donor donorOut = donorManager.getDonor(donorId);
		
		System.out.println(donorOut);
		
		//****************lets try to insert a donation*****************************
		//'2016-10-16 00:00:00'
		DonationDBManager donationManager = new DonationDBManager();
		
		Donation donationInput = new Donation();
		donationInput.setDonor_Id("4");
		donationInput.setAmount(30.25);
		donationInput.setDate("2016-10-16 00:00:00");
		donationInput.setType("help d poor");
		
		//now insert a donation
		String donationId = donationManager.insertDonation(donationInput);
		System.out.println(donationId);
		
		//****************lets try to insert a donation*****************************
		//'2016-10-16 00:00:00'
		//get
		Donation donationOut = donationManager.getDonation(donationId);
				
		
	}

}
