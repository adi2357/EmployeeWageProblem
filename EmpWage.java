public class EmpWage{

	public static final int isFullTime=1;
	public static final int isPartTime=2;
	public static final int wagePerHour=20;

	public static void main(String[] args){

		int empHours=0;
		int empWage=0;

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
		empWage=empHours*wagePerHour;
		System.out.println("Employee Wage : "+empWage);
	}
}
