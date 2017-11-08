/**
 * Created by Robert on 5/30/2017.
 */
public class p206 {

    /*
    All potential i will end with 30/70
     */
    public p206() {

        long i = 1010101030;  // sqrt of the smallest number of the given form, rounding up to end with 30/70;
        while (true){
            long square = i*i;
            square /= 10000;
            int j = 8;
            while (true) {
                if (square % 10 == j) {
                    square /= 100;
                    j--;
                    if (j == 0){
                        System.out.println(i);
                        return;
                    }
                } else break;
            }
            if (i % 100 == 30) i+=40;
            else i+=60;
        }
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        new p206();
        double end = (System.nanoTime() - start) / (double) 1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
