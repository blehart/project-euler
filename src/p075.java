/**
 * Created by Robert on 5/14/2017.
 */
public class p075 {

    /**
     * Pythagorean Triplet Formulas for a, b, c based on m, n
     * a = m^2 + n^2
     * b = m^2 - n^2
     * c = 2mn
     *
     * m > n
     * one is even
     * GCD = 1
     */
    public p075(){
        int limit = 1500000;
        int[] triplets = new int[limit+1];

        int result = 0;
        int mlimit = (int)Math.sqrt(limit/2);

        for (long m = 2; m < mlimit; m++){
            for (long n = 1; n < m; n++){
                if ((m + n) % 2 == 1 && Operations.GCD(m, n) == 1) {  // only one is even, coprimes
                    long a = m * m + n * n;
                    long b = m * m - n * n;
                    long c = 2 * m * n;
                    int p = (int)(a + b + c);
                    while (p <= limit){
                        triplets[p]++;
                        if (triplets[p] == 1) result++;
                        if (triplets[p] == 2) result--;
                        p += (int)(a + b + c);
                    }
                }
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args){
        long start = System.nanoTime();
        new p075();
        double end = (System.nanoTime() - start)/(double)1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
