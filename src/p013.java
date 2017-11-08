import java.io.FileReader;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by Robert on 5/9/2017.
 */
public class p013 {

    public p013(){
        try {
            BigInteger result = new BigInteger("0");
            Scanner sc = new Scanner(new FileReader("p013.txt"));
            for (int i = 0; i < 100; i++) {
                result = result.add(new BigInteger(sc.nextLine()));
            }
            System.out.println(result.toString().substring(0, 10));
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        long start = System.nanoTime();
        new p013();
        double end = (System.nanoTime() - start)/(double)1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
