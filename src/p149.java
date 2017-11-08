/**
 * Created by Robert on 6/4/2017.
 */
public class p149 {

    public p149() {
        long[][] table = new long[2000][2000];
        long[] s = new long[4000001];
        for (int k = 1; k <= 55; k++){
            s[k] = ((100003 - 200003*k + 300007L*k*k*k) % 1000000) - 500000;
        }
        for (int k = 56; k <= 4000000; k++){
            s[k] = ((s[k-24] + s[k-55] + 1000000) % 1000000) - 500000;
        }
        for (int k = 1; k <= 4000000; k++){
            int i = k-1;
            table[i/2000][i%2000] = s[k];
        }

        long max = 0;
        for (int i = 0; i < 2000; i++){
            // horizontal and vertial
            long rowTmp = 0, colTmp = 0;
            for (int j = 0; j < 2000; j++){
                rowTmp += table[i][j];
                if (rowTmp < 0) rowTmp = 0;
                else max = Math.max(max, rowTmp);

                colTmp += table[j][i];
                if (colTmp < 0) colTmp = 0;
                else max = Math.max(max, colTmp);
            }
            // diagonal and antidiagonal (one loop for bottom half, one for upper half)
            int rowd = i, cold = 0, rowa = i, cola = 1999;
            long diaTmp = 0, antidiaTmp = 0;
            for (int j = 0; j <= i; j++){
                diaTmp += table[rowd][cold];
                if(diaTmp < 0) diaTmp = 0;
                else max = Math.max(max, diaTmp);
                rowd--; cold++;

                antidiaTmp += table[rowa][cola];
                if (antidiaTmp < 0) antidiaTmp = 0;
                else max = Math.max(max, antidiaTmp);
                rowa--; cola--;
            }
            diaTmp = 0; antidiaTmp = 0;
            rowd = 1999; cold = i;
            rowa = 1999; cola = 1999;

            for (int j = 0; j <= 1999 - i; j++){
                diaTmp += table[rowd][cold];
                if(diaTmp < 0) diaTmp = 0;
                else max = Math.max(max, diaTmp);
                rowd--; cold++;

                antidiaTmp += table[rowa][cola];
                if (antidiaTmp < 0) antidiaTmp = 0;
                else max = Math.max(max, antidiaTmp);
                rowa--; cola--;
            }
        }
        System.out.println(max);
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        new p149();
        double end = (System.nanoTime() - start) / (double) 1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
