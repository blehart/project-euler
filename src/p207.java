/**
 * Created by Robert on 6/5/2017.
 */
public class p207 {

    /*
    4^t = 2^t + k
    4^t = 2^2t
    x = 2^t
    x^2 = x + k
     */
    public p207() {
        double target = 1/12345.0;
        double log2 = Math.log(2);

        for (int x = 2; x < 2000000; x++){
            double a = Math.floor(Math.log(x) / log2) / (x-1);
            if (a < target){
                System.out.println(x*(x-1L));
                break;
            }
        }
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        new p207();
        double end = (System.nanoTime() - start) / (double) 1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
