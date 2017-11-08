/**
 * Created by Robert on 5/8/2017.
 */
public class p001 {

    public p001(){
        int result = 0;
        for (int i = 3; i < 1000; i++){
            if (i%3==0 || i%5==0){
                result += i;
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args){
        long start = System.nanoTime();
        new p001();
        double end = (System.nanoTime() - start)/(double)1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
