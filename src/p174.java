/**
 * Created by Robert on 6/1/2017.
 */
public class p174 {

    public p174() {
        int result = 0;
        int limit = 1000000;
        int[] L = new int[limit + 1];
        for (int i = 8; i <= limit; i+=4){
            int total = i;
            int cur = i;
            while (total <= limit){
                L[total]++;
                cur += 8;
                total += cur;
            }
        }
        for (int i : L){
            if (1 <= i && i <= 10) result += 1;
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        new p174();
        double end = (System.nanoTime() - start) / (double) 1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
