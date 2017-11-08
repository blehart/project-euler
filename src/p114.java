/**
 * Created by Robert on 5/23/2017.
 */
public class p114 {

    long[] cache;

    /**
     * Calculate the numbers of ways a block size minimum size r can
     * fit into a row of size r
     * @param r Row size
     * @param b Block size
     * @return
     */
    public long calcWays(int r, int b){

        long result = 1; //blank
        if (b > r) return result; //block too big
        if (cache[r] != 0) return cache[r];

        for (int i = 0; i <= r-b; i++){ // position of block
            for (int j = b; j <= r-i; j++){ // size of block
                result += calcWays(r - i - j - 1, b); // multiple blocks ahead of this one
            }
        }
        cache[r] = result;
        return result;
    }

    public p114() {
        cache = new long[51];
        System.out.println(calcWays(50, 3));
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        new p114();
        double end = (System.nanoTime() - start) / (double) 1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
