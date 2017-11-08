import java.math.BigInteger;
import java.util.List;

/**
 * Created by Robert on 5/24/2017.
 */
public class p132 {

    /**
     * 10^m - 1 / 9
     * p is prime factor if 10^m-1/9 === 0 (mod p)
     * 10^m === 1 (mod 9p)
     */
    public p132() {

        int result = 0, count = 0;
        BigInteger m = BigInteger.TEN.pow(9);
        List<Integer> primes = Operations.sieveOfEratosthenes(200000);

        for (int i= 0; count < 40; i++){
            if (BigInteger.TEN.modPow(m, BigInteger.valueOf(9 * primes.get(i))).compareTo(BigInteger.ONE) == 0){
                count++;
                result += primes.get(i);
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        new p132();
        double end = (System.nanoTime() - start) / (double) 1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
