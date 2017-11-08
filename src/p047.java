import java.util.List;

/**
 * Created by Robert on 5/11/2017.
 */
public class p047 {

    List<Integer> primes;

    public int distinctPrimeFactors(long x){
        int result = 0;
        int i = 0;
        int j = -1;
        while (x != 1){
            if (x % primes.get(i) == 0){
                x /= primes.get(i);
                if (j != i) result++;
                j = i;
            } else {
                i++;
            }
        }
        return result;
    }

    public p047(){
        primes = Operations.sieveOfEratosthenes(1000000);
        int i = 1;
        while (true){
            if (distinctPrimeFactors(i) == 4){
                if (distinctPrimeFactors(i+1) == 4) {
                    if (distinctPrimeFactors(i+2) == 4) {
                        if (distinctPrimeFactors(i+3) == 4){
                            System.out.println(i);
                            break;
                        }
                        i++;
                    }
                    i++;
                }
                i++;
            }
            i++;
        }
    }

    public static void main(String[] args){
        long start = System.nanoTime();
        new p047();
        double end = (System.nanoTime() - start)/(double)1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
