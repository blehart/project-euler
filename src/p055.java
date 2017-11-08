import java.math.BigInteger;

/**
 * Created by Robert on 5/11/2017.
 */
public class p055 {

    public p055(){
        int result = 0;
        for (int i = 1; i < 10000; i++){
            BigInteger x = BigInteger.valueOf(i);
            boolean flag = false;
            for (int j = 0; j < 50; j++){
                BigInteger y = new BigInteger(new StringBuilder(x.toString()).reverse().toString());
                if (Operations.isPalindrome(x.add(y).toString())){
                    flag = true;
                    break;
                }
                x = x.add(y);
            }
            if (!flag) result++;
        }
        System.out.println(result);
    }

    public static void main(String[] args){
        long start = System.nanoTime();
        new p055();
        double end = (System.nanoTime() - start)/(double)1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
