/**
 * Created by Robert on 5/14/2017.
 */
public class p076 {

    public p076(){
        int[] ways = new int[101];
        ways[0] = 1;

        for (int i = 1; i <= 99; i++) {
            for (int j = i; j <= 100; j++) {
                ways[j] += ways[j - i];
            }
        }
        System.out.println(ways[100]);
    }

    public static void main(String[] args){
        long start = System.nanoTime();
        new p076();
        double end = (System.nanoTime() - start)/(double)1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
