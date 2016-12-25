package generics.orderedpair;

/**
 * generics.orderedpair
 * Created by lusinabrian on 25/12/16.
 * Description:
 */
public class OrderedPairMain {
    public static void main(String[] args){
        Pair<String, Integer> p1 = new OrderedPair<>("Brian", 5);
        Pair<String, String> p2 = new OrderedPair<>("Lusina", "Ombito");

    }
}
