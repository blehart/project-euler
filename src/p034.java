/**
 * Created by Robert on 5/10/2017.
 */
public class p034 {

    public p034(){
        int result = 0;
        for (int i = 3; i < 10000000; i++){
            int sum = 0;
            int temp = i;
            while (temp != 0){
                sum += Operations.factorial(temp % 10);
                temp /= 10;
            }
            if (sum == i){
                result += i;
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args){
        long start = System.nanoTime();
        new p034();
        double end = (System.nanoTime() - start)/(double)1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
