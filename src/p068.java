import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Robert on 5/13/2017.
 */
public class p068 {

    int[][] fivegon;

    public void insertFivegone(int x, int index){
        if (index < 5){
            fivegon[index][0] = x;
        } else {
            fivegon[index%5][2] = x;
            fivegon[(index+1)%5][1] = x;
        }
    }

    public boolean allRowsEqual(){
        int sum = fivegon[0][0] + fivegon[0][1] + fivegon[0][2];
        if (sum < 13 || sum > 16) return false;
        for (int i = 1; i < 5; i++){
            int temp = fivegon[i][0] + fivegon[i][1] + fivegon[i][2];
            if (temp != sum) return false;
        }
        return true;
    }

    public int smallestExternalNode(){
        int min = fivegon[0][0];
        int result = 0;
        for (int i = 1; i < 5; i++){
            if (min > fivegon[i][0]){
                min = fivegon[i][0];
                result = i;
            }
        }
        return result;
    }

    public p068(){
        fivegon = new int[5][3];
        fivegon[0][0] = 10;  // 16-digit string tells us 10 will be an external node
        BigInteger max = BigInteger.ZERO;

        Random rand = new Random();
        for (long i = 0; i < 1000000L; i++){  // This seems to be enough to get correct answer
            ArrayList<Integer> digits = new ArrayList<>();
            for (int j = 1; j < 10; j++){
                digits.add(j);
            }
            for (int j = 1; j < 10; j++){
                int remove = rand.nextInt(digits.size());
                insertFivegone(digits.get(remove), j);
                digits.remove(remove);
            }
            if (allRowsEqual()) {
                int index = smallestExternalNode();
                StringBuilder s = new StringBuilder();
                for (int j = 0; j < 5; j++){
                    for (int k = 0; k < 3; k++){
                        s.append(Integer.toString(fivegon[(j + index)%5][k]));
                    }
                }
                BigInteger val = new BigInteger(s.toString());
                if (max.compareTo(val) < 0){
                    max = val;
                }
            }
        }
        System.out.println(max.toString());
    }

    public static void main(String[] args){
        long start = System.nanoTime();
        new p068();
        double end = (System.nanoTime() - start)/(double)1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
