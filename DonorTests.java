package com.stanley.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.stanley.data.Donation;
import com.stanley.data.Donor;
import com.stanley.databasemanagers.DonationDBManager;
import com.stanley.databasemanagers.DonorDbManager;

public class DonorTests {

	@Test
	public void addDonorSuccess() {
		//donor object to use for testing
		Donor donorInput = new Donor();
		donorInput.setFirstname("jacob");
		donorInput.setLastname("ekoko");
		donorInput.setAddress("2313 Glandrile");
		donorInput.setEmail("ekwa@haha.ca");
		donorInput.setPhone("512-33-2222");
		
		
		
		//create MANAGER OBJECTS
		DonorDbManager donorManager = new DonorDbManager();
		
		//insert donor 
		String donorId = donorManager.insertDonor(donorInput);
		Donor donorOut = donorManager.getDonor(donorId);
		
		
		assertEquals("2", donorInput.getId());//true if donor gets inserted
		assertEquals(null, donorInput.getId());// if not
		
		
		//get or select donor
		assertEquals(donorId, donorOut.getId());
		assertEquals(donorInput.getFirstname(), donorOut.getFirstname());
		assertEquals(donorInput.getLastname(), donorOut.getFirstname());
		assertEquals(donorInput.getFirstname(), donorOut.getFirstname());
		
	}
}
