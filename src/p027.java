import java.util.HashSet;

/**
 * Created by Robert on 5/9/2017.
 */
public class p027 {

    public p027(){
        int result = 0;
        int max = 0;
        HashSet<Integer> primes = new HashSet<>(Operations.sieveOfEratosthenes(20000));
        for (int i = -999; i < 1000; i++){
            for (int j = -1000; j <= 1000; j++){
                int n = 0;
                while (primes.contains(n*n + i*n + j)){
                    n++;
                }
                if (n > max){
                    max = n;
                    result = i * j;
                }
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args){
        long start = System.nanoTime();
        new p027();
        double end = (System.nanoTime() - start)/(double)1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
