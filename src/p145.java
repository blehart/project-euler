/**
 * Created by Robert on 5/24/2017.
 */
public class p145 {

    public long reverse(long x){
        long reverse = 0;
        while (x != 0){
            reverse = reverse * 10 + (x % 10);
            x /= 10;
        }
        return reverse;
    }

    public boolean allOddDigits(long x){
        while (x != 0){
            if ((x%10)%2 == 0) return false;
            x /= 10;
        }
        return true;
    }

    public p145() {
        long result = 0;
        long limit = 50000000L; //(long)Math.pow(10, 9);
        for (int i = 10; i < limit; i++){
            long reverse = reverse(i);
            if (reverse%10 < i%10 && Operations.numDigits(i) == Operations.numDigits(reverse) && allOddDigits(i + reverse)){
                //System.out.println(i + " " + reverse);
                result += 2;
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        new p145();
        double end = (System.nanoTime() - start) / (double) 1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
