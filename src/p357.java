import java.util.HashSet;

/**
 * Created by Robert on 5/30/2017.
 */
public class p357 {

    HashSet<Integer> primes;

    public p357() {
        long result = 0;
        primes = new HashSet<>(Operations.sieveOfEratosthenes(100000000));
        for (Integer p : primes){
            int n = p - 1;
            boolean valid = true;
            for (int i = 1; i <= Math.sqrt(n); i++){
                if (n % i == 0 && !primes.contains(i + n / i)){
                    valid = false;
                    break;
                }
            }
            if (valid) result += n;
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        new p357();
        double end = (System.nanoTime() - start) / (double) 1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
