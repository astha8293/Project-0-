package com.methods.d3;

import java.util.Random;
public class randomNumber {
	        public static void main(String[] args) {
	        	Random objGenerator = new Random();
	            for (int iCount = 0; iCount< 10; iCount++){
	              int randomNumber = objGenerator.nextInt();
	              System.out.println("Random No : " + randomNumber); 
	             }
	     }
	}

