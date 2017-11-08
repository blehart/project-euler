import java.math.BigInteger;
import java.util.List;

/**
 * Created by Robert on 5/27/2017.
 */
public class p110 {

    int limit = 4000000;
    int[] expo;
    List<Integer> primes;


    public BigInteger Number(BigInteger result){
        BigInteger number = BigInteger.ONE;

        for (int i = 0; i < expo.length; i++){
            if (expo[i] == 0) break;
            number = number.multiply(BigInteger.valueOf(primes.get(i)).pow(expo[i]));

            if (result.compareTo(number) < 0) return result.add(BigInteger.ONE);
        }
        return number;
    }

    public void Twos(long limit) {
        expo[0] = 0;
        long divisors = 1;

        for (int i = 0; i < expo.length; i++) {
            divisors *= 2 * expo[i] + 1;
        }
        expo[0] = (int)(limit / divisors - 1) / 2;

        while (divisors*(2*expo[0]+1) < limit)
            expo[0]++;
    }

    public void SetAllSmallerExpo(int exp) {
        for (int i = 0; i < exp; i++) {
            expo[i] = expo[exp];
        }
    }



    public p110() {

        primes = Operations.sieveOfEratosthenes(45);
        expo = new int[primes.size()];

        BigInteger result = BigInteger.ONE;
        for (Integer prime : primes) {
            result = result.multiply(BigInteger.valueOf(prime));
        }

        long limit = 2*4000000-1;
        int counter = 1;

        while (true){
            Twos(limit);
            if (expo[0] < expo[1]){
                counter++;
            } else {
                BigInteger number = Number(result);
                if (number.compareTo(result) < 0){
                    result = number;
                }
                counter = 1;
            }
            if (counter >= expo.length) break;

            expo[counter]++;
            SetAllSmallerExpo(counter);

        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        new p110();
        double end = (System.nanoTime() - start) / (double) 1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
