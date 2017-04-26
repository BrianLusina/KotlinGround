package com.javapp.stringswords;

public class PhoneNumber {
    public static void main(String[] args) {
        System.out.printf("Expected: %s, Actual: %s", "(123) 456-7890", createPhoneNumber(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0}));
    }

    /**
     * @param numbers array of integers to convert to a number
     */
    public static String createPhoneNumber(int[] numbers) {
        String phone = "";
        for (int x : numbers) {
            phone += String.valueOf(x);
        }
        String area = "(" + phone.substring(0, 3) + ")";
        String nxt = " " + phone.substring(3, 6) + "-";
        String lst = phone.substring(6);
        phone = area + nxt + lst;
        return phone;
    }/*end*/
/*CLASS END*/
}
