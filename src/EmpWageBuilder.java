import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class EmpWageBuilder implements CompanyEmpManagement{

	public static final int isFullTime=1;
	public static final int isPartTime=2;
	
	
	private ArrayList<CompanyEmpWage> companyEmpWageArray;
	private Map<String,CompanyEmpWage> companyToEmployeeMap;
	
	
	public EmpWageBuilder() {
		companyEmpWageArray=new ArrayList<CompanyEmpWage>();
		companyToEmployeeMap=new HashMap<>();
	}
	public void addCompanyEmpWage(CompanyEmpWage company) {
		companyEmpWageArray.add(company);
		companyToEmployeeMap.put(company.companyName, company);
	}
	public void computeEmpWage() {
		for(int i=0; i<companyEmpWageArray.size(); i++) {
			companyEmpWageArray.get(i).setTotalEmpWage(this.computeEmpWage(companyEmpWageArray.get(i)));
		}
	}
	
	public int getTotalWage(String company) {
		return companyToEmployeeMap.get(company).totalEmpWage;
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
			
		}
		totalEmpWage+=totalEmpHours*companyEmpWage.wagePerHour;
		return totalEmpWage;
	}
	public static void main(String[] args){

		EmpWageBuilder empBuilderObject=new EmpWageBuilder();
		CompanyEmpWage vMart=new CompanyEmpWage("V Mart",20,15,80);
		CompanyEmpWage infosys=new CompanyEmpWage("Infosys",15,18,100);
		empBuilderObject.addCompanyEmpWage(vMart);
		empBuilderObject.addCompanyEmpWage(infosys);
		empBuilderObject.computeEmpWage();
		System.out.println("Total Wage for V Mart Company is : "+ empBuilderObject.getTotalWage(vMart.companyName));
		System.out.println("Total Wage for Infosys Company is : "+ empBuilderObject.getTotalWage(infosys.companyName));

		
	}
}
