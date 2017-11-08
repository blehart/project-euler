/**
 * Created by Robert on 6/4/2017.
 */
public class p243 {

    /*
    We know number formed by multiplying primes will have a low amount of coprimes
    When we get to 29, we're under the goal.
    So we take 2..23 multiplied by each composite below 29, to see if we can find a smaller number that
    is also under the goal.
     */
    public p243() {

        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
        int[] compos = {4, 6, 8, 9, 10, 12, 14, 15, 16, 18, 20, 21, 22, 24, 25, 26, 27, 28};
        long value = 1;
        double phi = 0;
        for (int i = 0; i < primes.length; i++){
            value *= primes[i];
            phi = value;
            for (int j = 0; j <= i; j++){
                phi *= (1 - 1.0/primes[j]);
            }
            if (phi / (double)(value-1) < 15499/94744.0){
                phi /= value * (1- 1.0/primes[i]);
                value /= primes[i];
                break;
            }
        }
        for (int i = 0; i < compos.length; i++){
            long nvalue = value * compos[i];
            double nphi = phi * nvalue;
            if (nphi / (double)(nvalue-1) < 15499/94744.0){
                System.out.println(nvalue);
                break;
            }
        }
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        new p243();
        double end = (System.nanoTime() - start) / (double) 1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
