import java.math.BigInteger;

/**
 * Created by Robert on 5/13/2017.
 */
public class p070 {

    /**
     * In contrast to the previous problem, we're looking for the lowest ratio val/phi
     * So we want a bunch of relatively prime, can't be primes though because the phi would never be a permutation
     * Instead, we take large numbers that are the product of two primes and try to find ones that are permutations with their phi
     */
    public p070(){
        long result = 0;
        double min = Double.MAX_VALUE;
        for (int i = BigInteger.valueOf(2000).nextProbablePrime().intValue(); i < 5000; i = BigInteger.valueOf(i).nextProbablePrime().intValue()){
            for (int j = BigInteger.valueOf(i).nextProbablePrime().intValue(); j < 5000; j = BigInteger.valueOf(j).nextProbablePrime().intValue()){
                long val = i * j;
                if (val > 10000000) break;
                long phi = (i - 1)*(j - 1);
                double ratio = (double)val/phi;

                if (Operations.isPermutation(Long.toString(val), Long.toString(phi)) && min > ratio){
                    min = ratio;
                    result = val;
                }
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args){
        long start = System.nanoTime();
        new p070();
        double end = (System.nanoTime() - start)/(double)1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
