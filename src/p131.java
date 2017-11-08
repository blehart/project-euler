/**
 * Created by Robert on 5/24/2017.
 */
public class p131 {

    /**
     n^3 + n^2p = k^3
     n^3(1 + p/n) = k^3
     n^3(p+n/n) = k^3
     n cbrt(p+n/n) = k
     n * cbrt(p+n)/cbrt(n) = k
     both n and p+n need to be cubes
     n = x^3, p+n = y^3
     p = y^3 - n = y^3 - x^3 = (y - x)(y^2 + yx + x^2)
     (y - x) | p   since p is prime, (y - x) = 1
     p = (z+1)^3 - z^3

     z = 577, then p = 1000519
     */
    public p131() {

        int result = 0;
        for (int i = 0; i < 577; i++){
            if (Operations._isPrime((i+1)*(i+1)*(i+1) - i * i * i)) result++;
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        new p131();
        double end = (System.nanoTime() - start) / (double) 1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
