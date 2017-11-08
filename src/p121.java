/**
 * Created by Robert on 5/23/2017.
 */
public class p121 {

    public p121() {

        int rds = 15;
        double[][] odds = new double[rds+2][rds+1];
        for (int i = 0; i < rds + 2; i++){
            for (int j = 0; j < rds + 1; j++) {
                odds[i][j] = 0;
            }
        }
        odds[2][0] = .5;
        odds[2][1] = .5;

        for (int i = 2; i <= rds; i++){
            for (int j = 0; j < i; j++){
                odds[i+1][j] += odds[i][j] * (i / (i+1.0));
                odds[i+1][j+1] += odds[i][j] * (1.0 / (i+1));
            }
        }

        double odd = 0;
        for (int i = rds/2+1; i <= rds; i++) {
            odd += odds[rds+1][i];
        }

        int i = 2;
        while (odd * i < 1) i++;
        System.out.println(i-1);
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        new p121();
        double end = (System.nanoTime() - start) / (double) 1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
