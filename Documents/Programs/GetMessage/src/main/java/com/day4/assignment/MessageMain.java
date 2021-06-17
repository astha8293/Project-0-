package com.day4.assignment;

public class MessageMain {
	public static void main(String[] args) {
		int a=50;
		try{
			System.exit(0);
			System.out.println("In try");
			aaa(a);
		}
		catch(GetMessage e) {
			System.out.println("In Catch");
			System.out.println(e.getMessage());
		}
		finally {
			
			System.out.println("Good Bye");
			
		}
		
		
		System.out.println();
		
	}
	public static void aaa(int a) throws GetMessage{
		if(a>20) {
			throw new GetMessage();
		}
		else {
			System.out.println("a is not greater than 20");
		}
	}

}
