/**
 * Created by Robert on 5/31/2017.
 */
public class p205 {

    public int sumArray(int[] x){
        int sum = 0;
        for (int i : x)
            sum += i;
        return sum;
    }

    public int[] next(int[] x, int max){
        int i = x.length-1;
        x[i]++;
        while (x[i] > max){
            if (i == 0) return null;
            x[i] = 1;
            i--;
            x[i]++;
        }
        return x;
    }

    public p205() {
        int total = 0, total2 = 0;
        int[] roll = {1, 1, 1, 1, 1, 1};
        int[] roll2 = {1, 1, 1, 1, 1, 1, 1, 1, 1};
        double[] prob1 = new double[37];
        double[] prob2 = new double[37];

        while (roll != null){
            total++;
            for (int i = sumArray(roll); i < prob1.length; i++) {
                prob1[i]++;
            }
            roll = next(roll, 6);
        }

        while (roll2 != null){
            total2++;
            prob2[sumArray(roll2)]++;
            roll2 = next(roll2, 4);
        }

        for (int i = 0; i < 37; i++){
            prob1[i] /= total;
            prob2[i] /= total2;
        }

        double result = 0.0;
        for (int i = 9; i < 37; i++){
            result += prob2[i] * prob1[i-1];
        }
        System.out.printf("%.7f\n", result);
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        new p205();
        double end = (System.nanoTime() - start) / (double) 1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
