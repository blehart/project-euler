import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Robert on 5/29/2017.
 */
public class p140 {

    /*
    Modified Fibonacci Generating Function
    f(x) = (x + 3x^2)/(1-x-x^2)
     */
    public p140() {
        long result = 0;
        long[][] start = new long[][] { {0, -1},
                                        {0, 1},
                                        {-3, -2},
                                        {-3, 2},
                                        {-4, -5},
                                        {-4, 5},
                                        {2, -7},
                                        {2, 7}};
        List<Long> nuggets = new ArrayList<>();

        for (int i = 0; i < start.length; i++){
            long k = start[i][0];
            long b = start[i][1];

            for (int j = 0; j < 30; j++){
                long nk = -9 * k - 4 * b - 14;
                long nb = -20 * k - 9 * b - 28;

                k = nk;
                b = nb;

                if (k > 0 && !nuggets.contains(k)) nuggets.add(k);
            }
        }

        Collections.sort(nuggets);
        for (int i = 0; i < 30; i++){
            result += nuggets.get(i);
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        new p140();
        double end = (System.nanoTime() - start) / (double) 1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
