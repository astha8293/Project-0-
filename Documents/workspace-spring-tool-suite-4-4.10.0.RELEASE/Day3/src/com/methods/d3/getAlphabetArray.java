package com.methods.d3;

public class getAlphabetArray {
	    public static void main(String[] args)
	    {
	     
	           char[] alphabet = new char[26];
	          
	               
	           for(char ch = 'a'; ch <= 'z'; ++ch)
	           {
	               alphabet[ch-'a']=ch;
	           } 
	          
	               
	          System.out.print(alphabet);
	    }

}
