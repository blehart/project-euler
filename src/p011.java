import java.io.FileReader;
import java.util.Scanner;

/**
 * Created by Robert on 5/8/2017.
 */
public class p011 {

    public p011(){
        try {
            int result = 0;
            Scanner sc = new Scanner(new FileReader("p011.txt"));
            int[][] grid = new int[20][20];
            for (int i = 0; i < 20; i++) {
                for (int j = 0; j < 20; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }
            for (int i = 0; i < 20; i++){
                for (int j = 0; j < 20; j++){
                    if (i < 17){
                        int t1 = grid[i][j] * grid[i+1][j] * grid[i+2][j] * grid[i+3][j];
                        result = Math.max(result, t1);
                    }
                    if (j < 17){
                        int t2 = grid[i][j] * grid[i][j+1] * grid[i][j+2] * grid[i][j+3];
                        result = Math.max(result, t2);
                    }
                    if (i < 17 && j < 17){
                        int t3 = grid[i][j] * grid[i+1][j+1] * grid[i+2][j+2] * grid[i+3][j+3];
                        result = Math.max(result, t3);
                    }
                    if (i > 2 && j < 17){
                        int t4 = grid[i][j] * grid[i-1][j+1] * grid[i-2][j+2] * grid[i-3][j+3];
                        result = Math.max(result, t4);
                    }

                }
            }
            System.out.println(result);
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        long start = System.nanoTime();
        new p011();
        double end = (System.nanoTime() - start)/(double)1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
