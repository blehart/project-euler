import java.util.HashSet;

/**
 * Created by Robert on 5/10/2017.
 */
public class p029 {

    public p029(){
        HashSet<Double> terms = new HashSet<>();
        for (int a = 2; a <= 100; a++){
            for (int b = 2; b <= 100; b++){
                terms.add(Math.pow(a, b));
            }
        }
        System.out.println(terms.size());
    }

    public static void main(String[] args){
        long start = System.nanoTime();
        new p029();
        double end = (System.nanoTime() - start)/(double)1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
