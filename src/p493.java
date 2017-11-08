import java.math.BigDecimal;

/**
 * Created by Robert on 5/31/2017.
 */
public class p493 {

    /*
     = 7 * probability specific color is present
     = 7 * (1 - probability specific color is absent)
     = 7 * (1 - (# ways to pick 20 avoiding specific color)/(# ways to pick 20))
     = 7 * (1 - (60 choose 20)/(70 choose 20))
     */
    public p493() {
        BigDecimal result = BigDecimal.valueOf(7)
                .multiply(BigDecimal.ONE
                        .subtract(new BigDecimal(Operations.nchoosek(60, 20))
                                .divide(new BigDecimal(Operations.nchoosek(70, 20)), 11, BigDecimal.ROUND_HALF_DOWN)))
                .setScale(9, BigDecimal.ROUND_HALF_DOWN);
        System.out.println(result);
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        new p493();
        double end = (System.nanoTime() - start) / (double) 1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
