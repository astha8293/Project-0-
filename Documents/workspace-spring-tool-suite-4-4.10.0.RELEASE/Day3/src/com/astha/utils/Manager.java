package com.astha.utils;

public class Manager {
	public static void main(String[] args) {
		Salaryemp SE1 = new Salaryemp(1,"astha","it",10000);
		System.out.println(SE1);
		System.out.println(SE1.getAllowances());
		System.out.println(SE1.payTaxes());
		ContractualEmployee CE1n= new ContractualEmployee(2,"ansh","IT",100);
		System.out.println(CE1);
		System.out.println(CE1.getAllowances());
		
		
	}
}
