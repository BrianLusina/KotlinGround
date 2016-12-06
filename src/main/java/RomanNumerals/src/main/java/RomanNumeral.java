package RomanNumerals.src.main.java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 Package: ${PACKAGE_NAME}
 Created by lusinabrian on 23/07/16 or 23 Jul of 2016,
 Time: 15:56.
 Project: RomanNumerals
 Desc: convert normal numbers to roman numerals
 */
public class RomanNumeral {
    /*FIELD*/
    private int number;

    /*CONSTRUCTOR*/
    public RomanNumeral(int number){
        this.number = number;
    }

    public Map<Integer, String> romanMap(){
        /*create Map for the roman numeral equivalents of numbers*/
        Map<Integer, String> mapper = new HashMap<Integer, String>();

        /*digits, ones*/
        mapper.put(1, "I"); mapper.put(2, "II"); mapper.put(3, "III");
        mapper.put(4, "IV"); mapper.put(5, "V"); mapper.put(6, "VI");
        mapper.put(7, "VII"); mapper.put(8, "VIII"); mapper.put(9, "IX");

        /*tens,*/
        mapper.put(10,"X"); mapper.put(20, "XX"); mapper.put(30,"XXX");
        mapper.put(40,"XL"); mapper.put(50,"L"); mapper.put(60,"LX");
        mapper.put(70,"LXX"); mapper.put(80, "LXXX"); mapper.put(90, "XC");

        /*hundreds*/
        mapper.put(100, "C"); mapper.put(200, "CC"); mapper.put(300, "CCC");
        mapper.put(400, "CD"); mapper.put(500, "D"); mapper.put(600,"DC");
        mapper.put(700, "DCC"); mapper.put(800, "DCCC"); mapper.put(900, "CM");

        /*thousands*/
        mapper.put(1000,"M"); mapper.put(2000,"MM"); mapper.put(3000,"MMM");

        return  mapper;
    }

    /**convert number to roman numeral
     * return "" if number is 0 or less than 0
     * else convert the number to string and obtain the tens, hundreds and thousands
     * if number array as a length of 1, that is number is below 10, convert to equivalent roman numeral;
     * if length of array is 2, they are tens
     * if length of array is 3, they are hundreds
     * if 4, thousands
     * */
    public String getRomanNumeral(){
        String[] numArr = String.valueOf(getNumber()).split("");
        String ans = "";
        if(getNumber() <= 0){
            return "";
        }else {
            //check if number array has a length of 1, or the number is 10,50,100,500,1000
            if (numArr.length <= 1 || getNumber() == 10 || getNumber() == 50 || getNumber() == 100 || getNumber() == 500 || getNumber() == 1000) {
                ans = romanMap().get(getNumber());
            } else {
                /*tens*/
                if (numArr.length == 2) {
                    int t = Integer.parseInt(numArr[0]) * 10;
                    int o = Integer.parseInt(numArr[1]);

                    String tensPart = romanMap().get(t);
                    String onesPart = romanMap().get(o);

                    ans = tensPart + onesPart;
                /*hundreds*/
                }else if(numArr.length == 3){
                    int h = Integer.parseInt(numArr[0]) * 100;
                    int t = Integer.parseInt(numArr[1]) * 10;
                    int o =Integer.parseInt(numArr[2]);

                    String hundreds = romanMap().get(h);
                    String tens = (t == 0) ? "" : romanMap().get(t);
                    String ones = romanMap().get(o);

                    ans = hundreds + tens + ones;
                /*thousands*/
                }else{

                    int th = Integer.parseInt(numArr[0]) * 1000;
                    int h = Integer.parseInt(numArr[1]) * 100;
                    int t = Integer.parseInt(numArr[2]) * 10;
                    int o = Integer.parseInt(numArr[3]);

                    String thousand = romanMap().get(th);
                    String hundreds = (h == 0) ? "" : romanMap().get(h);
                    String tens = (t == 0) ? "" : romanMap().get(t);
                    String ones = (o == 0)? "" : romanMap().get(o);

                    ans = thousand + hundreds + tens + ones;
                }
            }
        }
        return ans;
    }

    /*GETTERS AND SETTERS*/
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

/*CLASS END*/
}