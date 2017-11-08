/**
 * Created by Robert on 5/8/2017.
 */
public class p002 {
    public p002(){
        int x = 2;
        int y = 1;
        int result = 2;
        while (x < 4000000){
            int temp = y;
            y = x;
            x += temp;
            if (x%2==0){
                result += x;
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args){
        long start = System.nanoTime();
        new p002();
        double end = (System.nanoTime() - start)/(double)1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
