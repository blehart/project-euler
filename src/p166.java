/**
 * Created by Robert on 6/15/2017.
 */
public class p166 {

    public boolean increment(int[] num){
        int i = 0;
        while (num[i] == 9){
            num[i] = 0;
            i++;
            if (i == num.length) return false;
        }
        num[i]++;
        return true;
    }

    public p166() {
        int result = 0;
        int[] num = new int[8];
        do {
            int a = num[0], b = num[1], c = num[2], d = num[3], e = num[4], g = num[5], i = num[6], k = num[7];
            int m = b+c+d-e-i;      if (m < 0 || 9 < m) continue;
            int o = a+b+d-g-k;      if (o < 0 || 9 < o) continue;
            int j = a+b+c-g-m;      if (j < 0 || 9 < j) continue;
            int l = a+b+c+d-i-j-k;  if (l < 0 || 9 < l) continue;
            int f = b+c+d*2-e-i-k;  if (f < 0 || 9 < f) continue;
            int h = a+b+c+d-e-f-g;  if (h < 0 || 9 < h) continue;
            int n = a+c+d-f-j;      if (n < 0 || 9 < n) continue;
            int p = a+b+c-h-l;      if (p < 0 || 9 < p) continue;
            result++;
        } while (increment(num));
        System.out.println(result);
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        new p166();
        double end = (System.nanoTime() - start) / (double) 1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
