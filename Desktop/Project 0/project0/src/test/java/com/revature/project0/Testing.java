package com.revature.project0;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Testing {
	
		static Customer c1 = new Customer();
		static Employee e1 = new Employee();
		@BeforeEach
		void beforeEach() {
			System.out.println("execution started");
		}
		@BeforeAll
		static void beforeAll() {
			System.out.println("STARTING");
		}
		@AfterAll
		static void afterAll() {
			System.out.println("Both cases done");
		}
		@AfterEach
		void afterEach() {
			System.out.println("Execution done!!");
		}
		@Test
		void testOne() {
			System.out.println("Test one Execution Started!!");
			Assertions.assertEquals(true,c1.login(12000,"astha123"));
			Assertions.assertEquals(5500,c1.viewbal(12000));
			Assertions.assertEquals(true,e1.login("emp1","123"));
		}
		@Test
		void testTwo() {
			String pass = "sk123";
			System.out.println("Test Two Execution Started!!");
			Assertions.assertEquals(true,c1.login(12001,pass));
			Assertions.assertEquals(5500,c1.viewbal(12001));
			Assertions.assertEquals(false,e1.login("emp2",pass));
	
	}

}
