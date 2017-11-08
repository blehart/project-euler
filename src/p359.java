import java.math.BigInteger;

/**
 * Created by Robert on 6/12/2017.
 */
public class p359 {

    /*
    Hardest problem solved without any help.
    Used brute force for the first 10000, looked for pattern at each floor.
    Was able to find an equation for each floor using Wolfram.
    Found a pattern in the equations and made a general equation for all floors except for the first.
     */
    public long P(long lf, long lr){
        BigInteger f = BigInteger.valueOf(lf), r = BigInteger.valueOf(lr);
        BigInteger TWO = BigInteger.valueOf(2), THREE = BigInteger.valueOf(3), HUNDMIL = BigInteger.valueOf(100000000);

        if (f.equals(BigInteger.ONE))     return r.pow(2).add(r).divide(TWO).mod(HUNDMIL).longValue();  //(r*r + r)/2;
        if (f.getLowestSetBit() != 0){ //(r*r + (2*f-1)*r + f*(int)Math.pow(-1, r) + f * (f-1))/2;
            if (r.getLowestSetBit() != 0) return r.pow(2).add(f.multiply(TWO).subtract(BigInteger.ONE).multiply(r)).add(f)     .add(f.multiply(f.subtract(BigInteger.ONE))).divide(TWO).mod(HUNDMIL).longValue();
            else                          return r.pow(2).add(f.multiply(TWO).subtract(BigInteger.ONE).multiply(r)).subtract(f).add(f.multiply(f.subtract(BigInteger.ONE))).divide(TWO).mod(HUNDMIL).longValue();
        }
        else { //(r*r + (2*f-3)*r - (f-1)*(int)Math.pow(-1, r) + (f-1) * (f-2))/2;
            if (r.getLowestSetBit() != 0) return r.pow(2).add(f.multiply(TWO).subtract(THREE).multiply(r)).subtract(f.subtract(BigInteger.ONE)).add(f.subtract(BigInteger.ONE).multiply(f.subtract(TWO))).divide(TWO).mod(HUNDMIL).longValue();
            else                          return r.pow(2).add(f.multiply(TWO).subtract(THREE).multiply(r)).add     (f.subtract(BigInteger.ONE)).add(f.subtract(BigInteger.ONE).multiply(f.subtract(TWO))).divide(TWO).mod(HUNDMIL).longValue();
        }
    }

    public p359() {
        long result = 0;
        long goal = 71328803586048L;

        for (int two = 0; two <= 27; two++){
            for (int thr = 0; thr <= 12; thr++){
                long value = (long)Math.pow(2, two) * (long)Math.pow(3, thr);
                result = (result + P(value, goal/value)) % 100000000;
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        new p359();
        double end = (System.nanoTime() - start) / (double) 1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
