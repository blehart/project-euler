/**
 * Created by Robert on 5/23/2017.
 */
public class p116 {

    long[] cache;

    /**
     * Calculate the numbers of ways a block size minimum size r can
     * fit into a row of size r
     * @param r Row size
     * @param c Color aka Block size
     * @return
     */
    public long calcWays(int r, int c){

        long result = 0;
        if (c > r) return result; //block too big
        if (cache[r] != 0) return cache[r];

        for (int i = 0; i <= r-c; i++){ // position of block
            result += 1 + calcWays(r - i - c, c); // multiple blocks ahead of this one
        }
        cache[r] = result;
        return result;
    }

    public p116() {
        int row = 50;
        long result = 0;
        for (int color = 2; color <= 4; color++) {
            cache = new long[row + 1];
            result += calcWays(row, color);
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        new p116();
        double end = (System.nanoTime() - start) / (double) 1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
