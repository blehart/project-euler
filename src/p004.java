/**
 * Created by Robert on 5/8/2017.
 */
public class p004 {

    public p004(){
        int result = 0;
        for (int i = 999; i >= 0; i--){
            for (int j = 999; j >= 0; j--){
                if (Operations.isPalindrome(Integer.toString(i * j))){
                    if (i*j > result){
                        result = i * j;
                    }
                }
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args){
        long start = System.nanoTime();
        new p004();
        double end = (System.nanoTime() - start)/(double)1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
