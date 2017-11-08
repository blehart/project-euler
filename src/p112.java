/**
 * Created by Robert on 5/23/2017.
 */
public class p112 {

    public boolean isBouncy(int x) {

        boolean increase = false, decrease = false;
        int temp = x;
        int prev = x % 10;
        while (temp != 0) {
            int cur = temp % 10;
            if (cur < prev) increase = true;
            if (cur > prev) decrease = true;
            prev = cur;
            temp /= 10;

            if (increase && decrease) return true;
        }
        return false;
    }

    public p112() {
        int bouncy = 0;
        int i = 100;
        while(bouncy * 100 < i * 99){
            i++;
            if (isBouncy(i)) bouncy++;
        }
        System.out.println(i);
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        new p112();
        double end = (System.nanoTime() - start) / (double) 1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
