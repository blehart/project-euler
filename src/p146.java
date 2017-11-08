import java.util.List;

/**
 * Created by Robert on 6/14/2017.
 */
public class p146 {

    public static int[] Add = new int[]{1, 3, 7, 9, 13, 27};
    public static int[] NotAdd = new int[]{19, 21};

    public boolean[] Mods(int m){
        boolean[] result = new boolean[m];
        for (int i = 0; i < m; i++){
            result[i] = true;
            for (int j = 0; j < Add.length; j++){
                if (i * i + Add[j] % m == 0){
                    result[i] = false;
                    break;
                }
            }
        }
        return result;
    }

    public p146() {
        long result = 0;
        long limit = 150000000;
        List<Integer> primes = Operations.sieveOfEratosthenes(2, 5000);
        boolean[][] mods = new boolean[primes.size()][];

        for (int i = 0; i < primes.size(); i++){
            mods[i] = Mods(primes.get(i));
        }

        for (long i = 10; i < limit; i+=10){
            boolean ok = true;
            for (int j = 0; ok && j < primes.size() && i*i > primes.get(j); j++){
                ok = mods[j][(int)(i % primes.get(j))];
            }
            for (int j = 0; ok && j < Add.length; j++){
                ok = Operations.isProbablyPrime(i * i + Add[j]);
            }

            for (int j = 0; ok && j < NotAdd.length; j++){
                ok = !Operations.isProbablyPrime(i * i + NotAdd[j]);
            }

            if (ok) result += i;
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        new p146();
        double end = (System.nanoTime() - start) / (double) 1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
