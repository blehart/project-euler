import java.util.HashSet;

/**
 * Created by Robert on 5/10/2017.
 */
public class p041 {

    public boolean isPandigital(int n){
        int digits = 0, count = 0, tmp;
        for (; n > 0; n /= 10, count++){
            if ((tmp = digits) == (digits |= 1 << (n - ((n / 10) * 10) - 1)))
                return false;
        }
        return digits == (1 << count) - 1;
    }

    public p041(){
        HashSet<Integer> primes = new HashSet<>(Operations.sieveOfEratosthenes(10000000));
        int result = 0;
        for (int i = 1; i < 10000000; i++){
            if (primes.contains(i) && isPandigital(i)) {
                result = i;
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args){
        long start = System.nanoTime();
        new p041();
        double end = (System.nanoTime() - start)/(double)1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
