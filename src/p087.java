import java.util.HashSet;
import java.util.List;

/**
 * Created by Robert on 5/15/2017.
 */
public class p087 {

    List<Integer> primes;
    int limit = 50000000;
    int primesLimit = 7072;  // limit - 2^3 - 2^4

    public p087() {
        HashSet<Long> values = new HashSet<>();
        primes = Operations.sieveOfEratosthenes(primesLimit);
        for (int i = 0; i < primes.size(); i++){
            for (int j = 0; j < primes.size(); j++){
                for (int k = 0; k < primes.size(); k++){
                    long value = (long)(Math.pow(primes.get(i), 2) + Math.pow(primes.get(j), 3) + Math.pow(primes.get(k), 4));
                    if (value < limit) values.add(value);
                    else break;
                }
            }
        }
        System.out.println(values.size());
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        new p087();
        double end = (System.nanoTime() - start) / (double) 1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
