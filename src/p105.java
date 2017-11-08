import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * Created by Robert on 5/23/2017.
 */
public class p105 {

    public p105() {

        try {
            int result = 0;
            BufferedReader br = new BufferedReader(new FileReader("p105_sets.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                String[] split = line.split(",");
                int[] set = new int[split.length];
                for (int i = 0; i < set.length; i++) {
                    set[i] = Integer.parseInt(split[i]);
                }
                Arrays.sort(set);
                if (p103.rule2(set)) {
                    int[] s = p103.subsetSums(set);
                    if (p103.rule1(s, set.length)) {
                        result += p103.sumArray(set);
                    }
                }
            }
            System.out.println(result);
        } catch (IOException e){
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        new p105();
        double end = (System.nanoTime() - start) / (double) 1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
