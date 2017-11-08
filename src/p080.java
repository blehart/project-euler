import java.math.BigInteger;

/**
 * Created by Robert on 5/14/2017.
 */
public class p080 {

    public BigInteger squareRoot(int n, int digits) {
        BigInteger limit = BigInteger.TEN.pow(digits + 1);
        BigInteger a = BigInteger.valueOf(5 * n);
        BigInteger b = BigInteger.valueOf(5);

        while (b.compareTo(limit) < 0) {
            if (a.compareTo(b) >= 0) {
                a = a.subtract(b);
                b = b.add(BigInteger.TEN);
            } else {
                a = a.multiply(BigInteger.valueOf(100));
                b = (b.divide(BigInteger.TEN)).multiply(BigInteger.valueOf(100)).add(BigInteger.valueOf(5));
            }
        }
        return b.divide(BigInteger.valueOf(100));
    }

    public p080(){
        long result = 0;
        int s = 1;
        for (int i = 1; i <= 100; i++){
            if (s * s == i){
                s++;
                continue;
            }
            BigInteger j = squareRoot(i, 100);
            result += Operations.sumDigits(j);
        }
        System.out.println(result);
    }

    public static void main(String[] args){
        long start = System.nanoTime();
        new p080();
        double end = (System.nanoTime() - start)/(double)1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
