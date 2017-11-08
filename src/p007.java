import java.util.List;

/**
 * Created by Robert on 5/8/2017.
 */
public class p007 {

    public p007(){
        int padding = 10500;
        int estimate = (int)(padding * (Math.log(padding) + Math.log(Math.log(padding)) - 1));
        List<Integer> primes = Operations.sieveOfEratosthenes(estimate);
        System.out.println(primes.get(10001 - 1));
    }

    public static void main(String[] args){
        long start = System.nanoTime();
        new p007();
        double end = (System.nanoTime() - start)/(double)1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
