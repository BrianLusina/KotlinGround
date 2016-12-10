package main.java.Strings;

/**
 * Created by lusinabrian on 16/07/16
 */

public class Accum {
    public static void main(String[] args) {
        System.out.println(accum("ZpglnRxqenU"));
    }

    public static String accum(String s) {
        String[] p = s.split("");
        int c = 0;
        String result = "";
        String y;
        for (String x : p) {
            y = new String(new char[c + 1]).replace("\0", x);
            c++;
            result += y + "-";
        }
        String m = "";
        for (String n : result.split("-")) {
            m += n.substring(0, 1).toUpperCase() + n.substring(1).toLowerCase() + "-";
        }
        return m.replaceAll("-$", "");
    }

/*CLASS END*/
}