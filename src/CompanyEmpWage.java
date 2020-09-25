
public class CompanyEmpWage {
	
	public final String companyName;
	public final int wagePerHour;
	public final int maxWorkingDays;
	public final int maxHours;
	public int totalEmpWage;
	
	public CompanyEmpWage(String companyName, int wagePerHour, int maxWorkingDays, int maxHours) {
		super();
		this.companyName = companyName;
		this.wagePerHour = wagePerHour;
		this.maxWorkingDays = maxWorkingDays;
		this.maxHours = maxHours;
	}

	public void setTotalEmpWage(int totalEmpWage) {
		this.totalEmpWage = totalEmpWage;
	}
	
	@Override
	public String toString() {
		   return "Total Emp wage for company: "+companyName+ " is:"+totalEmpWage;		   
	   }

}
