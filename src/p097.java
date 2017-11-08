
/**
 * Created by Robert on 5/17/2017.
 */
public class p097 {

    public p097() {
        long result = 28433;
        for (int i = 0; i < 7830457; i++){
            result *= 2;
            result %= 10000000000L;
        }
        result += 1;
        System.out.println(result);
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        new p097();
        double end = (System.nanoTime() - start) / (double) 1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
