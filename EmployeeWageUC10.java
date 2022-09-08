package com.bridgelabday08;

 class CompanyEmpWgae {

	public final String company;
	public final int empRatePerHour;
	public final int numOfWorkingDays;
	public final int maxHourPerMonth;
	public int totalEmpWage;
	public CompanyEmpWgae (String company, int empRatePerHour, int numOfWorkingDays, int maxHourPerMonth) {
		this.company = company;
		this.empRatePerHour = empRatePerHour;
		this.maxHourPerMonth = maxHourPerMonth;
		this.numOfWorkingDays = numOfWorkingDays;
	}
	
	public void setTotalEmpWage(int totalEmpWage) {
		this.totalEmpWage = totalEmpWage;
	}
	
	@Override
	public String toString() {
		return  "Total Emp Wage for Company :"  +company+ "is :" +totalEmpWage;
	}
}

public class EmployeeWageUC10 {
	public static final int IS_PART_TIME = 1;
	public static final int IS_FULL_TIME = 2;
	
	private int numOfCompany = 0;
	private CompanyEmpWgae[] companyEmpWageArray;
	
	public EmployeeWageUC10() {
		companyEmpWageArray = new CompanyEmpWgae[5];
	}
	
	private void addCompanyEmpWage(String company, int empRatePerHour, int numOfWorkingDays, int maxHourPerMonth) {
		companyEmpWageArray[numOfCompany] = new CompanyEmpWgae(company, empRatePerHour, 
				numOfWorkingDays, maxHourPerMonth);
	      numOfCompany ++;
	}
	
	private void computeEmpWage() {
		for(int i=1; i <= numOfCompany;i++) {
			companyEmpWageArray[i].setTotalEmpWage(this.computeEmpWage(companyEmpWageArray[i]));
			System.out.println(companyEmpWageArray[i]);
		}
	}
	private int computeEmpWage(CompanyEmpWgae companyEmpWage) {
		int empHrs = 0, totalEmpHrs = 0,totalWorkingDays = 0;
		while(totalEmpHrs <=companyEmpWage.maxHourPerMonth && 
				totalWorkingDays < companyEmpWage.numOfWorkingDays) {
			totalWorkingDays++;
			int empCheck = (int)Math.floor(Math.random() * 10) % 3;
			switch(empCheck) {
			case  IS_PART_TIME :
				empHrs = 4;
				break;
			case IS_FULL_TIME :
				empHrs = 8;
				break;
				default:
					empHrs = 0;
			}
			totalEmpHrs += empHrs;
			System.out.println("Days:"+ totalWorkingDays+ "Emp Hrs :"+empHrs);
		}
		return totalEmpHrs * companyEmpWage.empRatePerHour;
	}
	public static void main(String args[]) {
		EmployeeWageUC10 emp = new EmployeeWageUC10();
		emp.addCompanyEmpWage("BiggBazar",20,2,10);
		emp.addCompanyEmpWage("Mart",10,4,20);
		emp.computeEmpWage();
	}
}