/**
 * Created by Robert on 5/14/2017.
 */
public class p072 {

    public p072(){
        int[] numbers = new int[1000001];
        for (int i = 0; i < 1000001; i++){
            numbers[i] = i;
        }
        long result = 0;
        for (int i = 2; i <= 1000000; i++){
            if (numbers[i] == i){
                for (int j = i; j < 1000001; j += i){
                    numbers[j] = numbers[j] / i * (i - 1);
                }
            }
            result += numbers[i];
        }
        System.out.println(result);
    }

    public static void main(String[] args){
        long start = System.nanoTime();
        new p072();
        double end = (System.nanoTime() - start)/(double)1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
