/**
 * Created by Robert on 5/15/2017.
 */
public class p085 {

    final int size = 500;
    final int target = 2000000;

    public p085() {
        long area = 0;
        long difference = Long.MAX_VALUE;

        for (int i = 1; i < size; i++){
            for (int j = 1; j < size; j++){
                long val = (((i + 1) * i)/2) * (((j + 1) * j)/2);
                long dif = Math.abs(val - target);
                if (dif < difference){
                    difference = dif;
                    area = i * j;
                }
                if (i * j > target) break;
            }
        }
        System.out.println(area);
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        new p085();
        double end = (System.nanoTime() - start) / (double) 1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
