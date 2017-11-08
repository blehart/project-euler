import java.math.BigInteger;

/**
 * Created by Robert on 5/7/2017.
 */
public class p020 {

    public p020(){
        BigInteger f = Operations.factorial(BigInteger.valueOf(100));
        BigInteger result = BigInteger.valueOf(0);

        while (!f.equals(BigInteger.ZERO)) {
            result = result.add(f.mod(BigInteger.TEN));
            f = f.divide(BigInteger.TEN);
        }
        System.out.println(result);
    }

    public static void main(String[] args){
        long start = System.nanoTime();
        new p020();
        double end = (System.nanoTime() - start)/(double)1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
