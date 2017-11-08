import java.math.BigInteger;

/**
 * Created by Robert on 5/13/2017.
 */
public class p066 {

    public p066(){
        int result = 0;
        BigInteger max = BigInteger.ZERO;
        for (int i = 2; i <= 1000; i++){
            double j = Math.sqrt(i);
            if (j == (long)j) continue;
            BigInteger val = Operations.solveXPell(i);
            if (max.compareTo(val) < 0){
                max = val;
                result = i;
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args){
        long start = System.nanoTime();
        new p066();
        double end = (System.nanoTime() - start)/(double)1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
