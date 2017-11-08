/**
 * Created by Robert on 5/8/2017.
 */
public class p006 {

    public p006(){
        int sumSquares = 0;
        int squareSums = 0;

        for (int i = 1; i < 100; i++){
            sumSquares += i * i;
            squareSums += i;
        }
        squareSums *= squareSums;
        System.out.println(squareSums - sumSquares);
    }

    public static void main(String[] args){
        long start = System.nanoTime();
        new p006();
        double end = (System.nanoTime() - start)/(double)1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
