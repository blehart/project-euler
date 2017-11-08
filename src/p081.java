import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Robert on 5/15/2017.
 */
public class p081 {

    int[][] grid;
    final int size = 80;

    public void minPath(){
        for (int i = size - 2; i >= 0; i--) {
            grid[size - 1][i] += grid[size - 1][i+1]; // bottom row
            grid[i][size - 1] += grid[i+1][size - 1]; // right column
        }

        for (int i = size - 2; i >= 0; i--) {
            for (int j = size - 2; j >= 0; j--) {
                grid[i][j] += Math.min(grid[i + 1][j], grid[i][j + 1]);  // starting at right col, we solve each col, bottom up
            }
        }
    }

    public p081(){
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
            minPath();
            System.out.println(grid[0][0]);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        long start = System.nanoTime();
        new p081();
        double end = (System.nanoTime() - start)/(double)1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
