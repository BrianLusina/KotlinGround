package Binary;


/**
 * Package: Binary
 * Created by lusinabrian on 02/08/16 or 02 Aug of 2016,
 * Time: 06:06.
 * Project: JxProjects
 * Description:
 */
public class CountBinary {
    public static void main(String[] args) {
        System.out.printf("Expected: %d, Actual: %d\n", 5, countBits(1234));
        System.out.printf("Expected: %d, Actual: %d\n", 1, countBits(4));
        System.out.printf("Expected: %d, Actual: %d\n", 3, countBits(7));
        System.out.printf("Expected: %d, Actual: %d\n", 2, countBits(9));
        System.out.printf("Expected: %d, Actual: %d\n", 2, countBits(10));
    }

    public static int countBits(int n) {
        int counter = 0;
        String bin = Integer.toBinaryString(n);
        for (int x = 0; x < bin.length(); x++) {
            if (bin.charAt(x) == '1')
                counter++;
        }
        return counter;
    }/*END*/
/*CLASS END*/
}
