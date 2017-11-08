/**
 * Created by Robert on 6/1/2017.
 */
public class p164 {

    long[][][] cache = new long[10][10][20];

    public long f(int prev1, int prev2, int remain){
        if (remain == 0) return 1;
        if (cache[prev1][prev2][remain] == 0){
            for (int i = 0; i + prev1 + prev2 <= 9; i++){
                cache[prev1][prev2][remain] += f(prev2, i, remain-1);
            }
        }
        return cache[prev1][prev2][remain];
    }

    public p164() {
        long result = 0;
        for (int i = 1; i < 10; i++){
            result += f(0, i, 19);
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        new p164();
        double end = (System.nanoTime() - start) / (double) 1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
