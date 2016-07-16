import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * Created by lusinabrian on 20/01/16.
 * Class demonstrating the use of ArrayLists
 * ArrayLists store objects and thus use Classes such as Integer,String,Double etc.
 * They are resizable and thus can expand or shrink, however, an initial capacity can also be specified
 * add() method adds items to the ArrayList, while remove() method removes items
 *
 Other useful methods include the following:
 - contains(): Returns true if the list contains the specified element
 - get(int index): Returns the element at the specified position in the list
 - size(): Returns the number of elements in the list
 - clear(): Removes all of the elements from the list

 Note: As with arrays, the indexing starts with 0.
 */
public class ArrayLists {

    public static void main(String[] args){
    /*Resizable array colors with an initial capacity of 10*/
        ArrayList<String> colors = new ArrayList<String>(10);
        colors.add("Red");
        colors.add("Blue");
        colors.add("Purple");
        colors.add("Yellow");

        //does the ArrayList contain Orange?
        if(colors.contains("Orange")){
            System.out.println("ArrayList colors contains Orange \n");
        }else{
            System.out.println("ArrayList colors does not contains Orange \n");
        }

        //return a specified color
        System.out.println("Color at index 2 " + colors.get(2) + "\n");

        //how many colors are here and what are they?
        System.out.println("There are " + colors.size() + " colors in the ArrayList colors and they are " + colors);
/**
 * For the manipulation of data in different collection types, the Java API provides a Collections class,
 * which is included in the java.util package.
 One of the most popular Collections class methods is sort(), which sorts the elements of your collection type.
 The methods in the Collections class are static, so you don't need a Collections object to call them

 max(Collection c): Returns the maximum element in c as determined by natural ordering.
 min(Collection c): Returns the minimum element in c as determined by natural ordering.
 reverse(List list): Reverses the sequence in list.
 shuffle(List list): Shuffles (i.e., randomizes) the elements in list.
 **/
        ArrayList<String> animals = new ArrayList<String>();
        animals.add("tiger");
        animals.add("cat");
        animals.add("snake");
        animals.add("dog");

        Collections.sort(animals);

        System.out.println(animals);
/**************************/
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 6; i++) {
            list.add(i);
        }
        int x = 0;
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            x+= it.next();
        }
        System.out.println(x);
/*----------------------*/
        int f=1, i=2;
        while(++i<5)
            f*=i;
        System.out.println(f);
    }

//Class end
}
