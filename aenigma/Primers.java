import java.util.ArrayList;
import java.util.stream.IntStream;

/**
 * Created by lusinabrian on 23/06/16.
 * Class for prime check
 */
public class Primers {


    public long numberOfDivisors(int n) {
        ArrayList<Long> arrayList = new ArrayList<>();
        for(Integer i: IntStream.rangeClosed(1,n).toArray()){
            if(n%i == 0)
                arrayList.add((long) i);
        }

        return arrayList.size();
    }

//Class end
}
