import java.util.List;

/**
 * Created by Robert on 5/14/2017.
 */
public class p077 {

    List<Integer> primes;

    public p077(){
        primes = Operations.sieveOfEratosthenes(1000);
        int target = 2;
        while (true) {
            int[] ways = new int[target + 1];
            ways[0] = 1;

            for (int i = 0; i < target; i++) {
                for (int j = primes.get(i); j <= target; j++) {
                    ways[j] += ways[j - primes.get(i)];
                }
            }
            if (ways[target] > 5000){
                System.out.println(target);
                break;
            }
            target++;
        }
    }
    public static void main(String[] args){
        long start = System.nanoTime();
        new p077();
        double end = (System.nanoTime() - start)/(double)1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
