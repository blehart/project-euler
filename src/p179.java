/**
 * Created by Robert on 6/1/2017.
 */
public class p179 {

    public p179() {
        int result = 0;
        int limit = 10000000;
        int[] ndivisors = new int[limit];
        ndivisors[1] = 1;
        for (int i = 2; i < limit; i++){

            for (int j = i + i; j < limit; j += i){
                ndivisors[j]++;
            }

            ndivisors[i] += 2;
            if (ndivisors[i] == ndivisors[i-1]) result++;
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        new p179();
        double end = (System.nanoTime() - start) / (double) 1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
