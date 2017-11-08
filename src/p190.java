/**
 * Created by Robert on 6/4/2017.
 */
public class p190 {

    public long P(int x){
        double k = 2.0 / (x+1);
        double result = 1;
        for (int i = 1; i < x+1; i++){
            result *= Math.pow(i*k, i);
        }
        return (long)result;
    }

    public p190() {
        long result = 0;
        for (int i = 2; i <= 15; i++){
            result += P(i);
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        new p190();
        double end = (System.nanoTime() - start) / (double) 1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
