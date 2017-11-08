/**
 * Created by Robert on 6/1/2017.
 */
public class p173 {

    public p173() {
        int result = 0;
        int limit = 1000000;
        for (int i = 8; i <= limit; i+=4){
            int total = i;
            int cur = i;
            while (total <= limit){
                result++;
                cur += 8;
                total += cur;
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        new p173();
        double end = (System.nanoTime() - start) / (double) 1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
