import javax.swing.JOptionPane;
import java.util.Scanner;

public class HeartRatesTest
{
	public static void main(String[] args)
	{
		JOptionPane joptPane = new JOptionPane();
		Scanner scanner = new Scanner(System.in);

		System.out.println("Please enter your first name:");
		String firstname = scanner.next();

		System.out.println("Please enter your second name:");
		String secondname = scanner.next();

		System.out.println("In which year were you born?");
		int year = scanner.nextInt();

		//create the object from the HeartRates class
		HeartRates user = new HeartRates(firstname,secondname,year);

		//display current age
		System.out.println("Your current age of " + user.currentAge() + " is very essential when it comes to determining your maximum heart rate and target heart rate");

		//maximum and target heart rates
		user.maxHeartRate();
		user.targetHeartRate();


	}
}