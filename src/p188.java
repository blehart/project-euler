import java.math.BigInteger;

/**
 * Created by Robert on 6/1/2017.
 */
public class p188 {

    public p188() {
        BigInteger value = BigInteger.valueOf(1777), result = value,mod = BigInteger.valueOf(100000000);
        for (int i = 0; i < 1855; i++){
            result = value.modPow(result, mod);
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        new p188();
        double end = (System.nanoTime() - start) / (double) 1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
