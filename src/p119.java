import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Robert on 5/23/2017.
 */
public class p119 {

    public p119() {
        List<BigInteger> possibles = new ArrayList<>();

        for (int i = 2; i < 69; i++){
            BigInteger bi = BigInteger.valueOf(i);
            BigInteger x = bi;
            for (int j = 2; j < 9; j++){
                x = x.multiply(bi);

                if (Operations.sumDigits(x) == i){
                    possibles.add(x);
                }
            }
        }

        Collections.sort(possibles);
        System.out.println(possibles.get(29));
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        new p119();
        double end = (System.nanoTime() - start) / (double) 1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
