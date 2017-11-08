import java.util.ArrayList;
import java.util.List;

/**
 * Created by Robert on 5/17/2017.
 */
public class p095 {

    public p095() {
        int limit = 1000000;
        int[] sumDivisors = new int[limit];

        /**
         * Use a sieve method to get sum of diviors for all numbers 1 - limit
         */
        for (int i = 1; i < limit; i++){
            for (int j = i * 2; j < limit; j += i){
                sumDivisors[j] += i;
            }
        }
        int maxLength = 0;
        int smallestNumberOfMax = 0;
        boolean[] numbers = new boolean[limit];

        /**
         * Keep going until circuit is detected, figure out length/min number of that circuit.
         * No need to start chains from numbers already encountered.
         */
        for (int i = 2; i < limit; i++){
            if (numbers[i]) continue;
            List<Integer> chain = new ArrayList<>();
            int j = i;
            boolean invalid = false;
            while (!chain.contains(j)){
                chain.add(j);
                j = sumDivisors[j];

                if (j > limit || numbers[j]){
                    invalid = true;
                    break;
                }
            }
            if (!invalid){
                int smallest = Integer.MAX_VALUE;
                int first = chain.indexOf(j);

                if (chain.size() - first > maxLength){
                    for (int k = first; k < chain.size(); k++){
                        if (chain.get(k) < smallest) smallest = chain.get(k);
                    }
                    maxLength = chain.size() - first;
                    smallestNumberOfMax = smallest;
                }
            }
            for (int k = 0; k < chain.size(); k++){
                numbers[chain.get(k)] = true;
            }
        }
        System.out.println(smallestNumberOfMax);
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        new p095();
        double end = (System.nanoTime() - start) / (double) 1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
