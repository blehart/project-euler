/**
 * Created by Robert on 5/10/2017.
 */
public class p030 {

    public p030(){
        int result = 0;
        for (int i = 2; i < 1000000; i++) {
            int temp = i;
            int sum = 0;
            while (temp != 0) {
                sum += Math.pow(temp % 10, 5);
                temp /= 10;
            }
            if (i == sum){
                result += sum;
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args){
        long start = System.nanoTime();
        new p030();
        double end = (System.nanoTime() - start)/(double)1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
