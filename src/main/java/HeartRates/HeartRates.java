package HeartRates;

import java.util.Scanner;

public class HeartRates
{
	private String firstName,surname;
	private int birthday;
	private Scanner scanner = new Scanner(System.in);

	//constructo
	public HeartRates(String fname,String sname,int dob)
	{
		firstName = fname;
		surname = sname;
		birthday = dob;
	}

	//setters and getters
	public void setFirstName(String fname)
	{
		firstName = fname;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setSurname(String sname)
	{
		surname = sname;
	}

	public String getSurname()
	{
		return surname;
	}

	public void setDob(int dateOb)
	{
		birthday = dateOb;
	}

	public int getDob()
	{
		return birthday;
	}

	public int currentAge()
	{
		int ca = 2014 - getDob();
		return ca;
	}

	public void maxHeartRate()
	{
		int mhr = 220-currentAge();
		System.out.println(getFirstName() + " " + getSurname()+"'s current maximum heart rate is " + mhr);
	}

	public void targetHeartRate()
	{
		int mhr = 220-currentAge();
		double lowerTrgt = 0.5*mhr;
		double higherTrgt = 0.85*mhr;

		System.out.println("Your target heart rate is between the range " + lowerTrgt + " and " + higherTrgt);
	}

//end
}