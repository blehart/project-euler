/**
 * Created by Robert on 6/14/2017.
 */
public class p151 {

    public double evaluate(int[] sheets){
        int num = 0;
        for (int i : sheets) num += i;

        double single = 0;
        if (num == 1){
            if (sheets[4] == 1) return 0;
            if (sheets[0] == 0) single = 1;
        }

        for (int i = 0; i < 5; i++){
            if (sheets[i] == 0) continue;
            int[] next = sheets.clone();

            next[i]--;
            for (int j = i + 1; j < 5; j++) next[j]++;

            double prob = sheets[i] / (double)num;
            single += evaluate(next) * prob;
        }
        return single;
    }

    public p151() {
        int[] A = {1, 0, 0, 0, 0};
        System.out.printf("%.6f\n", evaluate(A));
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        new p151();
        double end = (System.nanoTime() - start) / (double) 1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
