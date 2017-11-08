/**
 * Created by Robert on 6/3/2017.
 */
public class p235 {

    public double u(int k, double r){
        return (900 - 3 * k) * Math.pow(r, k-1);
    }

    public double s(int n, double r){
        double result = 0;
        for (int k = 1; k <= n; k++){
            result += u(k, r);
        }
        return result;
    }

    public p235() {
        double r = 1, x = .1, target = -600000000000.0;
        for (int j = 1; j <= 13; j++){
            for (int i = 1; i < 10; i++){
                if (s(5000, r + x * i) < target){
                    r += x * (i - 1);
                    break;
                }
            }
            x /= 10;
        }
        System.out.printf("%.12f\n", r);
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        new p235();
        double end = (System.nanoTime() - start) / (double) 1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
