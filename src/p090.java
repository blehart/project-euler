import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Robert on 5/16/2017.
 */
public class p090 {

    public boolean validCubes(HashSet x, HashSet y) {
        boolean x0 = x.contains(0), x1 = x.contains(1), x2 = x.contains(2), x3 = x.contains(3), x4 = x.contains(4),
                x5 = x.contains(5), x6 = x.contains(6), x8 = x.contains(8), x9 = x.contains(9);
        boolean y0 = y.contains(0), y1 = y.contains(1), y2 = y.contains(2), y3 = y.contains(3), y4 = y.contains(4),
                y5 = y.contains(5), y6 = y.contains(6), y8 = y.contains(8), y9 = y.contains(9);

        if (x6 || x9) {
            x6 = true;
            x9 = true;
        }
        if (y6 || y9) {
            y6 = true;
            y9 = true;
        }

        return (((x0 && y1) || (y0 && x1)) &&
                ((x0 && y4) || (y0 && x4)) &&
                ((x0 && y9) || (y0 && x9)) &&
                ((x1 && y6) || (y1 && x6)) &&
                ((x2 && y5) || (y2 && x5)) &&
                ((x3 && y6) || (y3 && x6)) &&
                ((x4 && y9) || (y4 && x9)) &&
                ((x6 && y4) || (y6 && x4)) &&
                ((x8 && y1) || (y8 && x1)));
    }

    public p090() {

        HashSet<HashSet<Integer>> cubes = new HashSet<>();
        List<Integer> digits = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);

        for (int i = 0; i < 7; i++){
            for (int j = i+1; j < 8; j++){
                for (int k = j+1; k < 9; k++){
                    for (int m = k+1; m < 10; m++){
                        HashSet<Integer> cube = new HashSet<Integer>(digits);
                        cube.remove(i);
                        cube.remove(j);
                        cube.remove(k);
                        cube.remove(m);
                        cubes.add(cube);
                    }
                }
            }
        }
        int result = 0;
        for (HashSet<Integer> cube1 : cubes){
            for (HashSet<Integer> cube2 : cubes){
                if (validCubes(cube1, cube2)) result++;
            }
        }
        System.out.println(result/2);
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        new p090();
        double end = (System.nanoTime() - start) / (double) 1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
