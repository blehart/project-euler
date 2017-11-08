/**
 * Created by Robert on 5/23/2017.
 */
public class p117 {

    long[] cache;

    public long calcWays(int r){

        long result = 1; //blank
        if (2 > r) return result; //block too big
        if (cache[r] != 0) return cache[r];

        for (int j = 2; j <= 4; j++){ // size of block
            for (int i = 0; i <= r-j; i++){
                result += calcWays(r - i - j); // multiple blocks ahead of this one
            }
        }
        cache[r] = result;
        return result;
    }

    public p117() {

        cache = new long[51];
        System.out.println(calcWays(50));
    }
    public static void main(String[] args) {
        long start = System.nanoTime();
        new p117();
        double end = (System.nanoTime() - start) / (double) 1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
