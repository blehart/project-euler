import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * Created by Robert on 5/15/2017.
 */
public class p082 {

    int[][] grid;
    int[] solution;
    final int size = 80;

    public void rightLeftPath(){
        solution = new int[size];
        for (int i = 0; i < size; i++){
            solution[i] = grid[i][size-1];
        }
        for (int i = size - 2; i >= 0; i--) {
            solution[0] += grid[0][i];
            for (int j = 1; j < size; j++) {
                solution[j] = Math.min(solution[j - 1] + grid[j][i], solution[j] + grid[j][i]);
            }
            for (int j = size - 2; j >= 0; j--) {
                solution[j] = Math.min(solution[j], solution[j + 1] + grid[j][i]);
            }
        }
    }

    public p082(){
        grid = new int[size][size];
        try {
            BufferedReader br = new BufferedReader(new FileReader("p081_matrix.txt"));
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                for (int j = 0; j < row.length; j++) {
                    grid[i][j] = Integer.parseInt(row[j]);
                }
                i++;
            }
            rightLeftPath();
            System.out.println(Arrays.stream(solution).min().getAsInt());
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        long start = System.nanoTime();
        new p082();
        double end = (System.nanoTime() - start)/(double)1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
