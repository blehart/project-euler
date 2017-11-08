/**
 * Created by Robert on 5/27/2017.
 */
public class p108 {

    int[] primes = {2, 3, 5, 7, 11, 13, 17};

    public int sudoDivisors(int x){
        int nod = 1;
        int expo;
        int r = x;

        for (int prime : primes) {
            if (prime * prime > x) return nod * 2;
            expo = 1;
            while (r % prime == 0) {
                expo += 2;
                r /= prime;
            }
            nod *= expo;
            if (r == 1) return nod;
        }
        return nod;
    }

    public p108() {
        int n = 1, result = 0, limit = 1000;
        while ((sudoDivisors(n)+1)/2 <= limit){
            n++;
            result = n;
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        new p108();
        double end = (System.nanoTime() - start) / (double) 1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
