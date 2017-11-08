import java.util.List;

/**
 * Created by Robert on 6/1/2017.
 */
public class p231 {

    /*
    The prime factorization of x! has x/5 + x/25 + x/125 + x/625 = 249 fives
    n choose k has summation (n/p^j - k/p^j - n-k/p^j) number of p's in it's prime factorization

    For our result, we check each prime below n to find out how many of them are in n choose k.
     */
    public p231() {
        long result = 0;
        long n = 20000000;
        long k = 15000000;
        List<Integer> primes = Operations.sieveOfEratosthenes((int)n);


        for (int p : primes){
            long np = p;
            while (np <= n){
                result += p * ((n/np) - (k/np) - ((n-k)/np));
                np *= p;
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        new p231();
        double end = (System.nanoTime() - start) / (double) 1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
