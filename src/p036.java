/**
 * Created by Robert on 5/10/2017.
 */
public class p036 {

    public p036(){
        int result = 0;
        for (int i = 0; i < 1000000; i++){
            if (Operations.isPalindrome(Integer.toString(i)) && Operations.isPalindrome(Integer.toBinaryString(i))){
                result += i;
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args){
        long start = System.nanoTime();
        new p036();
        double end = (System.nanoTime() - start)/(double)1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
