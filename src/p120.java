/**
 * Created by Robert on 5/23/2017.
 */
public class p120 {

    public p120() {

        int result = 0;
        for (int a = 3; a <= 1000; a++){
            result += 2*a*((a-1)/2);
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        new p120();
        double end = (System.nanoTime() - start) / (double) 1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
