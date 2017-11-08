/**
 * Created by Robert on 5/13/2017.
 */
public class p071 {

    public p071(){
        long n = 3;
        long d = 7;
        long resN = 0;
        long resD = 1;
        long lowBound = 2;
        for (int i = 1000000; i >= lowBound; i--){
            long p = (n * i - 1) / d;
            if (p * resD > i * resN) {
                resD = i;
                resN = p;
                lowBound = resD / (n * resD - d * resN);
            }
        }
        long factor = Operations.GCD(resN, resD);
        resN /= factor;

        System.out.println(resN);
    }

    public static void main(String[] args){
        long start = System.nanoTime();
        new p071();
        double end = (System.nanoTime() - start)/(double)1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
