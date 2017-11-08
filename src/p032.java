import java.util.HashSet;

/**
 * Created by Robert on 5/10/2017.
 */
public class p032 {

    public boolean pandigital(int x, int y){
        int product = x * y;
        String xs = Integer.toString(x);
        String ys = Integer.toString(y);
        String ps = Integer.toString(product);
        if (xs.length() + ys.length() + ps.length() != 9) return false;
        HashSet<Character> hs = new HashSet<>();
        for (int i = 0; i < xs.length(); i++){
            hs.add(xs.charAt(i));
        }
        for (int i = 0; i < ys.length(); i++){
            hs.add(ys.charAt(i));
        }
        for (int i = 0; i < ps.length(); i++){
            hs.add(ps.charAt(i));
        }
        for (int i = 1; i < 10; i++){
            if (!hs.contains((char)(i+'0'))) return false;
        }
        return true;
    }

    public p032(){
        HashSet<Integer> products = new HashSet<>();
        for (int i = 1; i < 10000; i++){
            for (int j = 1; j < 10000; j++){
                if (pandigital(i, j)){
                    products.add(i * j);
                }
            }
        }
        int result = 0;
        for (Integer i : products){
            result += i;
        }
        System.out.println(result);
    }

    public static void main(String[] args){
        long start = System.nanoTime();
        new p032();
        double end = (System.nanoTime() - start)/(double)1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
