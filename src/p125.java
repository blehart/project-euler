import java.util.HashSet;

/**
 * Created by Robert on 5/24/2017.
 */
public class p125 {

    public p125() {
        long result = 0;
        long limit = 100000000;
        int sqrtLimit = (int)Math.sqrt(limit); //= 10000
        HashSet<Integer> visited = new HashSet<>();

        for (int i = 1; i <= sqrtLimit; i++){
            long sum = i * i;
            for (int j = i+1; j <= sqrtLimit; j++){
                sum += j*j;
                if (sum > limit) break;
                if (Operations.isPalindrome(sum) && !visited.contains((int)sum)){
                    result += sum;
                    visited.add((int)sum);
                }
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        new p125();
        double end = (System.nanoTime() - start) / (double) 1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
