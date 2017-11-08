/**
 * Created by Robert on 5/27/2017.
 */
public class p128 {


    public p128() {
        int count = 1;
        int limit = 2000;
        long n = 0;
        long number = 0;

        while (count < limit){
            n++;
            if (Operations._isPrime(6 * n -1) && Operations._isPrime(6*n+1) && Operations._isPrime(12*n+5)){
                count++;
                number = (3 * n * n - 3 * n + 2);
                if ( count >= limit) break;
            }
            if (Operations._isPrime(6*n+5) && Operations._isPrime(6*n-1) && Operations._isPrime(12*n-7) && n != 1){
                count++;
                number = (3 * n * n + 3 * n + 1);
            }
        }

        System.out.println(number);
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        new p128();
        double end = (System.nanoTime() - start) / (double) 1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
