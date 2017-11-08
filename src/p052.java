import java.util.Arrays;

/**
 * Created by Robert on 5/11/2017.
 */
public class p052 {

    public boolean sameDigits(int number, int maxMulti){
        char[] c1 = String.valueOf(number).toCharArray();
        Arrays.sort(c1);
        for (int i = 2; i <= maxMulti; i++) {
            char[] c2 = String.valueOf(number * i).toCharArray();
            Arrays.sort(c2);
            if (!Arrays.equals(c1, c2)) return false;
        }
        return true;
    }

    public p052(){
        for (int i = 1;;i++){
            if (sameDigits(i, 6)) {
                System.out.println(i);
                break;
            }
        }
    }

    public static void main(String[] args){
        long start = System.nanoTime();
        new p052();
        double end = (System.nanoTime() - start)/(double)1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
