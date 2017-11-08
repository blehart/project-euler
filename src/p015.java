import java.math.BigInteger;

/**
 * Created by Robert on 5/9/2017.
 */
public class p015 {

    public p015(){
        //n-choose-k
        //n!/(k!(n-k!))
        BigInteger result = Operations.factorial(BigInteger.valueOf(40))
                .divide(Operations.factorial(BigInteger.valueOf(20)).multiply(Operations.factorial(BigInteger.valueOf(20))));
        System.out.println(result.toString());
    }

    public static void main(String[] args){
        long start = System.nanoTime();
        new p015();
        double end = (System.nanoTime() - start)/(double)1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
