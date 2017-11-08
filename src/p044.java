import java.util.HashSet;

/**
 * Created by Robert on 5/10/2017.
 */
public class p044 {

    public p044(){
        long result = Integer.MAX_VALUE;
        HashSet<Long> set = new HashSet<>();
        for (int i = 1; i < 10000; i++){
            set.add((i * (3 * i - 1))/2L);
        }

        for (Long i : set){
            for (Long j : set){
                if (set.contains(i - j) && set.contains(i + j)){
                    result = Math.min(result, Math.abs(i - j));
                }
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args){
        long start = System.nanoTime();
        new p044();
        double end = (System.nanoTime() - start)/(double)1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
