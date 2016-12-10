package main.java.PostAndPre;

/**
 * Created by lusinabrian on 06/07/16.
 * Class demonstrating the difference between the post increment i++ and pre increment ++i
 */
public class PostAndPre {
    public static void main(String[] args) {
        int x = 0;
        for (int i = 0; i < 10; i++) {
            System.out.printf("%d\t", ++x);
            /*Output:
            1 2 3 4 5 6 7 8 9 10 */
            /*
            SAME AS
            x = x + 1;
            int y = x;
            System.out.printf("%d", y);
            */
        }
        System.out.println("\n------------------------");

        int l = 0;
        for (int i = 0; i < 10; i++) {
            System.out.printf("%d \t", l++);
        }
    }
}
