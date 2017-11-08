import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by Robert on 5/10/2017.
 */
public class p043 {

    public boolean isSemiPandigital(long n){
        char[] c = String.valueOf(n).toCharArray();
        Arrays.sort(c);
        return Arrays.equals(c, "012345678".toCharArray()) ||
                Arrays.equals(c, "012345679".toCharArray()) ||
                Arrays.equals(c, "012345689".toCharArray()) ||
                Arrays.equals(c, "012345789".toCharArray()) ||
                Arrays.equals(c, "012346789".toCharArray()) ||
                Arrays.equals(c, "012356789".toCharArray()) ||
                Arrays.equals(c, "012456789".toCharArray()) ||
                Arrays.equals(c, "013456789".toCharArray()) ||
                Arrays.equals(c, "023456789".toCharArray()) ||
                Arrays.equals(c, "123456789".toCharArray());
    }

    public long fixNumber(String s){
        for (int i = 0; i < 10; i++){
            if (!s.contains(String.valueOf(i))){
                return Long.parseLong(String.valueOf(i) + s);
            }
        }
        return 0;
    }

    public p043() {
        ArrayList<String>[] lists = new ArrayList[7];
        for (int i = 0; i < 7; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int i = 10; i < 1000; i++) {
            String s = String.valueOf(i);
            if (s.length() < 3) {
                s = "0" + s;
            }
            if (i % 17 == 0) {
                lists[6].add(s);
            }
            if (i % 13 == 0) {
                lists[5].add(s);
            }
            if (i % 11 == 0) {
                lists[4].add(s);
            }
            if (i % 7 == 0) {
                lists[3].add(s);
            }
            if (i % 5 == 0) {
                lists[2].add(s);
            }
            if (i % 3 == 0) {
                lists[1].add(s);
            }
            if (i % 2 == 0) {
                lists[0].add(s);
            }
        }

        for (int j = 5; j >= 0; j--) {
            ArrayList<String> temp = new ArrayList<>();
            for (int i = 0; i < lists[6].size(); i++) {
                String s = lists[6].get(i);
                for (String t : lists[j]) {
                    if (s.substring(0, 2).equals(t.substring(1, 3))) {
                        temp.add(t.charAt(0) + s);
                    }
                }
            }
            lists[6] = temp;
            Collections.sort(lists[6]);
        }
        long result = 0;
        for (String s : lists[6]){
            if (isSemiPandigital(Long.parseLong(s))){
                result += fixNumber(s);
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args){
        long start = System.nanoTime();
        new p043();
        double end = (System.nanoTime() - start)/(double)1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
