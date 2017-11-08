/**
 * Created by Robert on 6/1/2017.
 */
public class p211 {

    public p211() {
        long result = 1;
        int limit = 64000000;
        long[] alpha = new long[limit];
        for (int i = 0; i < limit; i++){
            alpha[i]++;
        }
        for (long i = 2; i < limit; i++){
            for (long j = i; j < limit; j += i){
                alpha[(int)j] += i * i;
            }
            long tst = (long)(Math.sqrt(alpha[(int)i]) + 0.5);
            if (tst * tst == alpha[(int)i]) result += i;
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        new p211();
        double end = (System.nanoTime() - start) / (double) 1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
