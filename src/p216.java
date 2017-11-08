/**
 * Created by Robert on 6/6/2017.
 */
public class p216 {

    public p216() {

        int result = 0, limit = 50000000;

        // Create an array of all numbers of form 2n^2 - 1 below the limit
        long[] sieve = new long[limit+1];
        for (int i = 0; i <= limit; i++){
            sieve[i] = 2L * i * i - 1;
        }
        for (int n = 2; n <= limit; n++) {
            // If number hasn't been modified, it's prime
            if (sieve[n] == 2L * n * n - 1) result++;

            if (1 < sieve[n] && sieve[n] <= limit*2) {
                long p = sieve[n];
                // We figure out which values of seive[j] are multiples of p using modulus, we get 2 sets of answers, so we use loops
                // We divide out the 2n^2 - 1 prime numbers to find the other primes, that divide nonprime 2n^2 - 1 numbers
                for (int j = (int)(n + p); j <= limit; j += p) {
                    while (true) {
                        sieve[j] /= p;
                        if (sieve[j] % p != 0) break;
                    }
                }
                for (int j = (int)(n + (p - n) * 2 % p); j <= limit; j += p) {
                    while (true) {
                        sieve[j] /= p;
                        if (sieve[j] % p != 0) break;
                    }
                }
            }

        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        new p216();
        double end = (System.nanoTime() - start) / (double) 1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
