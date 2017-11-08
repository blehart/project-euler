/**
 * Created by Robert on 5/9/2017.
 */
public class p028 {

    public enum Move {UP, DOWN, RIGHT, LEFT};

    public p028(){
        int[][] grid = new int[1001][1001];
        int x = 500, y = 500;
        int lineLength = 1;
        int traveledLength = -1;
        int changeLength = 0;
        Move move = Move.RIGHT;
        for (int i = 1; i <= 1002001; i++){
            grid[x][y] = i;
            traveledLength++;
            if (lineLength == traveledLength) {
                traveledLength = 0;
                changeLength++;
                if (changeLength == 2){
                    lineLength++;
                    changeLength = 0;
                }
                switch (move) {
                    case UP:
                        move = Move.RIGHT;
                        break;
                    case DOWN:
                        move = Move.LEFT;
                        break;
                    case RIGHT:
                        move = Move.DOWN;
                        break;
                    case LEFT:
                        move = Move.UP;
                }
            }
            switch (move) {
                case UP:
                    x--;
                    break;
                case DOWN:
                    x++;
                    break;
                case RIGHT:
                    y++;
                    break;
                case LEFT:
                    y--;
            }
        }
        int result = 0;
        for (int i = 0; i < 1001; i++){
            result += grid[i][i] + grid[1000-i][i];
        }
        System.out.println(result-1);
    }

    public static void main(String[] args){
        long start = System.nanoTime();
        new p028();
        double end = (System.nanoTime() - start)/(double)1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
