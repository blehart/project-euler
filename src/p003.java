import java.math.BigInteger;

/**
 * Created by Robert on 5/8/2017.
 */
public class p003 {

    public p003(){
        long x = 600851475143L;
        long result = 0;
        for (long i = 3; i*i < x; i += 2){
            if (x%i == 0){
                if (BigInteger.valueOf(i).isProbablePrime(10)){
                    result = i;
                }
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args){
        long start = System.nanoTime();
        new p003();
        double end = (System.nanoTime() - start)/(double)1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
