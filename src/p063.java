import java.math.BigInteger;

/**
 * Created by Robert on 5/12/2017.
 */
public class p063 {

    public p063(){
        int result = 0;
        for (int i = 0; i < 22; i++){
            for (int j = 1; j < 10; j++){
                BigInteger x = (BigInteger.valueOf(j)).pow(i);
                if (x.toString().length() == i) result++;
                else if (x.toString().length() > i) break;
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args){
        long start = System.nanoTime();
        new p063();
        double end = (System.nanoTime() - start)/(double)1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
