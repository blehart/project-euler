import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by Robert on 5/7/2017.
 */
public class p022 {

    public int alphaValue(String name){
        int result = 0;
        for (char c : name.toCharArray()){
            result += c - 64;
        }
        return result;
    }

    public p022(){
        try {
            BufferedReader br = new BufferedReader(new FileReader("p022_names.txt"));
            String s = br.readLine();
            String[] splitNames = s.replaceAll("\"", "").split(",");
            ArrayList<String> names = new ArrayList<>(Arrays.asList(splitNames));
            Collections.sort(names);

            int result = 0;
            for (int i = 0; i < names.size(); i++){
                result += alphaValue(names.get(i)) * (i + 1);
            }
            System.out.println(result);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        long start = System.nanoTime();
        new p022();
        double end = (System.nanoTime() - start)/(double)1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
