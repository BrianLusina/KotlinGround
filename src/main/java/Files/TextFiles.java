import java.io.IOException;
import java.util.Scanner;
//=========================================================================================================

public class TextFiles
{
	//createa new Scanner variable
	static Scanner userTxt = new Scanner(System.in);
	static String strTxt;

	//main method
	public static void main(String[] args) throws IOException
	{
		String fileName = "D:/test.txt";
		try
		{
		ReadTextFiles oFile = new ReadTextFiles(fileName);
		String[] arrayLines = oFile.openFile();

		int i;
		for ( i=0; i < arrayLines.length; i++ )
		{
			System.out.println( arrayLines[ i ] ) ;
		}
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
		}

		try
		{
			//create a new object from the WritingTextFiles class
		WritingTextFiles writeData = new WritingTextFiles(fileName,true);

		//get user Input
		System.out.println("Enter some Text");
		strTxt = userTxt.nextLine();

		//call the method from the WritingTextFiles class
		writeData.writeToFile(strTxt);

		System.out.println("Text file written to");
		}
		catch(IOException e)
		{
			//print a message incase the file is not accessible
			System.out.println(e.getMessage());
		}
	}

//=========================================================================================================
//THE END
}