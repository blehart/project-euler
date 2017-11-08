/**
 * Created by Robert on 6/1/2017.
 */
public class p187 {

    public p187() {
        int result = 0;
        int limit = 100000000;
        int[] ndivisors = new int[limit];
        for (int i = 2; i < limit; i++){
            if (ndivisors[i] == 0) {
                for (int j = i + i; j < limit; j += i) {
                    int temp = j;
                    while (temp % i == 0){
                        ndivisors[j]++;
                        temp /= i;
                    }
                }
            }
            if (ndivisors[i] == 2) result++;
        }
        System.out.println(result);

    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        new p187();
        double end = (System.nanoTime() - start) / (double) 1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
