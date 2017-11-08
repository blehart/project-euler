import java.util.HashMap;

/**
 * Created by Robert on 5/23/2017.
 */
public class p118 {

    HashMap<Integer, Boolean> primes;
    int[] permu = {1, 2, 3, 4, 5, 6, 7, 8, 9};

    public boolean isPrime(int x){
        if (primes.containsKey(x)){
            return primes.get(x);
        }
        primes.put(x, Operations._isPrime(x));
        return primes.get(x);
    }

    public int checkPartitions(int start, int prev){
        int count = 0;
        for (int i = start; i < permu.length; i++){
            int number = 0;
            for (int j = start; j <= i; j++){
                number = number * 10 + permu[j];
            }

            if (!isPrime(number) || number < prev) continue;
            if (i == permu.length-1) return ++count;

            count += checkPartitions(i + 1, number);
        }
        return count;
    }

    public p118() {
        primes = new HashMap<>();
        int result = 0;

        while (permu != null){
            result += checkPartitions(0, 0);
            permu = Operations.nextPermutation(permu);
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        new p118();
        double end = (System.nanoTime() - start) / (double) 1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
