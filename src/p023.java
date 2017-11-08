import java.util.HashSet;

/**
 * Created by Robert on 5/9/2017.
 */
public class p023 {

    HashSet<Integer> abundants;

    public p023(){
        abundants = new HashSet<>();
        for (int i = 12; i < 28123; i++){
            int result = 0;
            for (int j = 1; j <= Math.sqrt(i); j++){
                if (i % j == 0){
                    result += j + (i / j);
                }
                if (j == Math.sqrt(i)){ // if number is a square, we added j twice
                    result -= j;
                }
            }
            if (result-i > i){
                abundants.add(i);
            }
        }
        long result = 0;
        boolean flag;
        for (int i = 1; i <= 28123; i++){
            flag = false;
            for (Integer j : abundants){
                if (abundants.contains(i-j)){
                    flag = true;
                    break;
                }
            }
            if (!flag){
                result += i;
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args){
        long start = System.nanoTime();
        new p023();
        double end = (System.nanoTime() - start)/(double)1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
