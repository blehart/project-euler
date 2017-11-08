/**
 * Created by Robert on 5/10/2017.
 */
public class p040 {

    public p040(){
        StringBuilder s = new StringBuilder();
        for (int i = 1; s.length() <= 1000000; i++){
            s.append(Integer.toString(i));
        }
        int result = 1;
        for (int i = 1; i <= 1000000; i *= 10){
            result *= Character.getNumericValue(s.charAt(i-1));
        }
        System.out.println(result);
    }

    public static void main(String[] args){
        long start = System.nanoTime();
        new p040();
        double end = (System.nanoTime() - start)/(double)1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
