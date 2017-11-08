import java.text.DecimalFormat;
import java.util.Random;

/**
 * Created by Robert on 5/15/2017.
 */
public class p084 {

    int[] board;
    int rounds = 1000000;
    final int size = 40;
    int cPos = 0;
    int chPos = 0;

    public int chance(int pos){
        int[] chance = {0, 10, 11, 24, 39, 5};
        chPos = ++chPos % 16;

        if (chPos < 6) {
            pos = chance[chPos];
        }
        else if (chPos == 6 || chPos == 7) {
            if (pos == 7) pos = 15;
            if (pos == 22) pos = 25;
            if (pos == 36) pos = 5;
        }
        else if (chPos == 8 ) {
            pos = (pos == 22) ? 28 : 12;
        }
        else if (chPos == 9) pos -= 3;

        return pos;
    }

    public int community(int pos){
        int[] cc = {0, 10};
        cPos = ++cPos % 16;

        if (cPos < 2) {
            pos = cc[cPos];
        }
        return pos;
    }

    public p084() {
        board = new int[size];
        int pos = 0;
        int doubles = 0;

        Random rand = new Random();
        for (int i = 0; i < rounds; i++) {
            int d1 = rand.nextInt(4) + 1;
            int d2 = rand.nextInt(4) + 1;

            doubles = (d1 == d2) ? doubles + 1 : 0;
            if (doubles > 2) {
                pos = 10;
                doubles = 0;
            } else {
                pos = (pos + d1 + d2) % 40;

                if (pos == 7 || pos == 22 || pos == 36) pos = chance(pos);
                if (pos == 2 || pos == 17 || pos == 33) pos = community(pos);
                if (pos == 30) pos = 10; // Go to Jail
            }
            board[pos]++;
        }

        double m1 = 0, m2 = 0, m3 = 0;
        int i1 = 0, i2 = 0, i3 = 0;
        for (int i = 0; i < size; i++){
            if (board[i] > m1){
                m3 = m2; m2 = m1; m1 = board[i];
                i3 = i2; i2 = i1; i1 = i;
            }
            else if (board[i] > m2){
                m3 = m2; m2 = board[i];
                i3 = i2; i2 = i;
            }
            else if (board[i] > m3){
                m3 = board[i];
                i3 = i;
            }
        }
        DecimalFormat format = new DecimalFormat("00");
        System.out.println(format.format(i1) + format.format(i2) + format.format(i3));
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        new p084();
        double end = (System.nanoTime() - start) / (double) 1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
