package com.astha.utils;

public class Salaryemp extends Emp {
	private double salary;
	SalaryEmp(){}
	public Salaryemp(int id, String name, String department, double salary) {
		super(id, name, department);
		this.salary = salary;
	}
	public double getSalary() {
		return salary;
	}
	public void setsalary(double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Salaryemp [salary=" + salary + "]";
	}
	
	

}
