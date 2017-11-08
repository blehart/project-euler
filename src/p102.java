import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Robert on 5/22/2017.
 */
public class p102 {


    /**
     * Barycentric Coordinates
     */
    public p102() {
        try {
            int result = 0;
            BufferedReader br = new BufferedReader(new FileReader("p102_triangles.txt"));
            String line;
            while ((line = br.readLine()) != null){
                String[] split = line.split(",");
                int[] pt = new int[split.length];
                for (int i = 0; i < pt.length; i++){
                    pt[i] = Integer.parseInt(split[i]);
                }
                double alpha = ((pt[3] - pt[5]) * (0.0 - pt[4]) + (pt[4] - pt[2]) * (0.0 - pt[5])) /
                        ((pt[3] - pt[5]) * (pt[0] - pt[4]) + (pt[4] - pt[2]) * (pt[1] - pt[5]));
                double beta = ((pt[5] - pt[1]) * (0.0 - pt[4]) + (pt[0] - pt[4]) * (0.0 - pt[5])) /
                        ((pt[3] - pt[5]) * (pt[0] - pt[4]) + (pt[4] - pt[2]) * (pt[1] - pt[5]));
                double gamma = 1.0f - alpha - beta;

                if (alpha > 0 && beta > 0 && gamma > 0) result++;
            }
            System.out.println(result);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        new p102();
        double end = (System.nanoTime() - start) / (double) 1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
