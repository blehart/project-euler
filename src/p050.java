import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Robert on 5/11/2017.
 */
public class p050 {

    public p050() {
        long result = 0;
        int numPrimes = 0;
        List<Integer> primes = Operations.sieveOfEratosthenes(1000000);
        List<Integer> primeSum = new ArrayList<>();
        primeSum.add(0);
        for (int i = 0; i < primes.size(); i++) {
            primeSum.add(i+1, primeSum.get(i) + primes.get(i));
        }
        for (int i = 0; i < primeSum.size(); i++){
            for (int j = i - (numPrimes + 1); j >= 0; j--){
                if (primeSum.get(i) - primeSum.get(j) > 1000000) break;
                if (Collections.binarySearch(primes, primeSum.get(i) - primeSum.get(j)) >= 0){
                    numPrimes = i - j;
                    result = primeSum.get(i) - primeSum.get(j);
                }
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args){
        long start = System.nanoTime();
        new p050();
        double end = (System.nanoTime() - start)/(double)1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
