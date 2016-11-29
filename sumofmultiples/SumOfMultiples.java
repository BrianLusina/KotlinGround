package sumofmultiples;

import java.util.ArrayList;
import java.util.stream.IntStream;

class SumOfMultiples {

    int Sum(int number, int[] multiples){
        ArrayList<Integer> result = new ArrayList<>();
        //create range for the numbers
        IntStream numbers = IntStream.rangeClosed(0, number);
        for(int n: numbers.toArray()){
            for(int mul : multiples){
                if(n % mul == 0){
                    result.add(n);
                }
            }
        }

        return result.stream().reduce(0, (sum, p) -> sum + p);
    }
}
