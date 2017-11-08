import java.math.BigInteger;
import java.util.List;

/**
 * Created by Robert on 5/24/2017.
 */
public class p133 {

    public p133() {

        int result = 0;
        BigInteger m = BigInteger.TEN.pow(16);
        List<Integer> primes = Operations.sieveOfEratosthenes(100000);

        for (Integer prime : primes) {
            if (BigInteger.TEN.modPow(m, BigInteger.valueOf(9 * prime)).compareTo(BigInteger.ONE) != 0) {
                result += prime;
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        new p133();
        double end = (System.nanoTime() - start) / (double) 1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
