import java.util.HashSet;

/**
 * Created by Robert on 5/10/2017.
 */
public class p035 {

    HashSet<Integer> primes;

    public boolean isCircularPrime(int n){
        if (!primes.contains(n)) return false;  // Check if original is prime
        int num = n;

        int numDigits = (int)Math.log10((double)num);
        int multiplier = (int)Math.pow(10.0, (double)numDigits);

        while (true){
            int r = num % 10; // Get last digit

            num /= 10;         // Remove last digit
            num += multiplier * r;  // Add last digit to the front

            if (num == n)  // We fully rotated back to original
                break;

            if (!primes.contains(num)) return false;  // Check if rotation is prime
        }
        return true;
    }

    public p035(){
        primes = new HashSet<Integer>(Operations.sieveOfEratosthenes(1000000));
        int result = 0;
        for (int i = 2; i < 1000000; i++){
            if (isCircularPrime(i)){
                result++;
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args){
        long start = System.nanoTime();
        new p035();
        double end = (System.nanoTime() - start)/(double)1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
