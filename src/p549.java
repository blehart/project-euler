/**
 * Created by Robert on 5/31/2017.
 */
public class p549 {

    public p549() {

        long result = 0;
        int limit = 100000000;
        int[] s = new int[limit + 1];

        for (int i = 2; i < s.length; i++) {
            if (s[i] == 0) { // i is prime
                long power = 1;
                middle:
                for (int j = i; ; j += i) { // j contais at least one factor of i
                    power *= i;
                    if (power > limit)
                        break;

                    for (int inc = (int)power, k = inc; k < s.length; k += inc) { // update answer for all multiple of power
                        s[k] = Math.max(j, s[k]);
                    }

                    for (int temp = j / i; temp % i == 0; temp /= i) { // update power to include the remaining factors of i in j
                        power *= i;
                        if (power > limit)
                            break middle;
                    }
                }
            }
        }
        for (int i = 0; i < s.length; i++) {
            System.out.println(i + " " + s[i]);
            result += s[i];
        }

        System.out.println(result);
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        new p549();
        double end = (System.nanoTime() - start) / (double) 1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
