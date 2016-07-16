/*Arrays
arrays are allocation of memory that store groups of data and usually store data of similar type
two ways of creating arrays:
1. dataType arrayName[] = new  dataType[number of items in array];
	arrayName[0] = data;
	arrayName[1] = data;
	arrayName[2] = data;
			.
			.
			.
	arrayName[n-1] = data;

2. dataType arrayName[] = {data1, data2, data3,...};
*/

//import Array package to use in listing arrays
import java.util.ArrayList;
import java.util.Iterator;


public class Arrays
{
	public static void main(String[] args)
	{
		int arrayNum[] = new int[5];
			arrayNum[0] = 1;
			arrayNum[1] = 2;
			arrayNum[2] = 3;
			arrayNum[3] = 4;
			arrayNum[4] = 5;

			//print out 3 from array
			System.out.println(arrayNum[2]);

//using array initializer
String arrayStr[] = {"MyCol","LuCube","4Territories","Kube","VoLBe"};

//print out LuCube
System.out.println(arrayStr[1]);


//arrays can be used with loops..an example is for loop

//create an empty array
int lotteryNum[] = new int[15];

//create a variable i
int i;

for(i = 0;i<lotteryNum.length;i++)
{
	//assign each number to a position in the empty array
	lotteryNum[i]=i+1;

	//print out each number
	System.out.println(lotteryNum[i]);
}

/*Multi-dimensional Arrays
these arrays hold more data and they hold them in form of rows and columns
syntax:
	dataType arrayName[][]= new dataType[r][c]; where r and c are number of rows and columns respectively

	//to enter data into the 1st row
		arrayName[0][1]= data;
		arrayName[0][2]= data;
		arrayName[0][3]= data;
				.
				.
				.
		arrayName[0][c]=data;

	//to enter data into 2nd row
		arrayName[1][1]= data;
		arrayName[1][2]= data;
		arrayName[1][3]= data;
				.
				.
				.
		arrayName[1][c]= data;

so on and so forth

*/

//create an array called arrayInt with 2 rows and 2 columns
int arrayInt[][] = new int[2][2];

//fill array with data
	//first row
	arrayInt[0][0] = 1;
	arrayInt[0][1] = 2;

	//second row
	arrayInt[1][0] = 3;
	arrayInt[1][1] = 4;

//loop through array to show all the numbers

//declare variables
int r,c;
int rows = 2;
int columns = 2;

for(r=0;r<rows;r++)
{
	for(c=0;c<columns;c++)
	{
		System.out.printf(arrayInt[r][c] + " ");
	}

	System.out.println( "" );
}

//create object list from ArrayList class
ArrayList list = new ArrayList();

//add elements to the object
list.add("Brian");
list.add("Lusina");
list.add("LuKube");
list.add(5);
list.add(7);

//get any item from the list, say the one at index 3 or the 4th item which is 5..hehe..
System.out.println(list.get(3));

//create a new Iterator object called sort and attach it to the ArrayList object
Iterator sort= list.iterator();

//sort through the list
while(sort.hasNext())
{
	System.out.println(sort.next());
}

//end of code
	}
}