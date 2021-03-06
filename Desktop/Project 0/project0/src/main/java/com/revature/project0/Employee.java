package com.revature.project0;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Employee extends User implements EmpInterface {
	private String id;
	private String password;

	Connection con = ConnectionUtils.getConnection();

	Scanner scan = new Scanner(System.in);
	static Customer c1 = new Customer();

	@Override
	public boolean login(String id, String password) {
		// TODO Auto-generated method stub
		this.id = id;
		this.password = password;
		boolean bool = false;
		String query01 = "select * from employee where empid=? and passw=?";
		try {
			PreparedStatement stmt = con.prepareStatement(query01);
			stmt.setString(1, id);
			stmt.setString(2, password);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				stmt.close();
				bool = true;
			} else {
				stmt.close();
				bool = false;
			}

			// con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bool;
	}

	@Override
	public void createCustomerAcc() {
		// TODO Auto-generated method stub

	}

//----------------------------------------------------
	@Override
	public void viewCustomerDetails() {
		// TODO Auto-generated method stub
		String query01 = "select acc_no from customer";
		try {
			PreparedStatement stmt = con.prepareStatement(query01);
			ResultSet rs = stmt.executeQuery();
			System.out.println("select acc_no to view in detail.");
			while (rs.next()) {
				System.out.println(" " + rs.getInt("acc_no"));
			}
			int selectedId = scan.nextInt();
			c1.accDetails(selectedId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void acceptReject() {
		// TODO Auto-generated method stub
		String query01 = "select acc_no from customer where approval = 0";
		String query02 = "update customer set approval = 1 where acc_no = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(query01);
			ResultSet rs = stmt.executeQuery();
			System.out.println("needs approval!");
			while (rs.next()) {
				System.out.println(" " + rs.getInt("acc_no"));
			}
			System.out.println("enter the acc_no you want to approve: ");
			int approvedId = scan.nextInt();
			PreparedStatement stmt1 = con.prepareStatement(query02);
			stmt1.setInt(1, approvedId);
			stmt1.execute();
			System.out.println("Approved successfully! Acc_no: " + approvedId);
			EmpDisplay.display();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void viewLogs() {
		// TODO Auto-generated method stub
			  File file = new File("F:/JDBC/Project0/Banklogs.log");
			  BufferedReader br;
			try {
				br = new BufferedReader(new FileReader(file));
				String st;
				System.out.println("The Transactions are: ");
				while ((st = br.readLine()) != null)
				    System.out.println(st);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    catch (IOException e) {
		    	
		    }
		 

	}

	@Override
	public boolean login(int acc_no, String password) {
		// TODO Auto-generated method stub
		return false;
	}
}
