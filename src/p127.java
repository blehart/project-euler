/**
 * Created by Robert on 5/24/2017.
 */
public class p127 {

    public p127() {

        int result = 0;
        int limit = 120000;
        long[] rads = new long[limit+1];

        for (int i = 0; i < rads.length; i++){
            rads[i] = 1;
        }
        for (int i = 2; i < limit; i++){
            if (rads[i] == 1){
                rads[i] = i;

                for (int j = i+i; j < limit; j += i){
                    rads[j] *= i;
                }
            }
        }
        for (int c = 3; c < limit; c++){
            for (int b = c/2+1; b < c; b++){
                int a = c - b;
                if (rads[a] * rads[b] * rads[c] < c && Operations.coprime(a, b)) result += c;
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        new p127();
        double end = (System.nanoTime() - start) / (double) 1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
