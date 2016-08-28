package com.stanley.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.stanley.data.Donation;
import com.stanley.data.Donor;
import com.stanley.databasemanagers.DonationDBManager;

public class DonationTest {

	@SuppressWarnings("deprecation")
	
	
	
	@Test
	public void insertSuccess(){
		//donation object to use for testing
				Donation donationIn = new Donation();
				donationIn.setAmount(23.25);
				donationIn.setDonor_Id("2");
				donationIn.setDate("2016-17-05");
				donationIn.setType("offering");
				
				//create donation manager object
				DonationDBManager donationManager = new DonationDBManager();
				
				//insert donor 
				String donationId = donationManager.insertDonation(donationIn);
				Donation donationOut = donationManager.getDonation(donationId);
								
				//get or select donor
				
				assertEquals(donationId, donationOut.getDonor_Id());
				assertEquals(donationIn.getAmount(), donationOut.getAmount());
				assertEquals(donationIn.getDate(), donationOut.getDate());
				assertEquals(donationIn.getType(), donationOut.getType());
	}
	public void deleteSuccess(){
		
		
	}
}
