/**
 * Created by Robert on 6/12/2017.
 */
public class p191 {

    public p191() {
        //           {days, count, ends with AA, contains 0 L, ends with A, contains 1 L and ends with AA, contains 1 L and ends with A, contains 1L and doesn't end with any A}
        int[] vals = {1, 3, 0, 2, 1, 0, 0, 1};
        while (vals[0] < 30){
            vals = new int[]{vals[0]+1, 2*vals[1]+vals[3]-vals[2], vals[4], 2*vals[3]-vals[2]+vals[5], vals[1]-(vals[2]+vals[4]), vals[6], vals[7], vals[1]};
        }
        System.out.println(vals[1]);
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        new p191();
        double end = (System.nanoTime() - start) / (double) 1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
