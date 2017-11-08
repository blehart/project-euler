/**
 * Created by Robert on 5/29/2017.
 */
public class p138 {

    /*
    L^2 = (2x+-1)^2 + x^2
    0 = 5x^2 - L^2 +- 4x + 1

    Using 2 variable equation solver:
    x_n+1 = -9x_n - 4y_n + 4
    y_n+1 = -20x_n - 9y_n + 8
     */

    public p138() {
        long result = 0, x = 0, y = -1;

        for (int i = 0; i < 12; i++) {
            long nx = -9 * x + -4 * y + 4;
            long ny = -20 * x + -9 * y + 8;

            x = nx;
            y = ny;

            result += Math.abs(y);
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        new p138();
        double end = (System.nanoTime() - start) / (double) 1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
