/**
 * Created by Robert on 5/22/2017.
 */
public class p101 {

    int[] coef = {1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1};

    public long evaluate(int x) {
        long p = 0;
        for (int i = 10; i >= 0; i--)
            p = coef[i] + (x * p);
        return p;
    }

    public p101() {
        long[] y = new long[coef.length];
        for (int i = 0; i < y.length; i++){
            y[i] = evaluate(i+1);
        }
        long fits = 0;
        for (long n = 1; n <= coef.length-1; n++){
            long result = 0;
            for (long i = 1; i <= n; i++){
                long temp1 = 1;
                long temp2 = 1;

                for (long j = 1; j <= n; j++){
                    if (i != j) {
                        temp1 *= n+1 - j;
                        temp2 *= i - j;
                    }
                }
                result += temp1 * y[(int)i-1]/temp2;
            }
            fits += result;
        }
        System.out.println(fits);
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        new p101();
        double end = (System.nanoTime() - start) / (double) 1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
