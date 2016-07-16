import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by lusinabrian on 11/05/16.
 * Determine the current date and time
 */
public class Kronos {
    public static void main(String[] args){
        //Timezone is GMT+3
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT+3:00"));
        Date currentLocalTime = cal.getTime();
        DateFormat dateFormat = new SimpleDateFormat("HH:mm a", Locale.ENGLISH);
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT+3:00"));

        //store the time in a string
        String localTime = dateFormat.format(currentLocalTime);
        //storing the current hour, minute in integers
        int hour = cal.get(Calendar.HOUR);
        int min = cal.get(Calendar.MINUTE);

        System.out.println(localTime);
        System.out.println(hour);
        System.out.println(min);
    }

}
