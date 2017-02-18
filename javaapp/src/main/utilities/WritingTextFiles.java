package main.utilities;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

//================================================================================================
public class WritingTextFiles {
    /*he boolean field is called append_to_file and has been set to a value of false.
    This is the default value for the FileWriter class, and means you don't want to append,
    but erase everything in the file.
    */
    public String path;
    public boolean appendToFile = false;

    //first constructor that will overwrite previous content of the file
    public WritingTextFiles(String filePath) {
        path = filePath;
    }

    //second constructor that will allow user to append to the file
    public WritingTextFiles(String filePath, boolean appendValue) {
        path = filePath;
        appendToFile = appendValue;
    }

    //================================================================================================
    public static void main(String[] args) {

    }

    //method to write to the text files
    public void writeToFile(String textLine) throws IOException {
        /*The first thing we need in the method is a FileWriter object.
		The FileWriter takes care of opening the correct file, and of storing the text as bytes.
		*/
        FileWriter write = new FileWriter(path, appendToFile);

		/*
		So we're creating a new FileWriter object with the name write.
		In between the round brackets of FileWriter we pass the name and location of the file,
		plus the append value. This will either be true (append to the file) or false (don't append).
		If a file of the name you pass over does not exist, the FileWriter creates one for you.
		The FileWriter write bytes, however. But we can hand the FileWriter plain text with the aid of the PrintWriter class.
		The PrintWriter has a few handy print methods for this. But it needs the name of a FileWriter when creating the object from the class.
		*/

        PrintWriter printLine = new PrintWriter(write);

		/*
		The one we'll use is one of the printf methods.
		This allows you to pass a formatted string of text to your PrintWriter.
		A good reason for using printf is to handle new line characters.
		The new line character differs, depending on which operating system you use.
		Windows will add the characters \r\n for a new line.
		But Unix systems just use \n. Using the printf function will ensure the correct encoding,
		no matter what the platform.
		*/

        printLine.printf("%s" + "%n", textLine);
		/*
		The %s between double quotes means a string of characters of any length. The %n means a newline. So we're telling the printf method to format a string of characters and add a newline at the end.
		*/

        //closes the text file and frees up any resources it was using
        printLine.close();


    }
//================================================================================================


//================================================================================================
//the end
}