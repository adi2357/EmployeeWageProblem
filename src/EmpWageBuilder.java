import java.util.ArrayList;

public class EmpWageBuilder{

	public static final int isFullTime=1;
	public static final int isPartTime=2;
	
	
	private ArrayList<CompanyEmpWage> companyEmpWageArray;
	
	
	public EmpWageBuilder() {
		companyEmpWageArray=new ArrayList<CompanyEmpWage>();
	}
	public void addCompanyEmpWage(CompanyEmpWage company) {
		companyEmpWageArray.add(company);
	}
	private void computeEmpWage() {
		for(int i=0; i<companyEmpWageArray.size(); i++) {
			companyEmpWageArray.get(i).setTotalEmpWage(this.computeEmpWage(companyEmpWageArray.get(i)));
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
		CompanyEmpWage vMart=new CompanyEmpWage("V Mart",20,15,80);
		CompanyEmpWage infosys=new CompanyEmpWage("Infosys",15,18,100);
		empBuilderObject.addCompanyEmpWage(vMart);
		empBuilderObject.addCompanyEmpWage(infosys);
		empBuilderObject.computeEmpWage();		
		
	}
}
