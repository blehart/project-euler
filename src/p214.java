import java.util.ArrayList;
import java.util.List;

/**
 * Created by Robert on 6/1/2017.
 */
public class p214 {

    public p214() {
        long result = 0;
        int limit = 40000000;
        int[] phi = new int[limit+1];
        List<Integer> primes = new ArrayList<>();
        for (int i = 1; i <= limit; i++){
            phi[i] = i;
        }
        for (int i = 2; i <= limit; i++){
            if (phi[i] == i) {
                primes.add(i);
                phi[i] = i-1;
                for (int j = i*2; j <= limit; j += i) {
                    phi[j] = (phi[j]/i) * (i-1);
                }
            }
        }
        for (int p : primes){
            int val = p, count = 0;
            while (val != 1){
                count++;
                val = phi[val];
            }
            if (count == 24) result += p;
        }
        System.out.println(result);

    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        new p214();
        double end = (System.nanoTime() - start) / (double) 1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
