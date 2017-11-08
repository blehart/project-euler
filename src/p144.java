/**
 * Created by Robert on 6/12/2017.
 */
public class p144 {

    public p144() {
        int result = 0;
        double xA = 0.0, yA = 10.1;
        double xO = 1.4, yO = -9.6;


        while (xO > .01 || xO < -.01 || yO < 0){
            double sA = (yO - yA) / (xO - xA);
            double sO = -4*xO/yO;

            double tanA = (sA - sO)/(1+sA*sO);
            double sB = (sO- tanA)/ (1+ tanA*sO);

            double iB = yO - sB * xO;

            double a = 4 + sB * sB;
            double b = 2 * sB * iB;
            double c = iB * iB - 100;

            double ans1 = (-b + Math.sqrt(b * b - 4 * a * c)) / (2 * a);
            double ans2 = (-b - Math.sqrt(b * b - 4 * a * c)) / (2 * a);

            xA = xO;
            yA = yO;

            xO = (Math.abs(ans1 - xO) > Math.abs(ans2 - xO)) ? ans1 : ans2;
            yO = sB * xO + iB;

            result++;
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        new p144();
        double end = (System.nanoTime() - start) / (double) 1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
