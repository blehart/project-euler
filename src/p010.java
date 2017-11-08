import java.util.List;

/**
 * Created by Robert on 5/8/2017.
 */
public class p010 {

    public p010(){
        List<Integer> primes = Operations.sieveOfEratosthenes(2000000 - 1);
        long result = 0;
        for (Integer i : primes){
            result += i;
        }
        System.out.println(result);
    }

    public static void main(String[] args){
        long start = System.nanoTime();
        new p010();
        double end = (System.nanoTime() - start)/(double)1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
