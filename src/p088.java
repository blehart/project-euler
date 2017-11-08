import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Created by Robert on 5/16/2017.
 */
public class p088 {

    public p088() {
        int maxK = 12000;
        int maxN = maxK * 2;  // k = n  2k = 1....2n
        int numFactors = (int)(Math.log10(maxN) / Math.log10(2));
        int[] factors = new int[numFactors];
        int[] k = IntStream.range(0, maxK+1).map((int x) -> (x * 2)).toArray();
        k[1] = 0;

        factors[0] = 1;
        int curMaxFactor = 1;
        int j = 0;

        while (true){
            if (j == 0){
                if (curMaxFactor == numFactors) break;
                if (factors[0] < factors[1]) factors[0]++;
                else {
                    curMaxFactor++;
                    factors[curMaxFactor -1] = Integer.MAX_VALUE;
                    factors[0] = 2;
                }
                j++;
                factors[1] = factors[0] - 1;

            } else if (j == curMaxFactor-1){
                factors[j]++;
                int sum = 0;
                int prod = 1;
                for (int i = 0; i < curMaxFactor; i++){
                    prod *= factors[i];
                    sum += factors[i];
                }
                if (prod > maxN) j--;
                else {
                    int pk = prod - sum + curMaxFactor;
                    if (pk <= maxK && prod < k[pk]) k[pk] = prod;
                }
            } else if (factors[j] < factors[j + 1]){
                factors[j]++;
                factors[j+1] = factors[j]-1;
                j++;
            } else if (factors[j] >= factors[j + 1]){
                j--;
            }
        }
        System.out.println(Arrays.stream(k).distinct().sum());
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        new p088();
        double end = (System.nanoTime() - start) / (double) 1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
