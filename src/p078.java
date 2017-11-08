/**
 * Created by Robert on 5/14/2017.
 */
public class p078 {

    /**
     * p(n) = p(n-1) + p(n-2) - p(n-5) - p(n-7) + p(n-12) + p(n-15) - p(n-22)
     * p(0) = 1 and p(n)  = 0 for n < 0
     */
    public p078(){
        int[] p = new int[100000];
        p[0] = 1;

        int n = 1;
        while (true){
            int i = 0;
            int penta = 1;
            p[n] = 0;

            while (penta <= n){
                int sign = (i % 4 > 1) ? -1 : 1;
                p[n] += sign * p[n-penta];
                p[n] %= 1000000;
                i++;

                int j = (i % 2 == 0) ? i / 2 + 1 : -(i / 2 + 1);
                penta = j * (3 * j - 1) / 2;
            }
            if (p[n] == 0) break;
            n++;
        }
        System.out.println(n);
    }

    public static void main(String[] args){
        long start = System.nanoTime();
        new p078();
        double end = (System.nanoTime() - start)/(double)1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
