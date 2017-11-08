/**
 * Created by Robert on 5/27/2017.
 */
public class p109 {

    public int nextDartThrow(int x, int multi){
        if (x == 20) return multi * 25;
        else return multi * (x + 1);
    }

    public p109() {
        int result = 0;
        for (int i = 2; i < 100; i++){
            for (int j = 0; j < 21; j++){
                int onescore = i - nextDartThrow(j, 2);
                result += onescore == 0 ? 1 : 0;
                if (onescore > 0) {
                    for (int k = 0; k < 62; k++) {
                        int twoscore = onescore - nextDartThrow(k / 3, k % 3 + 1);
                        result += twoscore == 0 ? 1 : 0;
                        if (twoscore > 0) {
                            for (int m = k; m < 62; m++) {
                                if (twoscore - nextDartThrow(m / 3, m % 3 + 1) == 0) result++;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        new p109();
        double end = (System.nanoTime() - start) / (double) 1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
