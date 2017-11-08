import java.math.BigInteger;

/**
 * Created by Robert on 5/22/2017.
 */
public class p104 {

    public p104() {

        BigInteger x = BigInteger.ONE;
        BigInteger y = BigInteger.ONE;
        BigInteger tenDigits = BigInteger.valueOf(1000000000);
        int i = 3;

        while (true) {
            BigInteger temp = x.add(y);
            y = x;
            x = temp;

            if (Operations.isPandigital(x.mod(tenDigits).longValue())){
                int digits = Operations.log10(x) + 1;
                if (digits >= 9 &&
                    Operations.isPandigital(x.divide(BigInteger.TEN.pow(digits - 9)).longValue())) break;
            }
            i++;
        }
        System.out.println(i);

    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        new p104();
        double end = (System.nanoTime() - start) / (double) 1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
