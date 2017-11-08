import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Robert on 5/17/2017.
 */
public class p096 {

    public boolean validMove(int[][] puzzle, int x, int y){
        for (int i = 0; i < 9; i++){
            if (i != x && puzzle[i][y] == puzzle[x][y]) return false;
            if (i != y && puzzle[x][i] == puzzle[x][y]) return false;

        }
        int cubeX = x/3*3, cubeY = y/3*3;
        for (int i = cubeX; i < cubeX + 3; i++){
            for (int j = cubeY; j < cubeY + 3; j++){
                if (i == x && j == y) continue;
                if (puzzle[i][j] == puzzle[x][y]) return false;
            }
        }
        return true;
    }

    public int[][] solvePuzzle(int[][] puzzle, boolean[][] blank){

        int x = 0, y = 0;

        while (!blank[x][y]){
            y++;
            if (y == 9){
                y = 0;
                x++;
            }
        }

        while (true){
            puzzle[x][y]++;
            if (puzzle[x][y] == 10){
                puzzle[x][y] = 0;
                do {
                    y--;
                    if (y == -1) {
                        y = 8;
                        x--;
                    }
                } while (!blank[x][y]);
            }
            else if (validMove(puzzle, x, y)){
                do {
                    y++;
                    if (y == 9) {
                        y = 0;
                        x++;
                        if (x == 9) return puzzle;
                    }
                } while (!blank[x][y]);
            }
        }
    }

    public p096() {
        int[][][] puzzles = new int[50][9][9];
        boolean[][][] blanks = new boolean[50][9][9];
        try {
            BufferedReader br = new BufferedReader(new FileReader("p096_sudoku.txt"));
            int i = -1, j = -1;
            String line;
            while ((line = br.readLine()) != null) {
                i++;
                if (i % 10 == 0) {
                    j++;
                    continue;
                }
                for (int k = 0; k < 9; k++) {
                    int val = (int) (line.charAt(k) - '0');
                    puzzles[j][i % 10 - 1][k] = val;
                    if (val == 0) blanks[j][i % 10 - 1][k] = true;
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }

        int result = 0;
        for (int i = 0; i < 50; i++){
            puzzles[i] = solvePuzzle(puzzles[i], blanks[i]);
            result += puzzles[i][0][0] * 100 + puzzles[i][0][1] * 10 + puzzles[i][0][2];
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        new p096();
        double end = (System.nanoTime() - start) / (double) 1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
