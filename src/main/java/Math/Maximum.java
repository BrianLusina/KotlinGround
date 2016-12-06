import java.util.Scanner;

public class Maximum
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter 3 numbers seperated by spaces");
		double no1 = scanner.nextDouble();
		double no2 = scanner.nextDouble();
		double no3 = scanner.nextDouble();

		double result = maximum(no1,no2,no3);

		System.out.println("Maximum is: " + result + " using custom maximum method");

		System.out.println("Using Math class the maximum is the same: " + Math.max(no1,Math.max(no2,no3)));
}
		public static double maximum(double x,double y, double z)
		{
			//assume that the first number is maximum
			double maximumVal = x;
			if(y> maximumVal)
			maximumVal = y;

			if(z>maximumVal)
			maximumVal=z;

			return maximumVal;
		}
//end class
}