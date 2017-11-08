/**
 * Created by Robert on 6/5/2017.
 */
public class p183 {

    public boolean terminates(long denominator){
        while (denominator % 2 == 0) denominator /= 2;
        while (denominator % 5 == 0) denominator /= 5;
        return denominator == 1;
    }

    public p183() {
        int result = 0, limit = 10001;
        for (int N = 5; N < limit; N++){
            double max = 0;
            long denominator = 0;
            for (int i = N/3; i <= N/2; i++){
                double value = i * Math.log((double)N/i);
                if (value > max){
                    max = value;
                    denominator = i / Operations.GCD(N, i);
                }
            }
            result += terminates(denominator) ? -N : N;
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        new p183();
        double end = (System.nanoTime() - start) / (double) 1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
