package com.junit.test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.junitExamples.day3.Calculator;

public class AppTest {
	
	@BeforeEach
	void beforeEach() {
		System.out.println("Before Each");
	}
	
	@AfterEach
	void afterEach() {
		System.out.println("After Each");
	}
	
	
	@AfterAll
	static void afterAll() {
		System.out.println("After All");
	}
	
	
	
	
	@BeforeAll
	static void beforeAll() {
		System.out.println("Before All");
	}
	
	
	@Test
	void testOne() {
		System.out.println("======TEST ONE EXECUTED=======");
		Assertions.assertEquals( 4 , Calculator.add(2, 2));
	}
	
	
	
	
	@Test
	void testTwo() {
		System.out.println("======TEST TWO EXECUTED=======");
		Assertions.assertEquals( 4 , Calculator.add(2, 2));
	}

}
