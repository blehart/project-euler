/**
 * Created by Robert on 5/11/2017.
 */
public class p045 {

    // Triangle numbers are a subset of hexagonal numbers
    public boolean isPentagonal(long x){
        double n = (1 + Math.sqrt(24*x+1)) / 6;
        return n == (long)n;
    }

    public p045(){
        long H = 0;   // hex number
        long i = 144; // hex index

        while(true){
            H = i * ((i << 1)-1);
            if (isPentagonal(H)) break;
            i++;
        }
        System.out.println(H);
    }

    public static void main(String[] args){
        long start = System.nanoTime();
        new p045();
        double end = (System.nanoTime() - start)/(double)1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
