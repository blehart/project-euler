import java.util.HashSet;
import java.util.List;

/**
 * Created by Robert on 6/1/2017.
 */
public class p203 {

    public p203() {
        long result = 0;
        int limit = 51;
        long max = 0;
        HashSet<Long> distinct = new HashSet<>();
        long[] prev = {1};
        for (int i = 2; i <= limit; i++){
            long[] cur = new long[i];
            for (int j = 0; j < prev.length; j++){
                cur[j] += prev[j];
                cur[j+1] += prev[j];
                distinct.add(cur[j]);
                max = Math.max(max, cur[j]);
            }
            prev = cur;
        }
        for (long i : distinct){
            result += i;
        }
        List<Integer> primes = Operations.sieveOfEratosthenes((int)Math.sqrt(max));
        for (long i : distinct){
            long temp = i;
            for (int j = 0, count = 0; temp != 1;){
                int prime = primes.get(j);
                if (temp % prime == 0){
                    temp /= prime;
                    count++;
                    if (count == 2){
                        result -= i;
                        break;
                    }
                }
                else {
                    j++;
                    count = 0;
                }
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        new p203();
        double end = (System.nanoTime() - start) / (double) 1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
