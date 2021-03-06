package com.revature.project0;

import java.util.Scanner;

public class Menu {

	static Main p1 = new Main();
	static Customer c1 = new Customer();

	
	public static void display(int acc_no) {
		System.out.println(
				"1.View balance\n2.Make a transaction\n3.Send money\n4.Account details\n5.create new account\n6.logout\n7.logout and exit\n");
		Scanner scan = new Scanner(System.in);
		int choice = scan.nextInt();
		if (choice == 1) {
			System.out.println("Your current balance is: " + c1.viewbal(acc_no));
			Menu.display(acc_no);
		} else if (choice == 2) {
			System.out.println("Select an option:\n1.Withdrawl\n2.Deposit\n");
			int modeofTransaction = scan.nextInt();
			if (modeofTransaction == 1) {
				System.out.println("Enter the amount to withdraw: ");
				int withdrawTemp = scan.nextInt();
				c1.transactionWithdrawl(withdrawTemp, acc_no);
				Menu.display(acc_no);
			} else if (modeofTransaction == 2) {
				System.out.println("Enter the amount to deposit: ");
				int withdrawTemp = scan.nextInt();
				c1.transactionDeposit(withdrawTemp, acc_no, 0);
				Menu.display(acc_no);
			}
		} else if (choice == 3) {
			System.out.println("Enter the acc_no of the reciever: ");
			int recacc_no = scan.nextInt();
			System.out.println("Enter your amount to transfer: ");
			int sendamount = scan.nextInt();
			c1.transactionWithdrawl(sendamount, acc_no);
			c1.transactionDeposit(sendamount, recacc_no, 1);
			Menu.display(acc_no);
		} else if (choice == 4) {
			c1.accDetails(acc_no);
		} else if (choice == 5) {
			c1.createNewAcc();
		} else if (choice == 6) {
			System.out.println("logged out!! please login to continue..!");
			p1.loginMain();
		} else if (choice == 7) {
			System.out.println("Application Closed");
			System.exit(0);
		}

	}
}
