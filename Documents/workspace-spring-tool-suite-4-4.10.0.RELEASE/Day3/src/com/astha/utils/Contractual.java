package com.astha.utils;

public class Contractual extends Employee {
	private int hours;
	
	public Contractual() {
		super();
		
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public Contractual(int id, String name, String dept, int hours) {
		super(id, name, dept);
		this.hours = hours;
	}

	@Override
	public String toString() {
		return super.toString()+"Contractual [hours=" + hours + "]";
	}
	
	

}
