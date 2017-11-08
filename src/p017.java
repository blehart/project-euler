/**
 * Created by Robert on 5/9/2017.
 */
public class p017 {

    public p017() {
        int one_9 = "onetwothreefourfivesixseveneightnine".length();
        int ten_19 = "teneleventwelvethirteenfourteenfifteensixteenseventeeneighteennineteen".length();
        int and = "and".length();
        int twenty_90 = "twentythirtyfortyfiftysixtyseventyeightyninety".length();
        int hundred = "hundred".length();
        int thousand = "onethousand".length();

        System.out.println(thousand + // thousands place
                900 * hundred + 891 * and + 100 * one_9 + // hundreds place
                100 * twenty_90 + 10 * ten_19 + // tens place: 10 per hundred / 1 per hundred
                90 * one_9); // one place: 9 per hundred

    }

    public static void main(String[] args){
        long start = System.nanoTime();
        new p017();
        double end = (System.nanoTime() - start)/(double)1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
