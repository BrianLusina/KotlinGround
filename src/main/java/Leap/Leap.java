package Leap;

/**
 * Package: Leap
 * Created by lusinabrian on 07/09/16 or 07 Sep of 2016,
 * Time: 08:49.
 * Project: JxProjects
 * Description:
 */
public class Leap {
    public boolean isLeap(int year){
        return year % 4 == 0 && year % 100 != 0 || (year % 400 == 0);
    }
}
