/**
 * Created by Robert on 6/8/2017.
 */
public class p171 {

    public p171() {

        int length = 20, max = 9 * 9 * length, mod = (int)Math.pow(10, 9);
        long[][] sum = new long[length+1][max+1], count = new long[length+1][max+1];
        count[0][0] = 1;

        for (int i = 1; i <= length; i++){
            for (int j = 0; j < 10; j++){
                for (int k = 0; k + j * j <= max; k++){
                    sum[i][k+j*j] = (sum[i][k+j*j] + sum[i-1][k] + Operations.modPow(10, i-1, mod) * j % mod * count[i-1][k]) % mod;
                    count[i][k+j*j] = (count[i][k+j*j] + count[i-1][k]) % mod;
                }
            }
        }
        long result = 0;
        for (int i = 1; i *i <= max; i++){
            result = (result + sum[length][i*i]) % mod;
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        new p171();
        double end = (System.nanoTime() - start) / (double) 1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
