import java.util.BitSet;

/**
 * Created by Robert on 6/1/2017.
 */
public class p204 {

    public p204() {

        int limit = 1000000000;
        int type = 100;

        BitSet sieve = new BitSet(limit+1);
        BitSet hamming = new BitSet(limit+1);
        hamming.set(1, true);
        for (int i = 2; i <= limit; i++){
            if (!sieve.get(i)){
                for (int j = i; j <= limit; j+=i){
                    sieve.set(j, true);
                    if (i > type) hamming.set(j, false);
                    else hamming.set(j, true);
                }
            }
        }
        System.out.println(hamming.cardinality());
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        new p204();
        double end = (System.nanoTime() - start) / (double) 1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
