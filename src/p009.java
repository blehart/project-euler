/**
 * Created by Robert on 5/8/2017.
 */
public class p009 {

    public p009(){
        for (int a = 1; a < 1000; a++){
            for (int b = 1; b < 1000; b++){
                if (a + b + Math.sqrt(a*a + b*b) == 1000){
                    System.out.println(a * b * (int)Math.sqrt(a*a + b*b));
                    return;
                }
            }
        }
    }

    public static void main(String[] args){
        long start = System.nanoTime();
        new p009();
        double end = (System.nanoTime() - start)/(double)1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
