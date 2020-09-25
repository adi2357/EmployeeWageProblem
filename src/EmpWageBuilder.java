

public class EmpWageBuilder implements CompanyEmpManagement{

	public static final int isFullTime=1;
	public static final int isPartTime=2;
	
	private int numOfCompany=0;
	private CompanyEmpWage[] companyEmpWageArray;
	
	
	public EmpWageBuilder() {
		companyEmpWageArray=new CompanyEmpWage[5];
	}
	public void addCompanyEmpWage(String companyName, int wagePerHour, int maxWorkingDays, int maxHours) {
		companyEmpWageArray[numOfCompany] = new CompanyEmpWage(companyName, wagePerHour, maxWorkingDays, maxHours);
		numOfCompany++;
	}
	public void computeEmpWage() {
		for(int i=0; i<numOfCompany; i++) {
			companyEmpWageArray[i].setTotalEmpWage(this.computeEmpWage(companyEmpWageArray[i]));
		}
	}
	
	public int computeEmpWage(CompanyEmpWage companyEmpWage) {
		int empHours=0;
		int totalEmpHours=0;
		int totalWorkingDays=0;
		int totalEmpWage=0;
		while(totalEmpHours<= companyEmpWage.maxHours && totalWorkingDays<= companyEmpWage.maxWorkingDays){
			totalWorkingDays++;
			int empCheck=(int)Math.floor(Math.random()*10)%3;
			switch(empCheck){
				case isFullTime:
					empHours=8;
					break;
				case isPartTime:
					empHours=4;
					break;
				default:
				empHours=0;
			}
			totalEmpHours+=empHours;
			System.out.println("Day : "+totalWorkingDays+" Employee Hours : "+empHours);
		}
		totalEmpWage+=totalEmpHours*companyEmpWage.wagePerHour;
		System.out.println("Total Employee Wage for Comapny :  "+companyEmpWage.companyName +" is : "+totalEmpWage);
		return totalEmpWage;
	}
	public static void main(String[] args){

		EmpWageBuilder empBuilderObject=new EmpWageBuilder();
		empBuilderObject.addCompanyEmpWage("V Mart",20,15,80);
		empBuilderObject.addCompanyEmpWage("Reliance",15,18,100);
		empBuilderObject.computeEmpWage();		
		
	}
}
