import java.util.HashSet;

/**
 * Created by Robert on 5/10/2017.
 */
public class p037 {

    HashSet<Integer> primes;

    public boolean truncatable(int x){
        int temp = x;
        while (temp != 0){
            if (!primes.contains(temp)) return false;
            temp /= 10;
        }
        temp = x;
        while (temp != 0){
            if (!primes.contains(temp)) return false;
            temp %= (int)Math.pow(10, (int)Math.log10(temp));
        }
        return true;
    }

    public p037(){
        primes = new HashSet<>(Operations.sieveOfEratosthenes(1000000));
        int result = 0;
        int count = 0;
        for (int i = 11; count < 11; i++){
            if (truncatable(i)){
                result += i;
                count++;
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args){
        long start = System.nanoTime();
        new p037();
        double end = (System.nanoTime() - start)/(double)1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
