import java.util.HashSet;
import java.util.List;

/**
 * Created by Robert on 5/11/2017.
 */
public class p046 {

    public p046() {
        List<Integer> primes = Operations.sieveOfEratosthenes(10000);
        HashSet<Integer> primesSet = new HashSet<>(primes);
        HashSet<Integer> twiceSquares = new HashSet<>();
        for (int i = 1; i < 10000; i++){
            twiceSquares.add(2 * i * i);
        }
        for (int i = 3;; i += 2) {
            if (!primesSet.contains(i)){
                boolean flag = false;
                for (int j = 0; primes.get(j) < i; j++){
                    if (twiceSquares.contains(i - primes.get(j))){
                        flag = true;
                    }
                }
                if (!flag){
                    System.out.println(i);
                    break;
                }
            }
        }
    }

    public static void main(String[] args){
        long start = System.nanoTime();
        new p046();
        double end = (System.nanoTime() - start)/(double)1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
