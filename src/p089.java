import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Robert on 5/16/2017.
 */
public class p089 {

    public p089() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("p089_roman.txt"));
            String line;
            StringBuilder sb = new StringBuilder(10000);
            while ((line = br.readLine()) != null) {
                sb.append(line);
                sb.append(" ");
            }
            String modified = sb.toString().replaceAll("IIII|XXXX|CCCC|VIIII|LXXXX|DCCCC", "aa");
            System.out.println(sb.length() - modified.length());
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        new p089();
        double end = (System.nanoTime() - start) / (double) 1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
