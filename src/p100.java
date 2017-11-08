/**
 * Created by Robert on 5/22/2017.
 */
public class p100 {

    public p100() {

        long a = 15, b = 21;
        long target = 1000000000000L;

        while (b < target){
            long ta = 3 * a + 2 * b - 2;
            long tb = 4 * a + 3 * b - 3;
            a = ta;
            b = tb;
        }
        System.out.println(a);
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        new p100();
        double end = (System.nanoTime() - start) / (double) 1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
