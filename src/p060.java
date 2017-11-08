import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by Robert on 5/12/2017.
 */
public class p060 {

    final int MAXPRIME = 10000;
    HashMap<Integer, HashSet<Integer>> pairSetMap;

    public HashSet<Integer> getPairSet(int x){
        HashSet<Integer> pairSets = new HashSet<>();
        for (int i = 3; i < MAXPRIME; i+=2){
            if (i == x) continue;
            StringBuilder s = new StringBuilder();
            s.append(Integer.toString(i));
            String pre = Integer.toString(x) + s.toString();
            String post = s.append(Integer.toString(x)).toString();
            if ((new BigInteger(pre)).isProbablePrime(20) &&
                    (new BigInteger(post).isProbablePrime(20))){
                pairSets.add(i);
            }
        }
        return pairSets;
    }

    public p060(){
        pairSetMap = new HashMap<>();
        ArrayList<Integer> primes = new ArrayList<>();
        BigInteger prim = BigInteger.valueOf(3);
        while (prim.compareTo(BigInteger.valueOf(MAXPRIME)) < 0){
            primes.add(prim.intValue());
            pairSetMap.put(prim.intValue(), getPairSet(prim.intValue()));
            prim = prim.nextProbablePrime();
        }
        int result = Integer.MAX_VALUE;
        for (Integer prime : primes) {
            HashSet<Integer> one = pairSetMap.get(prime);
            for (Integer val : one) {
                if (pairSetMap.containsKey(val)) {
                    HashSet<Integer> two = pairSetMap.get(val);
                    HashSet<Integer> cross = new HashSet<>(one);
                    cross.retainAll(two);
                    for (Integer val2 : cross) {
                        if (pairSetMap.containsKey(val2)) {
                            HashSet<Integer> three = pairSetMap.get(val2);
                            HashSet<Integer> cross2 = new HashSet<>(cross);
                            cross2.retainAll(three);
                            for (Integer val3 : cross2) {
                                if (pairSetMap.containsKey(val3)) {
                                    HashSet<Integer> four = pairSetMap.get(val3);
                                    HashSet<Integer> cross3 = new HashSet<>(cross2);
                                    cross3.retainAll(four);
                                    for (Integer val4 : cross3) {
                                        if (pairSetMap.containsKey(val4)) {
                                            HashSet<Integer> five = pairSetMap.get(val4);
                                            HashSet<Integer> cross4 = new HashSet<>(cross3);
                                            cross4.retainAll(five);
                                            result = Math.min(result, prime + val + val2 + val3 + val4);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args){
        long start = System.nanoTime();
        new p060();
        double end = (System.nanoTime() - start)/(double)1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
