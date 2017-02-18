package java.algorithms.sieve;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Sieve {

    private int limit;
    private List<Integer> primes;

    public Sieve(int limit) {
        this.limit = limit;
        this.primes = calcPrimes();
    }

    public List<Integer> getPrimes() {
        return primes;
    }

    private List<Integer> calcPrimes() {
        primes = new ArrayList<>();
        LinkedList<Integer> linked = IntStream.range(2, getLimit() + 1)
                .boxed()
                .collect(Collectors.toCollection(LinkedList::new));

        while (linked.size() > 0) {
            Integer p = linked.remove();
            primes.add(p);
            linked = linked.stream()
                    .filter(x -> x % p != 0)
                    .collect(Collectors.toCollection(LinkedList::new));
        }
        return primes;
    }

    public int getLimit() {
        return limit;
    }
}
