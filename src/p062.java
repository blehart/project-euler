import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by Robert on 5/12/2017.
 */
public class p062 {

    public p062(){
        HashMap<String, Integer> sortedCubes = new HashMap<>();
        for (int i = 10000; i > 0; i--) {
            BigInteger cube = (BigInteger.valueOf(i)).pow(3);
            char[] chars = cube.toString().toCharArray();
            Arrays.sort(chars);
            String s = new String(chars);
            if (sortedCubes.containsKey(s)) {
                sortedCubes.put(s, sortedCubes.get(s) + 1);
                if (sortedCubes.get(s) == 5) {
                    System.out.println(cube);
                }
            } else {
                sortedCubes.put(s, 1);
            }
        }
    }

    public static void main(String[] args){
        long start = System.nanoTime();
        new p062();
        double end = (System.nanoTime() - start)/(double)1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
