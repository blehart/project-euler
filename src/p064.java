/**
 * Created by Robert on 5/12/2017.
 */
public class p064 {

    public p064(){
        int result = 0;
        for (int i = 2; i <= 10000; i++){
            double j = Math.sqrt(i);
            if (j == (long)j) continue;
            if (Operations.period(i).size() % 2 == 0){
                result++;
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args){
        long start = System.nanoTime();
        new p064();
        double end = (System.nanoTime() - start)/(double)1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
