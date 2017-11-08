/**
 * Created by Robert on 5/16/2017.
 */
public class p091 {

    final int max = 50;

    public p091() {
        int result = 0;
        for (int x1 = 0; x1 <= max; x1++){
            for (int y1 = 0; y1 <= max; y1++){
                if (x1 == 0 && y1 == 0) continue;

                for (int x2 = 0; x2 <= max; x2++){
                    for (int y2 = 0; y2 <= max; y2++){
                        if ((x2 == 0 && y2 == 0) || (x1 == x2 && y1 == y2)) continue;

                        int a = (int)(Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2));
                        int b = x1*x1 + y1*y1;
                        int c = x2*x2 + y2*y2;
                        if (a + b == c || a + c == b || b + c == a) result++;
                    }
                }
            }
        }
        System.out.println(result/2);
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        new p091();
        double end = (System.nanoTime() - start) / (double) 1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
