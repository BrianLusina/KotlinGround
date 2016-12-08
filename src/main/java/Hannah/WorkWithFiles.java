package main.java.Hannah;

import java.io.File;
import java.util.Formatter;

/**
 * Created by lusinabrian on 21/01/16.
 * The java.io package includes a File class that allows you to work with files.
 To start, create a File object and specify the path of the file in the constructor.
 import java.io.File;
 ...
 File file = new File("C:\\data\\input-file.txt");
 With the exists() method, you can determine whether a file exists.
 */
public class WorkWithFiles {
    public static void main(String[] args){

        File myFile = new File("~/home/lusinabrian/Software/Projects/IdeaProjects/hannah.txt");
        //check if file exists
        if(myFile.exists()) {
            System.out.print(myFile.getName() + " exists");
        }else{
            System.out.println(myFile.getName() + " does not exist");
        }
    /**
    The getName() method returns the name of the file.
    Note that we used double backslashes in the path, as one backslash should be escaped in the path String.

     The Scanner class inherits from the Iterator, so it behaves like one.
     We can use the Scanner object's next() method to read the file's contents.
     try {
     File x = new File("C:\\sololearn\\test.txt");
     Scanner sc = new Scanner(x);
     while(sc.hasNext()) {
     System.out.println(sc.next());
     }
     sc.close();
     } catch (FileNotFoundException e) {
     System.out.println("Error");
     }

     The file's contents are output word by word, because the next() method returns each word separately.
     It is always good practice to close a file when finished working with it. One way to do this is to use the Scanner's close() method.
     */

/**Formatter, another useful class in the java.util package, is used to create content and write it to files.*/
        try {
            Formatter f = new Formatter("~/home/lusinabrian/Software/Projects/IdeaProjects/test.txt");
            f.format("%s %s %s", "1","John", "Smith \n");
            f.format("%s %s %s", "2","Amy", "Brown");
            f.close();
        } catch (Exception e) {
            System.out.println("Error");
        }
/*This creates an empty file at the specified path. If the file already exists, this will overwrite it.
* Once the file is created, you can write content to it using the same Formatter object's format() method.*/


    //Main end
    }
//Class end
}
