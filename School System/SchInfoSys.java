//identify the class
public class SchInfoSys{


	/*
	declare the properties of the class

	their admission number,
	their name,
	their current class and their pending school fees balance
	*/

	//data members and their access scope is private
	private int admissionNo;
	private String name;
	private String currentClass;
	private double feeBalance;
	private String[] regUnits; //array for units
	private int unitsCount; //counts the number of units that Student has registered

	//constructor
	public SchInfoSys(int a,String n,String c){
		admissionNo = a;
		name = n;
		currentClass = c;
		}

		//default constructor
		public SchInfoSys(){
			this(0,"Name","Current Class",0.0);
			}

	//defining the getters and setters

	//getter and setter for admission number data member in class
	public void setAdmissionNo(int admissionNo)
	{
		this.admissionNo = admissionNo;
	}

			public int getAdmissionNo()
			{
				return admissionNo;
			}

	//define getter and setter for name data member in class
	public void setName(String name)
		{
			this.name = name;
		}

				public String getName()
				{
					return name;
				}

	//getter and setter for current class data member in class
	public void setCurrentClass(String currentClass)
		{
			this.currentClass = currentClass;
		}

				public String getCurrentClass()
				{
					return currentClass;
				}

	//getter and setter for data member fee balance in class
	public void setFeeBalance(double feeBalance)
		{
			this.feeBalance = feeBalance;
		}

				public double getFeeBalance()
				{
					return feeBalance;
				}

	/*
	//identify the behaviour of the class

	a student can register for units,
	opt out of units,
	pay school fees and
	check their pending sch fees balance
	*/

	public void unitRegister(String s){
		return s;
		}


		public void payFees(double a)
		{

		}

		public boolean removeUnits()
		{

		}

	public String optOut(String unit){
		return unit;
		}

	public double deposit(double schFees){
		return schFees;
		}

	public void displayFeeBalance(){

		}




	public static void main(String[] args){

		}
	}