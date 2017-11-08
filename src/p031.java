/**
 * Created by Robert on 5/10/2017.
 */
public class p031 {

    int[] coins = {200, 100, 50, 20, 10, 5, 2, 1};

    public int findCombos(int total, int max){
        int sum = 0;
        if (max == 7) return 1;
        for (int i = max;i < 8; i++){
            if (total - coins[i] == 0) sum++;
            if (total - coins[i] > 0) sum += findCombos(total - coins[i], i);
        }
        return sum;
    }

    public p031() {
        System.out.println(findCombos(200, 0));
    }

    public static void main(String[] args){
        long start = System.nanoTime();
        new p031();
        double end = (System.nanoTime() - start)/(double)1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
