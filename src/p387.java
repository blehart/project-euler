import java.util.ArrayList;
import java.util.List;

/**
 * Created by Robert on 5/31/2017.
 */
public class p387 {

    public p387() {
        long result = 0;
        List<Long> right = new ArrayList<>(10);
        for (long i = 1; i < 10; i++){
            right.add(i);
        }
        while (true) {
            List<Long> next = new ArrayList<>(right.size() * 3);
            for (long i : right) {
                for (int j = 0; j < 10; j++){
                    long val = i * 10 + j;
                    if (val % Operations.sumDigits(val) == 0) next.add(val);
                    if (Operations._isPrime(i / Operations.sumDigits(i)) && Operations._isPrime(val)) result += val;  // checking smaller number first makes program 20x faster
                }
            }
            right = next;
            if (right.get(0) == 1e13) break;
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        new p387();
        double end = (System.nanoTime() - start) / (double) 1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
