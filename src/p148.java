/**
 * Created by Robert on 5/24/2017.
 */
public class p148 {

    public p148() {

        long n = 1000000000;
        long c = 1;
        long sum = 0;

        while (n > 0){
            long k = 1;
            long i = 0;
            while (k*7 < n){
                k *= 7;
                i += 1;
            }
            long m = n / k;
            sum += c*m*(m+1)/2*(long)Math.pow(28, i);
            n -= k * m;
            c *= m + 1;
        }
        System.out.println(sum);
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        new p148();
        double end = (System.nanoTime() - start) / (double) 1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
