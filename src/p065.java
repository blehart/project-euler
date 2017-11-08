import java.math.BigInteger;

/**
 * Created by Robert on 5/13/2017.
 */
public class p065 {

    public p065(){
        BigInteger x = BigInteger.ONE;
        BigInteger y = BigInteger.valueOf(2);

        for (int i = 2; i <= 100; i++){
            BigInteger temp = x;
            int z = (i % 3 == 0) ? 2 * (i / 3) : 1;   //1, 1, 2, 1, 1, 4, 1, 1, 6
            x = y;
            y = x.multiply(BigInteger.valueOf(z)).add(temp);  // a[n+1] = a[n] * z + a[n-1]
        }
        System.out.println(Operations.sumDigits(y));
    }

    public static void main(String[] args){
        long start = System.nanoTime();
        new p065();
        double end = (System.nanoTime() - start)/(double)1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
