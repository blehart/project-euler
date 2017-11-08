/**
 * Created by Robert on 5/24/2017.
 */
public class p122 {

    int[] cost;
    int[] path;
    int limit = 200;

    public void backTrack(int power, int depth){
        if (power > limit || depth > cost[power]) return;
        cost[power] = depth;
        path[depth] = power;
        for (int i = depth; i >= 0; i--){
            backTrack(power + path[i], depth+1);
        }
    }

    public p122() {

        cost = new int[limit+1];
        path = new int[limit+1];
        int result = 0;

        for (int i = 0; i <= limit; i++) {
            cost[i] = Integer.MAX_VALUE;
        }

        backTrack(1, 0);

        for (int i = 1; i <= limit; i++) {
            result += cost[i];
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        new p122();
        double end = (System.nanoTime() - start) / (double) 1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
