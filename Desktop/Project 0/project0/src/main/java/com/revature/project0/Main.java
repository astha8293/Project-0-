package com.revature.project0;

import java.lang.System.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
	private String psw1;
	static Customer c1 = new Customer();
	static Employee e1 = new Employee();
	static Menu d1 = new Menu();
	static EmpDisplay ed1 = new EmpDisplay();
	Connection con = null;

	public static void loginMain() {
		Scanner scan = new Scanner(System.in);
		try {
			Connection con = ConnectionUtils.getConnection();
			System.out.println("Enter 1 for login and 2 to register an account:");
			int a = scan.nextInt();
			// -----------
			if (a == 1) {
				System.out.println("1. Customer Login \n2. Employee Login");
				int b = scan.nextInt();
				if (b == 1) {
					System.out.println("Enter your Acc_no:");
					int acc_no1 = scan.nextInt();
					System.out.println("Enter your password:");
					String psw1 = scan.next();
					boolean bool1 = c1.login(acc_no1, psw1);
					if (bool1 == true) {
						System.out.println("login sucessful");
						d1.display(acc_no1);

					} else {
						System.out.println("Account yet to be approved or invalid data");
						loginMain();
					}
				} else if (b == 2) {
					System.out.println("Enter your Acc_no:");
					String acc_no1 = scan.next();
					System.out.println("Enter your password:");
					String psw1 = scan.next();
					boolean bool1 = e1.login(acc_no1, psw1);
					if (bool1 == true) {
						System.out.println("login successfull");
						ed1.display();

					} else {
						System.out.println("Please check the Acc_no and password");
						loginMain();
					}

				}
				
			} else if (a == 2) {
				System.out.println("Fill into the below details\n");
				c1.createCustomerAcc();

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		loginMain();

	}
}
