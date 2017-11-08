import java.math.BigInteger;

/**
 * Created by Robert on 5/13/2017.
 */
public class p069 {

    /**
     * Numbers are relatively prime if they don't share a prime factor
     * Numbers with lots of primes in their prime factorization will have have minimal phi
     * Find the highest number under 1 mil, who primes factorization is just the list of primes 2, 3, 7...
     */
    public p069(){
        int result = 1;
        int prime = 2;
        while (result * prime < 1000000){
            result *= prime;
            prime = BigInteger.valueOf(prime).nextProbablePrime().intValue();
        }
        System.out.println(result);
    }

    public static void main(String[] args){
        long start = System.nanoTime();
        new p069();
        double end = (System.nanoTime() - start)/(double)1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
