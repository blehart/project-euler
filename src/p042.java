import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashSet;

/**
 * Created by Robert on 5/10/2017.
 */
public class p042 {

    public p042(){
        HashSet<Integer> triangeNums = new HashSet<>();
        int result = 0;
        for (int i = 1; i < 400; i++){
            triangeNums.add((i * (i + 1))/2);
        }
        try {
            BufferedReader br = new BufferedReader(new FileReader("p042_words.txt"));
            String file = br.readLine();
            file = file.replaceAll("\"", "");
            String[] words = file.split(",");
            for (int i = 0; i < words.length; i++){
                int wordSum = 0;
                for (int j = 0; j < words[i].length(); j++){
                    wordSum += (int)words[i].charAt(j) - '@';
                }
                if (triangeNums.contains(wordSum)){
                    result++;
                }
            }
            System.out.println(result);
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        long start = System.nanoTime();
        new p042();
        double end = (System.nanoTime() - start)/(double)1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
