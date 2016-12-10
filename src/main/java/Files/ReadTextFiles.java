import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

//=========================================================================================================
public class ReadTextFiles {
    private String path;

    //constructor
    public ReadTextFiles(String filePath) {
        path = filePath;
    }

    //=========================================================================================================
    public static void main(String[] args) {

    }

    /*Notice, that we've added "throws IOException" to the end of the method header.
    Every method that deals with reading text files needs one of these.
    Java will throw any errors up the line, and they will be caught in our main method.

    To read characters from a text file, the FileReader is used.
    This reads bytes from a text file, and each byte is a single character.
    You can read whole lines of text, rather than single characters.
    To do this, you can hand your FileReader over to something called a BufferedReader.
    The BufferedReader has a handy method called ReadLine.
    As its name suggests, it is used to read whole lines, rather than single characters.
    What the BufferedReader does, though, is to store characters in memory (the buffer)
    so that they can be manipulated more easily.
    */
    public String[] openFile() throws IOException {
        //create objects of the FileReader and BufferedReader classes
        FileReader fr = new FileReader(path);
        BufferedReader br = new BufferedReader(fr);

        //set up an array where each position will hold a line of text
        int noOfLines = readlines();
        String[] textData = new String[noOfLines];

	/*To put all the lines of text from the file into each position in the array,
    we need a loop. The loop will get each line of text and place each line into the array.
	*/
        int i;

        for (i = 0; i < noOfLines; i++) {
            textData[i] = br.readLine();
        }

	/*The line that accesses the lines of text and stores them in the array is this one:

textData[i] = br.readLine( );

After the equals sign we have this:

br.readLine( );

The br object we set up is holding all the characters from the text file in memory (the buffer).
We can use the readLine method to read a complete line from the buffer.
After the line is read, we store the line in an array position:

textData[i]
	*/

        br.close();
        return textData;

    }

    //=========================================================================================================
/*There's still the problem of the number of lines, however.
We've hard-coded this to 3. What we need is to go through any text file and count how many lines it has.
The code for the method sets up another FileReader, and another BufferedReader. To loop round the lines of text, we have this:

while ( ( aLine = bf.readLine( ) ) != null ) {
numberOfLines++;
}

The while loop looks a bit messy. But it just says "read each line of text and stop when a null value is reached." (If there's no more lines in a text file, Java returns a value of null.) Inside the curly brackets, we increment a counter called numberOfLines.

The final two lines of code flush the memory buffer called bf, and returns the number of lines.
*/
    int readlines() throws IOException {
        FileReader fileToRead = new FileReader(path);
        BufferedReader buffer = new BufferedReader(fileToRead);

        String aLine;
        int numberOfLines = 0;

        while ((aLine = buffer.readLine()) != null) {
            numberOfLines++;
        }

        buffer.close();
        return numberOfLines;

    }
//=========================================================================================================


//=========================================================================================================
//the end
}