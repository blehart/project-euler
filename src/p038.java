import java.util.HashSet;

/**
 * Created by Robert on 5/10/2017.
 */
public class p038 {

    public int pandigital(int x){
        String s = "";
        for (int i = 1; s.length() < 9;i++){
            int temp = x * i;
            s = s.concat(Integer.toString(temp));
        }
        if (s.length() == 9){
            HashSet<Character> hs = new HashSet<>();
            for (int i = 0; i < 9; i++){
                hs.add(s.charAt(i));
            }
            if (hs.size() == 9 && !hs.contains('0')) return Integer.parseInt(s);
        }
        return 0;
    }

    public p038(){
        int result = 0;
        for (int i = 0; i < 10000; i++){
            result = Math.max(result, pandigital(i));
        }
        System.out.println(result);
    }

    public static void main(String[] args){
        long start = System.nanoTime();
        new p038();
        double end = (System.nanoTime() - start)/(double)1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
