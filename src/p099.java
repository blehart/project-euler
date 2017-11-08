import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Robert on 5/22/2017.
 */
public class p099 {

    /**
     * a^b > c^d  if
     * log(a^b) > log(c^d)  which is the same as
     * b*log(a) > d*log(c)
     */
    public p099() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("p099_base_exp.txt"));
            String line;
            int i = 0, maxLine = 0;
            double max = 0;
            while ((line = br.readLine()) != null){
                i++;
                String[] split = line.split(",");
                int a = Integer.parseInt(split[0]);
                int b = Integer.parseInt(split[1]);

                double c = b * Math.log(a);
                if (c > max){
                    max = c;
                    maxLine = i;
                }
            }
            System.out.println(maxLine);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        new p099();
        double end = (System.nanoTime() - start) / (double) 1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
