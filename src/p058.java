import java.math.BigInteger;

/**
 * Created by Robert on 5/12/2017.
 */
public class p058 {

    public enum Move {UP, DOWN, RIGHT, LEFT};

    final int size = 26501;

    public p058(){
        int[][] grid = new int[size][size];
        int x = size/2, y = size/2;
        int lineLength = 1;
        int traveledLength = -1;
        int changeLength = 0;
        Move move = Move.RIGHT;
        int diagPrimes = 0;
        int diagNonPrimes = 0;
        for (int i = 1; i <= size*size; i++){
            grid[x][y] = i;
            if (x == y || size - x - 1 == y){
                System.out.println(i);
                if (BigInteger.valueOf(i).isProbablePrime(10)){
                    diagPrimes++;
                }
                else {
                    diagNonPrimes++;
                }
            }
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
                        move = Move.LEFT;
                        break;
                    case DOWN:
                        move = Move.RIGHT;
                        break;
                    case RIGHT:
                        move = Move.UP;
                        break;
                    case LEFT:
                        move = Move.DOWN;
                }
            }
            if (x == y && x > size/2){
                double percent = diagPrimes / (double)(diagPrimes + diagNonPrimes);
                if (percent < .10){
                    break;
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
    }

    public static void main(String[] args){
        long start = System.nanoTime();
        new p058();
        double end = (System.nanoTime() - start)/(double)1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
