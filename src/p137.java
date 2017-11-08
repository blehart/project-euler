/**
 * Created by Robert on 5/29/2017.
 */
public class p137 {

    /*
    Binet's Formula for nth Fibonacci number f(n) = (x^n - y^n)/sqrt5
    x = (1+sqrt5)/2, y = (1-sqrt5)/2
    Golden Nuggets = f(2k)*f(2k+1)
    15th golden nugget = f(30)*f(31)
     */

    public p137() {
        double sqrt5 = Math.sqrt(5);
        long result = (long)(((Math.pow((1+sqrt5)/2, 30) - Math.pow((1-sqrt5)/2, 30))/sqrt5) * ((Math.pow((1+sqrt5)/2, 31) - Math.pow((1-sqrt5)/2, 31))/sqrt5));
        System.out.println(result);
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        new p137();
        double end = (System.nanoTime() - start) / (double) 1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
