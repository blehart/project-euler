/**
 * Created by Robert on 6/12/2017.
 */
public class p301 {

    public p301() {
        int result = 0;
        for (int n = 1; n <= 1073741824; n++){
            if ((n ^ (2*n) ^ (3*n)) == 0) result++;
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        new p301();
        double end = (System.nanoTime() - start) / (double) 1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
