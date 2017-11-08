import java.util.HashSet;

/**
 * Created by Robert on 5/11/2017.
 */
public class p049 {

    HashSet<Integer> primes;

    public p049(){
        primes = new HashSet<>(Operations.sieveOfEratosthenes(10000));
        for (Integer i : primes){
            int j = i + 3330;
            int k = j + 3330;
            if (primes.contains(j) && primes.contains(k) && Operations.isPermutation(String.valueOf(i), String.valueOf(j))
                    && Operations.isPermutation(String.valueOf(i), String.valueOf(k))){
                System.out.println(i + "" + j + "" + k);
            }
        }
    }

    public static void main(String[] args){
        long start = System.nanoTime();
        new p049();
        double end = (System.nanoTime() - start)/(double)1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
