package com.revature.project0;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Customer extends User implements CusInterface {
	private static final Logger logger = LogManager.getLogger(Customer.class);
	private int acc_no;
	private String password;

	Connection con = ConnectionUtils.getConnection();

	@Override
	public boolean login(int acc_no, String password) {
		// TODO Auto-generated method stub
		this.acc_no = acc_no;
		this.password = password;
		boolean bool = false;
		logger.entry();
		String query01 = "select * from customer where acc_no=? and passw=? and approval=1";
		try {
			PreparedStatement stmt = con.prepareStatement(query01);
			stmt.setInt(1, acc_no);
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
		logger.exit();
		return bool;
		

	}

	@Override
	public void createCustomerAcc() {

		// TODO Auto-generated method stub
		int candidateId = 0;
		ResultSet rs = null;
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter your fist name: ");
		String fname = scan.next();
		System.out.println("Enter your last name: ");
		String lname = scan.next();
		System.out.println("Enter your opening balance: ");
		int bal = scan.nextInt();
		System.out.println("Enter your password:");
		String pass = scan.next();
		try {
			String query01 = "insert into customer(first_name,last_name,balance,passw,approval) values(?,?,?,?,0)";
			PreparedStatement stmt = con.prepareStatement(query01, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, fname);
			stmt.setString(2, lname);
			stmt.setInt(3, bal);
			stmt.setString(4, pass);

			int rowAffected = stmt.executeUpdate();
			if (rowAffected == 1) {
				rs = stmt.getGeneratedKeys();
				if (rs.next())
					candidateId = rs.getInt("acc_no");

				System.out.println("Welcome, " + fname);
				System.out.println("Your Acco_no is: " + candidateId);
				System.out.println("Press 1 to go back to login screen..");
				logger.info("Account Successfully created ");
				int temp0001 = scan.nextInt();
				if (temp0001 == 1) {
					stmt.close();
					Main.loginMain();
				} else {
					stmt.close();
				}
			} else {
				stmt.close();

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// --------------------------------

	@Override
	public void createNewAcc() {
		// TODO Auto-generated method stub
		createCustomerAcc();

	}

	@Override
	public int viewbal(int acc_no) {
		// TODO Auto-generated method stub
		logger.entry();
		int balTemp = 0;
		String query01 = "select balance from customer where acc_no = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(query01);
			stmt.setInt(1, acc_no);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				balTemp = rs.getInt("balance");

			}
			logger.info("Balance is :" +balTemp);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		logger.exit();
		return balTemp;

	}

	@Override
	public void transactionWithdrawl(int amount, int acc_no) {
		logger.entry();
		// TODO Auto-generated method stub
		int balanceT = viewbal(acc_no);
		System.out.println("Processing withdrawl...");

		if (balanceT > amount && amount > 0) {
			balanceT = balanceT - amount;
			String query01 = "update customer set balance = ? where acc_no = ?";
			try {
				PreparedStatement stmt = con.prepareStatement(query01);
				stmt.setInt(1, balanceT);
				stmt.setInt(2, acc_no);
				stmt.execute();
				System.out.println("Transaction Successfull..");
				System.out.println("Your current balance is: " + viewbal(acc_no));
				logger.info("Withdrawal successfull");

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("Transaction Failed!!..Insufficient funds..try again!!");
			Menu.display(acc_no);
		}
		logger.exit();
		
	}

	@Override
	public void transactionDeposit(int amount, int acc_no, int params) {
		// TODO Auto-generated method stub
		int balanceT = viewbal(acc_no);
		if (amount > 0) {
			balanceT = balanceT + amount;
			String query01 = "update customer set balance = ? where acc_no = ?";
			try {
				PreparedStatement stmt = con.prepareStatement(query01);
				stmt.setInt(1, balanceT);
				stmt.setInt(2, acc_no);
				stmt.execute();
				if (params == 0) {
					System.out.println("Transaction Successfull..");
					System.out.println("Your current balance is: " + viewbal(acc_no));
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block

				e.printStackTrace();
			}
		} else {
			System.out.println("Transaction Failed!!.. Amount is not valid.....");
			Menu.display(acc_no);
		}
	}

	@Override
	public void accDetails(int acc_no) {
		// TODO Auto-generated method stub
		String query01 = "select * from customer where acc_no=?";
		try {
			PreparedStatement stmt = con.prepareStatement(query01);
			stmt.setInt(1, acc_no);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				System.out.println("Name :" + rs.getString("first_name") + " " + rs.getString("last_name") + "\n"
						+ "Account_no: " + rs.getInt("acc_no") + "\n" + "Your balance is : " + rs.getInt("balance"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Menu.display(acc_no);
	}
}
