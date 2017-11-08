import java.math.BigInteger;

/**
 * Created by Robert on 5/23/2017.
 */
public class p113 {

    public p113() {
        BigInteger result = Operations.nchoosek(110, 10).add(Operations.nchoosek(109, 9)).subtract(BigInteger.valueOf(1002));
        System.out.println(result);
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        new p113();
        double end = (System.nanoTime() - start) / (double) 1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
