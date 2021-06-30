package com.revature.project0;

import java.util.Scanner;

public class EmpDisplay {
	static Employee e1 = new Employee();
	static Main p1 = new Main();
	public static void display() {
		System.out.println("1.view customer accounts\n2.pending approvals\n3.view logs\n4.logout\n5.logout and exit\n");
		Scanner scan = new Scanner(System.in);
		int choice = scan.nextInt();
		if(choice == 2) {
			e1.acceptReject();
		}else if(choice==1){
			e1.viewCustomerDetails();
			EmpDisplay.display();
		}
		else if (choice==3) {
			e1.viewLogs();
		}
		else if (choice == 4) {
			System.out.println("logged out!! please login to continue...!");
			p1.loginMain();
		} else if (choice == 5) {
			System.out.println("Application Closed");
			System.exit(0);
		}
	}

}
