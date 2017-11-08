import java.math.BigInteger;

/**
 * Created by Robert on 5/11/2017.
 */
public class p053 {

    public p053(){
        int result = 0;
        for (int n = 1; n <= 100; n++){
            for (int r = 1; r <= n; r++){
                if (Operations.nchoosek(n, r).compareTo(BigInteger.valueOf(1000000)) > 0){
                    result++;
                }
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args){
        long start = System.nanoTime();
        new p053();
        double end = (System.nanoTime() - start)/(double)1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
