import java.util.Arrays;

/**
 * Created by Robert on 5/22/2017.
 */
public class p103 {

    public int[] updateArray(int[] a, int min, int max) {
        for (int i = a.length - 1; i >= 0; i--) {
            if (a[i] != max) {
                for (int j = i + 1; j < a.length; j++) {
                    a[j] = min;
                }
                a[i]++;
                return a;
            }
        }
        return a;
    }

    public static int sumArray(int[] x){
        int result = 0;
        for (int i : x){
            result += i;
        }
        return result;
    }

    public static boolean rule2(int[] x){
        int sum1 = x[0];
        int sum2 = 0;

        for (int i = 0; i < x.length / 2; i++){
            sum1 += x[i+1];
            sum2 += x[x.length-i-1];

            if (sum1 <= sum2) return false;
        }
        return true;
    }

    public static int[] subsetSums(int[] x){
        int[] y = new int[(int)Math.pow(2, x.length)];
        for (int i = 1; i < y.length; i++){
            y[i] = subsetSum(x, i);
        }
        return y;
    }

    public static int subsetSum(int[] x, int m){
        int result = 0;
        for (int i = 0; i < x.length; i++){
            if ((m & 1) == 1){
                result += x[i];
            }
            m >>= 1;
        }
        return result;
    }

    public static boolean rule1(int[] x, int dim){
        for (int i = 0; i < x.length; i++){
            int k = i;
            while (k != -1){
                k++;
                if (k >= x.length) break;
                k = indexOf(x, x[i], k);
                if (k != -1 && (i & k) == 0) return false;
            }
        }
        return true;
    }

    public static int indexOf(int[] x, int y, int z){
        for (int i = z; i < x.length; i++){
            if (x[i] == y) return i;
        }
        return -1;
    }

    public p103() {
        int[] a = {20, 31, 38, 39, 40, 42, 45};
        int min = -3, max = 3;
        String result = "";

        int[] t = new int[a.length];
        int dim = a.length;
        int[] s;
        int[] c = new int[7];
        for (int i = 0; i < c.length; i++) {
            c[i] = min;
        }

        int tsum = 0;
        int tmin = Integer.MAX_VALUE;

        for (int i = 0; i < (int)Math.pow(max - min + 1, dim); i++){
            for (int j = 0; j < a.length; j++){
                t[j] = a[j] + c[j];
            }
            tsum = sumArray(t);
            if (tsum <= tmin){
                Arrays.sort(t);
                if (rule2(t)){
                    s = subsetSums(t);
                    if (rule1(s, dim)){
                        tmin = tsum;
                        result = "";
                        for (int k = 0; k < t.length; k++) {
                            result += t[k];
                        }
                    }
                }
            }
            c = updateArray(c, min, max);
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        new p103();
        double end = (System.nanoTime() - start) / (double) 1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
