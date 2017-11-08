/**
 * Created by Robert on 5/24/2017.
 */
public class p130 {

    public p130() {

        int n = 89, result = 0, count = 0;

        while (count < 25){
            n += 2;
            if (Operations._isPrime(n) || n % 10 == 5) continue;  // Numbers ending with odd number but not 5, are coprimes with 10
            int r = 1, i = 2;
            while ((r = (r * 10 + 1) % n) != 0) i++;
            if ((n-1) % i == 0){
                result += n;
                count++;
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        new p130();
        double end = (System.nanoTime() - start) / (double) 1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
