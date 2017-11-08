/**
 * Created by Robert on 5/17/2017.
 */
public class p094 {


    public p094() {

        long x = 2;
        long y = 1;
        long result = 0;
        long max = 1000000000L;

        while(true){
            long aTimes3 = 2 * x - 1;
            long areaTimes3 = y * (x - 2);
            if (aTimes3 > max) break;

            if (aTimes3 > 0 && areaTimes3 > 0 && aTimes3 % 3 == 0 && areaTimes3 % 3 == 0) {
                long a = aTimes3 / 3;
                result += 3 * a + 1;
            }

            aTimes3 = 2 * x + 1;
            areaTimes3 = y * (x + 2);

            if (aTimes3 > 0 && areaTimes3 > 0 && aTimes3 % 3 == 0 && areaTimes3 % 3 == 0) {
                long a = aTimes3 / 3;
                result += 3 * a - 1;
            }

            long nx = 2 * x + y * 3;
            long ny = y * 2 + x;
            x = nx;
            y = ny;
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        new p094();
        double end = (System.nanoTime() - start) / (double) 1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
