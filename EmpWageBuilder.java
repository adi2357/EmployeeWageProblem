

public class EmpWageBuilder{

	public static final int isFullTime=1;
	public static final int isPartTime=2;
	
	public final String companyName;
	public final int wagePerHour;
	public final int maxWorkingDays;
	public final int maxHours;
	
	public EmpWageBuilder(String companyName, int wagePerHour, int maxWorkingDays, int maxHours) {
		super();
		this.companyName = companyName;
		this.wagePerHour = wagePerHour;
		this.maxWorkingDays = maxWorkingDays;
		this.maxHours = maxHours;
	}
	public void calculateEmpWage() {
		int empHours=0;
		int totalEmpHours=0;
		int totalWorkingDays=0;
		int totalEmpWage=0;
		while(totalEmpHours<=maxHours && totalWorkingDays<=maxWorkingDays){
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
		totalEmpWage+=totalEmpHours*wagePerHour;
		System.out.println("Total Employee Wage for Comapny :  "+companyName +" is : "+totalEmpWage);
	}
	public static void main(String[] args){

		EmpWageBuilder vMart=new EmpWageBuilder("V Mart",20,15,80);
		EmpWageBuilder reliance=new EmpWageBuilder("Reliance",15,18,100);
		vMart.calculateEmpWage();
		reliance.calculateEmpWage();		
		
	}
}
