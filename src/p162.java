import java.math.BigInteger;

/**
 * Created by Robert on 6/12/2017.
 */
public class p162 {

    public p162() {
        BigInteger result = BigInteger.ZERO;
        for (int n = 3; n <= 16; n++) {
            result = result.add(BigInteger.valueOf(15).multiply(BigInteger.valueOf(16).pow(n-1)).add(BigInteger.valueOf(41).multiply(BigInteger.valueOf(14).pow(n-1))).subtract(BigInteger.valueOf(43).multiply(BigInteger.valueOf(15).pow(n-1)).add(BigInteger.valueOf(13).pow(n))));
        }
        System.out.println(Long.toHexString(result.longValue()));
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        new p162();
        double end = (System.nanoTime() - start) / (double) 1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
