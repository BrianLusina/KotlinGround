package java.generics.orderedpair;

/**
 * java.generics.orderedpair
 * Created by lusinabrian on 25/12/16.
 * Description:
 */
public class OrderedPair<K, V> implements Pair<K, V>{
    private K key;
    private V value;

    public OrderedPair(K key, V value){
        this.key = key;
        this.value = value;
    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }
}
