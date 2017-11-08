/**
 * Created by Robert on 6/14/2017.
 */
public class p197 {

    public double f(double x){
        return (int)Math.pow(2, 30.403243784 - x*x) * 1e-9;
    }

    public double u(double n){
        return (n==0) ? -1 : f(u(n-1));
    }

    public p197() {

        int i = 0;
        while (Math.abs(u(i) - u(i+2)) > 1e-10) i += 51;  // Stop when it starts bouncing back/forth between same values
        System.out.println(u(i) + u(i+1));
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        new p197();
        double end = (System.nanoTime() - start) / (double) 1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
