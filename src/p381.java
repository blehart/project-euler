import java.util.List;

/**
 * Created by Robert on 6/6/2017.
 */
public class p381 {

    /*
    (p-1)! + ... + (p-5)! = 9 * (-24)^-1 (mod p)
    Use the Extended Euclidean to find the inverse modulo
     */
    public int extendedEuclidean(int a, int b){
        int s = 0, olds = 1;
        int t = 1, oldt = 0;
        int r = b, oldr = a;

        while (r != 0){
            int quotient = oldr / r;

            int temp = r;
            r = oldr - quotient * r;
            oldr = temp;

            temp = s;
            s = olds - quotient * s;
            olds = temp;

            temp = t;
            t = oldt - quotient * t;
            oldt = temp;
        }
        return (oldr < 0) ? b-olds : olds;
    }

    public p381() {

        int limit = 100000000;
        long result = 0;

        List<Integer> primes = Operations.sieveOfEratosthenes(5, limit);

        for (int p : primes){
            result += (9 * extendedEuclidean(-24, p)) % p;
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        new p381();
        double end = (System.nanoTime() - start) / (double) 1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
