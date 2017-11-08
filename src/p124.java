import java.util.Arrays;

/**
 * Created by Robert on 5/24/2017.
 */
public class p124 {

    public p124() {
        int limit = 100000;
        Pair[] rads = new Pair[limit];
        for (int i = 0; i < limit; i++){
            rads[i] = new Pair(i, 1);
        }
        for (int i = 2; i < limit; i++){
            if (rads[i].y == 1){
                rads[i].y = i;

                for (int j = i+i; j < limit; j += i){
                    rads[j].y *= i;
                }
            }
        }

        Arrays.sort(rads, (Pair p1, Pair p2) -> (int)(p1.y - p2.y));
        System.out.println(rads[9999].x);
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        new p124();
        double end = (System.nanoTime() - start) / (double) 1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
