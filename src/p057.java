import java.math.BigInteger;

/**
 * Created by Robert on 5/12/2017.
 */
public class p057 {

    public static BigInteger[] rootTwo(int iterations){
        BigInteger[][] mem = new BigInteger[2][iterations + 1];
        mem[0][0] = BigInteger.ONE;
        mem[1][0] = BigInteger.ONE;
        mem[0][1] = BigInteger.valueOf(3);
        mem[1][1] = BigInteger.valueOf(2);
        for (int i = 2; i <= iterations; i++){
            mem[0][i] = mem[0][i-1].multiply(BigInteger.valueOf(2)).add(mem[0][i-2]);
            mem[1][i] = mem[1][i-1].multiply(BigInteger.valueOf(2)).add(mem[1][i-2]);
        }
        return new BigInteger[]{mem[0][iterations], mem[1][iterations]};
    }

    public p057(){
        int result = 0;
        for (int i = 1; i <= 1000; i++){
            BigInteger[] fraction = rootTwo(i);
            if (fraction[0].toString().length() > fraction[1].toString().length()){
                result++;
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args){
        long start = System.nanoTime();
        new p057();
        double end = (System.nanoTime() - start)/(double)1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
