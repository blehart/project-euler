import java.math.BigInteger;

/**
 * Created by Robert on 5/27/2017.
 */
public class p111 {

    int[] number = new int[10];

    public long check(){
        if (number[0] == 0) return 0;
        long n = 0;
        for (int a : number) {
            n = n * 10 + a;
        }
        return BigInteger.valueOf(n).isProbablePrime(20) ? n : 0;
    }

    public long rec(int base, int start, int level){
        return rec(base, start, level, false);
    }

    public long rec(int base, int start, int level, boolean fill){
        if (level <= 0) return check();
        long res = 0;
        if (fill){
            for (int pos = 0; pos < number.length; pos++){
                number[pos] = base;
            }
        }
        for (int pos = start; pos < number.length; pos++){
            for (int val = 0; val < 10; val++){
                number[pos] = val;
                res += rec(base, pos+1, level-1);
                number[pos] = base;
            }
        }
        return res;
    }

    public p111() {
        long result = 0;
        for (int d = 0; d < 10; d++){
            for (int i = 1; i < number.length; i++){
                long sum = rec(d, 0, i, true);
                if (sum > 0){
                    result += sum;
                    break;
                }
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        new p111();
        double end = (System.nanoTime() - start) / (double) 1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
