import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Created by Robert on 5/22/2017.
 */
public class p098 {

    int[] squares;

    public int squareAna(String word1, String word2){
        int max = 0;
        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();

        for (int i = 0; i < squares.length; i++){
            int sqLength = (int)Operations.numDigits(squares[i]);
            if (sqLength < word1.length()) continue;
            if (sqLength > word1.length()) break;

            boolean match = true;
            int sq = squares[i];
            HashMap<Character, Integer> map = new HashMap<>();

            for (int j = w1.length-1; j >= 0; j--){
                int digit = sq % 10;
                sq /= 10;

                if (map.containsKey(w1[j])){
                    if (map.get(w1[j]) == digit) continue;
                    else {
                        match = false;
                        break;
                    }
                }

                if (map.containsValue(digit)){
                    match = false;
                    break;
                }

                map.put(w1[j], digit);
            }

            if (!match) continue;

            int w2val = 0;
            if (map.get(w2[0]) == 0) match = false;
            else {
                for (int j = 0; j < w2.length; j++){
                    w2val = w2val * 10 + map.get(w2[j]);
                }
            }

            if (!match) continue;
            if (Arrays.binarySearch(squares, w2val) > -1){
                int tmax = (w2val > squares[i]) ? w2val : squares[i];
                max = (max > tmax) ? max : tmax;
            }
        }
        return max;
    }

    public p098() {
        int max = 0;
        squares = new int[10000];
        for (int i = 0; i < 10000; i++){
            squares[i] = i*i;
        }
        HashMap<String, List<String>> words = new HashMap<>();
        HashMap<String, List<String>> anagrams = new HashMap<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("p098_words.txt"));
            String line = br.readLine();
            line = line.replaceAll("\"", "");
            String[] _words = line.split(",");
            for (String s : _words) {
                char[] sort = s.toCharArray();
                Arrays.sort(sort);
                String sorted = new String(sort);
                if (!words.containsKey(sorted)) {
                    words.put(sorted, new ArrayList<>());
                }
                words.get(sorted).add(s);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        for (Map.Entry<String, List<String>> entry : words.entrySet()){
            String key = entry.getKey();
            List<String> value = entry.getValue();
            if (value.size() == 2){
                String first = new StringBuilder(value.get(0)).reverse().toString();
                String second = value.get(1);
                if (!first.equals(second)) {
                    anagrams.put(key, value);
                }
            }
        }
        for (Map.Entry<String, List<String>> entry : anagrams.entrySet()) {
            String key = entry.getKey();
            List<String> value = entry.getValue();

            String first = value.get(0);
            String second = value.get(1);

            int tmax = squareAna(first, second);
            max = (max > tmax) ? max : tmax;
        }
        System.out.println(max);
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        new p098();
        double end = (System.nanoTime() - start) / (double) 1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
