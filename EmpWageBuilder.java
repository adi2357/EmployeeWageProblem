public class EmpWageBuilder{

	public static final int isFullTime=1;
	public static final int isPartTime=2;
	public static final int wagePerHour=20;
	public static final int maxWorkingDays=20;
	public static final int maxHours=100;

	public static int calculateEmpWage() {
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
		return  totalEmpWage;
	}
	public static void main(String[] args){

		int totalEmpWage=calculateEmpWage();
		System.out.println("Total Employee Wage : "+totalEmpWage);
	}
}
