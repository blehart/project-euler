/**
 * Created by Robert on 5/9/2017.
 */
public class p014 {
    public p014(){
        int result = 0;
        int max = 0;
        for (int i = 1; i < 1000000; i++) {
            int count = 0;
            long x = i;
            while (x != 1) {
                if (x % 2 == 0) {
                    x /= 2;
                } else {
                    x = (x * 3) + 1;
                }
                count++;
            }
            if (count > max){
                max = count;
                result = i;
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args){
        long start = System.nanoTime();
        new p014();
        double end = (System.nanoTime() - start)/(double)1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
