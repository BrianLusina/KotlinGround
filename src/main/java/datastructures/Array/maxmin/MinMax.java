package main.java.Array.maxmin;

import java.util.Arrays;

/**
 * Package: datastructures.Array.maxmin
 * Created by lusinabrian on 06/09/16 or 06 Sep of 2016,
 * Time: 05:47.
 * Project: JxProjects
 * Description:
 */
public class MinMax {
    public static int[] minMax(int[] arr) {
        return new int[]{Arrays.stream(arr).min().getAsInt(), Arrays.stream(arr).max().getAsInt()};
    }
}
