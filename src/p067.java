import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Robert on 5/13/2017.
 */
public class p067 {

    public p067(){
        try {
            int[][] triangle = new int[100][];
            BufferedReader br = new BufferedReader(new FileReader("p067_triangle.txt"));
            for (int i = 0; i < 100; i++) {
                triangle[i] = new int[i + 1];
                String line = br.readLine();
                Scanner sc = new Scanner(line);
                for (int j = 0; j <= i; j++) {
                    triangle[i][j] = sc.nextInt();
                }
            }
            for (int i = 98; i >= 0; i--){
                for (int j = 0; j <= i; j++){
                    triangle[i][j] += Math.max(triangle[i+1][j], triangle[i+1][j+1]);
                }
            }
            System.out.println(triangle[0][0]);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        long start = System.nanoTime();
        new p067();
        double end = (System.nanoTime() - start)/(double)1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
