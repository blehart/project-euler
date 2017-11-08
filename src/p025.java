import java.math.BigInteger;

/**
 * Created by Robert on 5/9/2017.
 */
public class p025 {

    public p025(){
        BigInteger x = new BigInteger("1");
        BigInteger y = new BigInteger("1");

        int index = 2;

        while (x.toString().length() < 1000){
            BigInteger temp = x;
            x = x.add(y);
            y = temp;
            index++;
        }
        System.out.println(index);
    }

    public static void main(String[] args){
        long start = System.nanoTime();
        new p025();
        double end = (System.nanoTime() - start)/(double)1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
