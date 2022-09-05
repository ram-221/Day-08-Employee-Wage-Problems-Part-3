package com.bridgelabday08;

public class EmployeeWage {


	public static final int IS_FULL_TIME = 2;
	public static final int IS_PART_TIME = 1;
	
	public static int computeEmpWage(String company, int empRatePerHrs, 
			                  int numOfWorkingDays, int maxHrsPerMonth) {
		
		int empHrs = 0, totalEmpHrs = 0,totalWorkingDays = 0;
		
		while(totalEmpHrs <= maxHrsPerMonth && totalWorkingDays < numOfWorkingDays) {
			
			int empCheck = (int)Math.floor(Math.random() * 10) % 3;
			
			switch (empCheck) {
			case IS_FULL_TIME:
				empHrs = 8;
				break;
			case IS_PART_TIME:
				empHrs = 4;
				break;
			default:
				empHrs = 0;
				break;
			}
			
			totalEmpHrs += empHrs;
			System.out.println("Day#: "+totalWorkingDays + "EmpHrs: "+empHrs);
		}
		
		int totalEmpWage = totalEmpHrs * empRatePerHrs;
		System.out.println("Total Emp Wage "+totalEmpWage);
		return totalEmpWage;
	}
	
	public static void main(String[] args) {
		computeEmpWage("Infosys",20,2,10);
		computeEmpWage("Reliance",10,6,20);
	}
}

