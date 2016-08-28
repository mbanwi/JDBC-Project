package com.stanley.databasemanagers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;
import com.stanley.data.Donation;
import com.stanley.data.Donor;
import com.stanley.util.DatabaseConnection;

public class DonationDBManager {

	
	//==================I N S E R T====================================
	/**
	 * @param donation
	 * @return id of donor who made the donation
	 */
	public String insertDonation(Donation donation){
		
		//donor_id, amount, data, type
		Connection connection;
		
		try{
			
			connection = DatabaseConnection.getConnection();	
		
		//statement
		java.sql.Statement mystmt = connection.createStatement();
		String sql = "INSERT INTO donations " 
	            + " (donor_id, amount, date, type)"
	            + " VALUES ('"
	            + donation.getDonor_Id() + "','" 
	            + donation.getAmount() + "','"
	            + donation.getDate() + "','" 
	            + donation.getType() + "');" ;
	
		mystmt.executeUpdate(sql);
		
		}catch(SQLException e){
			e.printStackTrace();
		}
		return donation.getDonor_Id();
	}

	/**
	 * Returns a donation object for the given donationId.
	 * If donationId does not exist, returns null.
	 * @param donationId
	 * @return a donation object
	 */
	//==================S E L E C T=====================================
	public Donation getDonation(String donationId) {
		
		Connection connection;
		Donation donation = null;
		
            try {
			
			connection = DatabaseConnection.getConnection();
			
			//execute db insert
			java.sql.Statement mystmt = connection.createStatement();
			
			String sql = "SELECT * FROM donations where donor_id = '" + donationId + "';";
			ResultSet rs = mystmt.executeQuery(sql);
			 
			while(rs.next()){
				
				donation =  new Donation();
				donation.setDonor_Id(rs.getString("donor_id"));
				donation.setAmount(rs.getDouble("amount"));
				donation.setDate(rs.getString("date"));
				donation.setType(rs.getString("type"));
				
			}		
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		
		return donation;
	}
	
	//======================U P D A T E==============================
	/**
	 * 
	 * @param donation
	 * @return void 
	 * 
	 */
	public String updateDonation(Donation donation){
		
		//donor_id, amount, data, type
		Connection connection;
		
		try{
			
			connection = DatabaseConnection.getConnection();	
		//"UPDATE Registration " +
        //    "SET age = 30 WHERE id in (100, 101)";
		//statement
		java.sql.Statement mystmt = connection.createStatement();
		String sql = "UPDATE donations SET amout = "+ donation.getAmount() + 
				     " where donor_id = '" + donation.getDonor_Id() + "';";
	      
		mystmt.executeUpdate(sql);
		
		}catch(SQLException e){
			e.printStackTrace();
		}
		return donation.getDonor_Id();
	}
	
	//=======================D E L E T E=======================================
	/**
	 * Takes a donationId and deletes corresponding row
	 * @param donationId
	 * @return True if succesfull
	 */
	public boolean deleteDonation(Donation donationId){
		
		//donor_id, amount, data, type
		Connection connection;
		
		try{
			
			connection = DatabaseConnection.getConnection();	
		//	"DELETE FROM Registration " +
          //  "WHERE id = 101";
		//statement
		java.sql.Statement mystmt = connection.createStatement();
		String sql = "DELETE FROM donations WHERE donor_id = '"+ donationId + "';";	      
		mystmt.executeUpdate(sql);
		
		}catch(SQLException e){
			e.printStackTrace();
		}
		return true;
	}
	
	
}
