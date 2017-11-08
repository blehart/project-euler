import java.math.BigInteger;

/**
 * Created by Robert on 5/11/2017.
 */
public class p048 {

    public p048(){
        BigInteger result = BigInteger.ZERO;

        for (int i = 1; i <= 1000; i++){
            result = result.add(BigInteger.valueOf(i).pow(i));
        }
        String res = result.toString();
        System.out.println(res.substring(res.length()-10));
    }

    public static void main(String[] args){
        long start = System.nanoTime();
        new p048();
        double end = (System.nanoTime() - start)/(double)1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
