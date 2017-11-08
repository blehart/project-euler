/**
 * Created by Robert on 5/24/2017.
 */
public class p129 {

    public p129() {

        int limit = 1000001;
        int n = limit, i = 0;

        while (i < limit){
            n += 2;
            if (n % 10 == 5) continue;  // Numbers ending with odd number but not 5, are coprimes with 10
            int r = 1; i = 1;
            while ((r = (r * 10 + 1) % n) != 0) i++;
        }
        System.out.println(n);
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        new p129();
        double end = (System.nanoTime() - start) / (double) 1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
