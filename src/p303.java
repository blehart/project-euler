import java.util.ArrayList;
import java.util.List;

/**
 * Created by Robert on 6/6/2017.
 */
public class p303 {



    public boolean digits12(long x){
        while (x != 0){
            if (x % 10 > 2) return false;
            x /= 10;
        }
        return true;
    }

    public int[] next(int[] cur, int max){
        for (int i = cur.length-1; i >= 0; i--){
            cur[i]++;
            if (cur[i] <= max) break;
            cur[i] = 0;
            if (i == 0) return null;
        }
        return cur;
    }

    public long arrayToNum(int[] x){
        long result = 0;
        for (int ix : x) {
            result = result * 10 + ix;
        }
        return result;
    }

    public p303() {
        long result = 0;
        int limit = 10000;
        List<Long> listDigits12 = new ArrayList<>();
        int[] num = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1};
        while (num != null){
            listDigits12.add(arrayToNum(num));
            num = next(num, 2);
        }
        for (int n = 1; n <= limit; n++){
            if (n != 9999) {
                for (Long i : listDigits12) {
                    if (i % n == 0) {
                        result += i / n;
                        break;
                    }
                }
            } else {
                result += 1111333355557778L;  // this * 9999 = 111,222,222,222,222
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        new p303();
        double end = (System.nanoTime() - start) / (double) 1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
