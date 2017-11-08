/**
 * Created by Robert on 6/17/2017.
 */
public class p225 {

    public p225() {
        int c = 0;
        int i = 27;

        while (c < 124) {
            int t1 = 1, t2 = 1, t3 = 3;
            while (t3 > 0 && t1 * t2 * t3 != 1) {
                int tmp = t3;
                t3 = (t1 + t2 + t3) % i;
                t1 = t2;
                t2 = tmp;
            }
            if (t3 > 0) c++;
            i += 2;
        }
        System.out.println(i - 2);
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        new p225();
        double end = (System.nanoTime() - start) / (double) 1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
