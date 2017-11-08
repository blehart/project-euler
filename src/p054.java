import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

/**
 * Created by Robert on 5/11/2017.
 */
public class p054 {

    HashMap<Character, Integer> cards;

    private void initRanks(){
        cards = new HashMap<>();
        cards.put('2', 0);
        cards.put('3', 1);
        cards.put('4', 2);
        cards.put('5', 3);
        cards.put('6', 4);
        cards.put('7', 5);
        cards.put('8', 6);
        cards.put('9', 7);
        cards.put('T', 8);
        cards.put('J', 9);
        cards.put('Q', 10);
        cards.put('K', 11);
        cards.put('A', 12);
    }

    public enum Ranks {HIGH, PAIR, DPAIR, TKIND, STRT, FLUSH, FULL, FKIND, STRTFLUSH, ROYAL};

    public Ranks evalHand(String[] hand){
        Arrays.sort(hand, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int val1 = cards.get(o1.charAt(0));
                int val2 = cards.get(o2.charAt(0));
                if (val1 < val2){
                    return -1;
                }
                else if (val1 > val2){
                    return 1;
                }
                return 0;
            }
        });
        boolean fullHouse = false;
        boolean flush = true;
        boolean straight = true;
        boolean threeKind = false;
        boolean twoPair = false;
        boolean onePair = false;
        char suit = hand[0].charAt(1);
        int val = cards.get(hand[0].charAt(0));
        for (int i = 1; i < 5; i++){
            if (suit != hand[i].charAt(1)) {
                flush = false;
            }
            if (val + i != cards.get(hand[i].charAt(0))){
                straight = false;
            }
        }
        HashMap<Character, Integer> values = new HashMap<>();
        for (int i = 0; i < 5; i++){
            char c = hand[i].charAt(0);
            if (values.containsKey(c)){
                values.replace(c, values.get(c) + 1);
            } else {
                values.put(c, 1);
            }
        }
        for (Map.Entry<Character, Integer> entry : values.entrySet()){
            int value = entry.getValue();
            if (value == 4) return Ranks.FKIND;
            if (value == 3) threeKind = true;
            if (value == 2){
                if (onePair) twoPair = true;
                else onePair = true;
            }
        }
        if (flush || straight){
            if (flush && !straight) flush = true;
            else if (!flush) straight = true;
            else {
                if (hand[0].charAt(0) == 'T'){ //10-A
                    return Ranks.ROYAL;
                } else {
                    return Ranks.STRTFLUSH;
                }
            }
        } else {
            if (threeKind && onePair) fullHouse = true;

        }
        if (fullHouse) return Ranks.FULL;
        if (flush) return Ranks.FLUSH;
        if (straight) return Ranks.STRT;
        if (threeKind) return Ranks.TKIND;
        if (twoPair) return Ranks.DPAIR;
        if (onePair) return Ranks.PAIR;
        return Ranks.HIGH;
    }

    public HashMap<Character, Integer> generateFrequencyMap(String[] hand){
        HashMap<Character, Integer> map  = new HashMap<>();
        for (int i = 0; i < hand.length; i++) {
            char c = hand[i].charAt(0);
            if (map.containsKey(c)) {
                map.replace(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        return map;
    }

    public int[] generateComparisonArray(HashMap<Character, Integer> map, int resultSize, Ranks rank) {
        int[] array = new int[resultSize];
        if (rank.equals(Ranks.TKIND)){
            array[0] = -1;
        } else if (rank.equals(Ranks.DPAIR)) {
            array[1] = -1;
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()){
            int value = entry.getValue();
            char key = entry.getKey();
            if (rank.equals(Ranks.FKIND)) {
                if (value == 4) {
                    array[1] = cards.get(key);
                } else {
                    array[0] = cards.get(key);
                }
            }
            else if (rank.equals(Ranks.FULL)) {
                if (value == 3) {
                    array[1] = cards.get(key);
                } else {
                    array[0] = cards.get(key);
                }
            }
            else if (rank.equals(Ranks.TKIND)) {
                if (value == 3) {
                    for (int i = 4; i > 1; i++) {
                        array[i] = value;
                    }
                } else {
                    if (array[0] == -1) array[0] = value;
                    else {
                        int temp = array[0];
                        array[0] = Math.min(temp, value);
                        array[1] = Math.max(temp, value);
                    }
                }
            } else if (rank.equals(Ranks.DPAIR)) {

                if (value == 2){
                    if (array[1] == -1) array[1] = value;
                    else {
                        int temp = array[1];
                        array[1] = Math.min(temp, value);
                        array[2] = Math.max(temp, value);
                    }
                } else {
                    array[0] = value;
                }
            }
        }
        return array;
    }


    public boolean compareEqualRanks(String[] hand1, String[] hand2, Ranks rank){
        switch (rank) {
            case ROYAL:
                return true;
            case STRTFLUSH:
            case FLUSH:
            case STRT:
            case HIGH:
                for (int i = 4; i >= 0; i--) {
                    int val1 = cards.get(hand1[i].charAt(0));
                    int val2 = cards.get(hand2[i].charAt(0));
                    if (val1 > val2) return true;
                    else if (val1 < val2) return false;
                }
                return false;
        }

        HashMap<Character, Integer> values1 = generateFrequencyMap(hand1);
        HashMap<Character, Integer> values2 = generateFrequencyMap(hand2);

        int size = 0;
        switch (rank) {
            case FKIND:
            case FULL:
                size = 2;
                break;
            case TKIND:
            case DPAIR:
                size = 3;
                break;
            case PAIR:
                int max1 = 0;
                for (Map.Entry<Character, Integer> entry : values1.entrySet()){
                    int value = entry.getValue();
                    char key = entry.getKey();
                    if (value == 2){
                        max1 = cards.get(key);
                    }
                }
                int max2 = 0;
                for (Map.Entry<Character, Integer> entry : values2.entrySet()){
                    int value = entry.getValue();
                    char key = entry.getKey();
                    if (value == 2){
                        max2 = cards.get(key);
                    }
                }
                if (max1 != max2) return max1 > max2;
                for (int i = 4; i >= 0; i--){
                    int val1 = cards.get(hand1[i].charAt(0));
                    int val2 = cards.get(hand2[i].charAt(0));

                    if (val1 > val2) return true;
                    else if (val1 < val2) return false;
                }
                return false;
        }
        int[] h1 = generateComparisonArray(values1, size, rank);
        int[] h2 = generateComparisonArray(values2, size, rank);

        for (int i = size-1; i >= 0; i--){
            if (h1[i] > h2[i]) return true;
            else if (h1[i] < h2[i]) return false;
        }
        return false;
    }

    public p054(){
        initRanks();

        try {
            BufferedReader br = new BufferedReader(new FileReader("p054_poker.txt"));
            String line;
            int playerOneWins = 0;
            while ((line = br.readLine()) != null) {
                Scanner sc = new Scanner(line);
                String[] hand1 = new String[5];
                String[] hand2 = new String[5];
                for (int i = 0; i < 5; i++){
                    hand1[i] = sc.next();
                }
                for (int i = 0; i < 5; i++){
                    hand2[i] = sc.next();
                }
                Ranks r1 = evalHand(hand1);
                Ranks r2 = evalHand(hand2);
                if (r1.equals(r2)){
                    if (compareEqualRanks(hand1, hand2, r1)){
                        playerOneWins++;
                    }
                } else if (r1.compareTo(r2) > 0){
                    playerOneWins++;
                }

            }

            System.out.println(playerOneWins);
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        long start = System.nanoTime();
        new p054();
        double end = (System.nanoTime() - start)/(double)1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
