import java.math.BigInteger;

/**
 * Created by Robert on 5/9/2017.
 */
public class p026 {

    public int recurring(int x){
        for (int i = 1; i <= x; i++){
            BigInteger bi= new BigInteger("10");
            bi = bi.modPow(new BigInteger(Integer.toString(i)), new BigInteger(Integer.toString(x)));
            if (bi.equals(BigInteger.ONE)){
                return i;
            }
        }
        return 0;
    }

    public p026(){
        int max = 0;
        int result = 0;
        for (int i = 2; i < 1000; i++){
            int temp = recurring(i);
            if (temp > max){
                max = temp;
                result = i;
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args){
        long start = System.nanoTime();
        new p026();
        double end = (System.nanoTime() - start)/(double)1000000;
        System.out.println("\nSolved in " + end + " ms");
    }

}
