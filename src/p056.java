import java.math.BigInteger;

/**
 * Created by Robert on 5/12/2017.
 */
public class p056 {

    public long digitSum(int x, int y){
        BigInteger xi = BigInteger.valueOf(x);
        BigInteger pow = xi.pow(y);
        long sum = 0;
        while (!pow.equals(BigInteger.ZERO)){
            sum += pow.mod(BigInteger.TEN).longValue();
            pow = pow.divide(BigInteger.TEN);
        }
        return sum;
    }

    public p056(){
        long result = 0;
        for (int i = 1; i < 100; i++){
            for (int j = 1; j < 100; j++){
                result = Math.max(result, digitSum(i, j));
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args){
        long start = System.nanoTime();
        new p056();
        double end = (System.nanoTime() - start)/(double)1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
