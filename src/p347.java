import java.util.List;

/**
 * Created by Robert on 6/6/2017.
 */
public class p347 {

    public p347() {

        long result = 0;
        int N = 10000000;
        List<Integer> primes = Operations.sieveOfEratosthenes(N/2);
        for (int i = 0; i < primes.size()-1; i++){
            for (int j = i+1; j < primes.size() && primes.get(i) * primes.get(j) <= N; j++){
                long p = primes.get(i), q = primes.get(j), max = 0;
                for (long r = p; r * q <= N; r *= p){
                    for (long s = q; r * s <= N; s *= q){
                        max = Math.max(max, r * s);
                    }
                }
                result += max;
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        new p347();
        double end = (System.nanoTime() - start) / (double) 1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
