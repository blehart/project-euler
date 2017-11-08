/**
 * Created by Robert on 5/15/2017.
 */
public class p086 {

    public p086() {

        int l = 2;
        int count = 0;
        int target = 1000000;

        /**
         * Formula for shortest path: sqrt((w+h)^2 + L^2)
         * Combine (w+h) into one variable wh
         * let L be the largest of the 3 sides
         * If we have integer solution, count all combinations of w and h that would equal our wh variable
         */
        while (count < target) {
            l++;
            for (int wh = 3; wh <= 2 * l; wh++) {
                double sqrt = Math.sqrt(wh * wh + l * l);
                if (sqrt == (int)(sqrt)) {
                    count += (wh <= l) ? wh / 2 : 1 + (l - (wh+1)/2);
                }
            }
        }
        System.out.println(l);
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        new p086();
        double end = (System.nanoTime() - start) / (double) 1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
