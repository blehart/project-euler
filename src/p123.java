import java.util.List;

/**
 * Created by Robert on 5/24/2017.
 */
public class p123 {

    public p123() {
        long limit = 10000000000L;
        int minPrime = (int)Math.sqrt(limit);
        List<Integer> primes = Operations.sieveOfEratosthenes(500000);
        int i = 0;
        while (primes.get(i) < minPrime) i++;
        i++;
        long r = 0;
        while (r < limit) {
            long value = primes.get(i);
            i+=2;
            r = 2 * value * i;
        }
        System.out.println(i);
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        new p123();
        double end = (System.nanoTime() - start) / (double) 1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
