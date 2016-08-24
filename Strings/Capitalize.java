package Strings;

/**
 * Package: Strings
 * Created by lusinabrian on 24/08/16 or 24 Aug of 2016,
 * Time: 05:28.
 * Project: JxProjects
 * Description:
 */
public class Capitalize {

    public String capitalize(String str){
        for(String s :str.split(" ")){
            s = s.substring(0,1).toLowerCase() + s.substring(1);
        }
        return str;
    }
}
