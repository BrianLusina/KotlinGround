import java.util.Scanner;
import javax.swing.JOptionPane;
public class EmployeeTest
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		JOptionPane joptPane = new JOptionPane();

		//create 2 new Employee objects
		Employee john = new Employee("John","Doe",20000.50);
		Employee nick = new Employee("Nicholas","Straton",57920.59);
		System.out.println(john.getSalary());
		john.displayYearlySal();

	}
}