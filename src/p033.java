/**
 * Created by Robert on 5/10/2017.
 */
public class p033 {

    public double canceling(int x, int y){
        String xs = Integer.toString(x);
        String ys = Integer.toString(y);
        double i = 0;
        if (xs.charAt(0) == ys.charAt(1)){
            return (double)Character.getNumericValue(xs.charAt(1)) / Character.getNumericValue(ys.charAt(0));
        }
        if (xs.charAt(1) == ys.charAt(0)){
            if (ys.charAt(1) == '0') return 0;
            return (double)Character.getNumericValue(xs.charAt(0)) / Character.getNumericValue(ys.charAt(1));
        }
        return 0;
    }

    public p033(){
        int resultNumer = 1, resultDenom = 1;
        for (double n = 10; n < 100; n++){
            for (double d = n + 1; d < 100; d++){
                double i = canceling((int)n, (int)d);
                if (i == n / d){
                    resultNumer *= n;
                    resultDenom *= d;
                }
            }
        }
        System.out.println(resultDenom / Operations.GCD(resultNumer, resultDenom));
    }

    public static void main(String[] args){
        long start = System.nanoTime();
        new p033();
        double end = (System.nanoTime() - start)/(double)1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
