/**
 * Created by Robert on 6/8/2017.
 */
public class p250 {

    public p250() {

        int limit = 250;
        int[] freq = new int[limit];
        long sixteen = (long)Math.pow(10, 16);
        long[] s = new long[limit], t = new long[limit];

        for (int i = 1; i <= 250250; i++){
            freq[Operations.modPow(i, i, limit)]++;
        }
        s[0] = 1;
        for (int i = 0; i < limit; i++){
            for (int j = 0; j < freq[i]; j++){
                for (int k = 0; k < limit; k++){
                    t[k] = (s[k] + s[(k-i+limit)%limit]) % sixteen;  // We use +limit%limit to wrap negative values
                }
                s = t;
                t = new long[limit];
            }
        }
        System.out.println(s[0]-1);
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        new p250();
        double end = (System.nanoTime() - start) / (double) 1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
