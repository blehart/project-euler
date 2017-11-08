/**
 * Created by Robert on 5/16/2017.
 */
public class p092 {

    final int max = 10000000;

    public int squareDigits(int x){
        int result = 0;
        while (x != 0){
            result += (int)Math.pow(x%10, 2);
            x /= 10;
        }
        return result;
    }

    public p092() {
        int result = 0;
        int[] cache = new int[max];
        for (int i = 2; i < max; i++){
            int temp = i;
            while (temp != 1 && temp != 89){
                temp = squareDigits(temp);
                if (cache[temp] != 0) temp = cache[temp];
            }
            cache[i] = temp;
            if (temp == 89) result++;
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        new p092();
        double end = (System.nanoTime() - start) / (double) 1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
