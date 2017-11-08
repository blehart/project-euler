/**
 * Created by Robert on 5/22/2017.
 */
public class p073 {

    /**
     * Farey sequence
     *
     * Start at 1/3, go until 1/2
     * Need second fraction after 1/3, we know (a/b, c/d) 3*c - 1*d = 1, so c/d = 4000/11999
     */
    public p073() {

        int limit = 12000;
        int result = 0;
        int a = 1, b = 3, c = 4000, d = 11999;

        while (c != 1 && d != 2){
            int k = (limit + b) / d;
            int m = k * c - a;
            int n = k * d - b;
            a = c;
            b = d;
            c = m;
            d = n;
            result++;
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        new p073();
        double end = (System.nanoTime() - start) / (double) 1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
