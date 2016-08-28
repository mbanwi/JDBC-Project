package com.stanley.databasemanagers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import com.stanley.data.Donation;
import com.stanley.data.Donor;
import com.stanley.util.DatabaseConnection;

public class DonorDbManager {

	/**
	 * 
	 * @param donor
	 * @return id of donor
	 */
	public String insertDonor(Donor donor) {
		//get db connection
		Connection connection;
		String id = UUID.randomUUID().toString();
		
		try {
			
			connection = DatabaseConnection.getConnection();
			
			//execute db insert
			java.sql.Statement mystmt = connection.createStatement();
			 
			String sql = "INSERT INTO donors " 
				            + " (id, firstname, lastname, email, phonenumber, address)"
				            + " VALUES ('"
				            + id + "', '"
				            + donor.getFirstname() + "','" 
				            + donor.getLastname() + "','" 
				            + donor.getEmail() + "','" 
				            + donor.getPhone() + "','" 
				            + donor.getAddress() + "');" ;
				
			mystmt.executeUpdate(sql);			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Insertion completed at this particular time below...");
		/*printing out the row elements
        System.out.print("ID: " + id);
        System.out.print(", Age: " + donor.getFirstname()+"\n");
        System.out.print(", First: " + donor.getLastname()+"\n");
        System.out.println(", Last: " + donor.getEmail()+"\n");
		*/
		return id;
	}
	
	/**
	 * Returns a donor object for the given donorId.
	 * If donorId does not exist, returns null.
	 * @param donorId
	 * @return donor if it exist; otherwise returns null.
	 */
	public Donor getDonor(String donorId) {
		
		Connection connection;
		Donor donor = null;
		
		try {
			
			connection = DatabaseConnection.getConnection();
			
			//execute db insert
			java.sql.Statement mystmt = connection.createStatement();
			
			String sql = "SELECT * FROM donors where id = '" + donorId + "';";
			ResultSet rs = mystmt.executeQuery(sql);
			 
			while(rs.next()){
				
				donor =  new Donor();
				//Retrieve by column name
				donor.setId(rs.getString("id"));
				donor.setFirstname(rs.getString("firstname"));
				donor.setLastname(rs.getString("lastname"));
				donor.setFirstname(rs.getString("email"));
				donor.setFirstname(rs.getString("address"));
				donor.setFirstname(rs.getString("phone"));	
				
			}	
			/*print out
			System.out.print("ID: " + rs.getString("id"));
	        System.out.print(", firstname: " + rs.getString("firstname"));
	        System.out.print(", lastname: " + rs.getString("lastname"));
	        System.out.println(", email: " + rs.getString("email"));
	        System.out.println(", address: " + rs.getString("address"));
	        System.out.println(", phone: " + rs.getString("phone"));
	        */
		}catch(SQLException ex){
			
		}		 
		
		return donor;
	}
	
	//======================U P D A T E==============================
		/**
		 * 
		 * @param donation
		 * @return void 
		 * 
		 */
		public String updateDonor(Donor donor){
			
			//donor_id, amount, data, type
			Connection connection;
			
			try{
				
				connection = DatabaseConnection.getConnection();	
			//"UPDATE Registration " +
	        //    "SET age = 30 WHERE id in (100, 101)";
			//statement
			java.sql.Statement mystmt = connection.createStatement();
			String sql = "UPDATE donors SET phonenumber = '"+ donor.getPhone() + 
					     "' where id = '" + donor.getId() + "';";
		      
			mystmt.executeUpdate(sql);
			
			}catch(SQLException e){
				e.printStackTrace();
			}
			return donor.getId();
		}
		
		//=======================D E L E T E=======================================
		/**
		 * Takes a donationId and deletes corresponding row
		 * @param donationId
		 * @return True if succesfull
		 */
		public boolean deleteDonor(String donorId){
			
			//donor_id, amount, data, type
			Connection connection;
			
			try{
				
				connection = DatabaseConnection.getConnection();	
			
				java.sql.Statement mystmt = connection.createStatement();
				String sql = "DELETE FROM donors WHERE id = '"+ donorId + "';";
			
				mystmt.executeUpdate(sql);
			
				}catch(SQLException e){
					e.printStackTrace();
				}
				return true;
			}
	}
