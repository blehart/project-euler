import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by Robert on 5/14/2017.
 */
public class p079 {

    HashSet<Integer> possibleNum;
    HashMap<Integer, HashSet<Integer>> graph;

    /**
     * Follow the starting point in a depth first way, until we find a path that
     * uses each of the possible numbers (we know each number only shows up once)
     */
    public boolean answer(int node, ArrayList<Integer> passcode){
        HashSet<Integer> temp = (HashSet<Integer>)possibleNum.clone();
        temp.removeAll(passcode);
        if (temp.isEmpty()) return true;
        for (Integer i : graph.get(node)){
            passcode.add(i);
            boolean response = answer(i, passcode);
            if (response) return true;
            passcode.remove(i);
        }
        return false;
    }
    /**
     * Solved by hand first
     * Starts with 7 (only value that is only on left)
     * Ends with 0 (only value that is only on left)
     * 3 is likely towards front (only on left/center)
     * 9 is likely towards back (only on center/right)
     */
    public p079(){
        try {
            BufferedReader br = new BufferedReader(new FileReader("p079_keylog.txt"));
            possibleNum = new HashSet<>();
            graph = new HashMap<>();
            for (int i = 0; i < 10; i++){
                graph.put(i, new HashSet<>());
            }
            String line;
            while ((line = br.readLine()) != null) {
                for (int i = 0; i < 3; i++){
                    possibleNum.add((int)line.charAt(i) - '0');
                }
                int one = (int)line.charAt(0) - '0';
                int two = (int)line.charAt(1) - '0';
                int three = (int)line.charAt(2) - '0';
                graph.get(one).add(two);
                graph.get(one).add(three);
                graph.get(two).add(three);
            }
            ArrayList<Integer> passcode = new ArrayList<>();
            passcode.add(7);
            answer(7, passcode);
            System.out.println(passcode);


        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        long start = System.nanoTime();
        new p079();
        double end = (System.nanoTime() - start)/(double)1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
