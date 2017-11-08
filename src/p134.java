import java.util.List;

/**
 * Created by Robert on 5/24/2017.
 */
public class p134 {

    public long[] extendedGCD(long a, long b){
        long s = 0, ps = 1;
        long t = 1, pt = 0;

        while (b != 0){
            long q = a / b;

            long temp = b;
            b = a % b;
            a = temp;

            temp = s;
            s = ps - q * s;
            ps = temp;

            temp = t;
            t = pt - q * t;
            pt = temp;
        }

        return new long[] {ps, pt, a};
    }

    /**
     * 10^digits(p1)*x + p1 == 0 (mod p2)
     * 10^d(p1)*x == -p1 (mod p2)
     * 10^d(p1)*x == p2-p1(mod p2)
     * ax == b (mod n)
     */
    public p134() {

        long result = 0;
        int limit = 1000000;
        List<Integer> primes = Operations.sieveOfEratosthenes(5, limit+100);
        for (int i = 0; primes.get(i) < limit; i++){

            long p1 = primes.get(i), p2 = primes.get(i+1);
            long a = (long)Math.pow(10, Operations.numDigits(p1));

            long b = p2 - p1;

            long[] rs = extendedGCD(a, p2);
            long x = rs[0] * b % p2;

            if (x < 0) x += p2;

            result += x * a + p1;
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        new p134();
        double end = (System.nanoTime() - start) / (double) 1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
