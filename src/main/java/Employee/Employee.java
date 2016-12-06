import java.util.Scanner;

public class Employee
{
	private String firstName, secondName;
	private double employeeSalary;
	private Scanner scanner = new Scanner(System.in);

	//constructor
	public Employee(String fName,String sName,double salary)
	{
		firstName = fName;
		secondName = sName;
		employeeSalary = salary;
	}

	//setters and getters
	public void setFname(String fname)
	{
		firstName = fname;
	}

	public String getFname()
	{
		return firstName;
	}

	public void setSname(String sname)
	{
		secondName = sname;
	}

	public String getSname()
	{
		return secondName;
	}

	public void setSalary(double salary)
	{
		employeeSalary = salary;
	}


	public double getSalary()
	{
		return employeeSalary;
	}

	public void displayYearlySal()
	{
		double salYr = getSalary()*12;
		System.out.println(getFname() + getSname() + " yearly salary is " + salYr);

	}

//end
}