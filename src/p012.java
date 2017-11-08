/**
 * Created by Robert on 5/9/2017.
 */
public class p012 {

    public p012(){
        int j = 0, num = 0;
        for (int i = 1; num <= 500; i++){
            j += i;
            num = 0;
            for (int k = 1; k < Math.sqrt(j); k++){
                if (j%k==0){
                    num += 2;
                }
            }
        }
        System.out.println(j);
    }

    public static void main(String[] args){
        long start = System.nanoTime();
        new p012();
        double end = (System.nanoTime() - start)/(double)1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
