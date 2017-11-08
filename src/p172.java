/**
 * Created by Robert on 6/18/2017.
 */
public class p172 {

    int digit = 18;
    int base = 10;
    int max_r = 3;

    public long binomial(int n, int k){
        if (k > n-k) k = n-k;
        long b = 1;
        for (int i = 1, m=n; i<=k; i++, m--){
            b = b * m / i;
        }
        return b;
    }

    public long nd(int d, int b){
        if (b > 1){
            long sum = 0;
            for (int r = 0; r < Math.min(d+1, max_r+1); r++){
                sum += nd(d-r, b-1) * binomial(d, r);
            }
            return sum;
        }
        if (d <= max_r) return 1;
        return 0;

    }

    public p172() {
        System.out.println(nd(digit, base) * (base-1)/base);
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        new p172();
        double end = (System.nanoTime() - start) / (double) 1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
