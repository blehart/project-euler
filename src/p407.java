import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Robert on 6/11/2017.
 */
public class p407 {

    public List<List<Long>> combinations(List<Long> iterable, int r){
        int n = iterable.size();
        if (r > n) return null;
        int[] indices = new int[r];
        List<List<Long>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int i = 0; i < r; i++){
            result.get(0).add(iterable.get(i));
            indices[i] = i;
        }
        while (true){
            boolean check = false;
            int i = r-1;
            for (; i >= 0; i--){
                if (indices[i] != i + n - r) {
                    check = true;
                    break;
                }
            }
            if (!check) return result;
            indices[i] += 1;
            for (int j = i+1; j < r; j++){
                indices[j] = indices[j-1]+1;
            }
            result.add(new ArrayList<>());
            for (int x : indices){
                result.get(result.size()-1).add(iterable.get(x));
            }
        }
    }

    public p407() {
        long result = 0;
        int n = 10000001;
        HashMap<Integer, List<Long>> f = new HashMap<>();
        long[] t = new long[n];
        for (int i = 0; i < n; i++){
            t[i] = i;
        }
        for (int p = 2; p < n; p++){
            if (!f.containsKey(p)){
                t[p] = p-1;
                for (int i = 2*p; i < n; i+=p){
                    long j = i, k = 1;
                    while (j % p == 0){
                        j /= p;
                        k *= p;
                    }
                    if (!f.containsKey(i)) f.put(i, new ArrayList<>());
                    f.get(i).add(k);
                    t[i] = t[i] * (p - 1) / p;
                }
            }
        }

        for (int i = 2; i < n; i++){
            if (!f.containsKey(i) || f.get(i).size() < 2){
                result += 1;
                continue;
            }
            long max = 0;
            for (int j = 1; j < f.get(i).size(); j++){
                for (List<Long> c : combinations(f.get(i), j)){
                    long u = 1;
                    for (long ci : c) u *= ci;
                    int v = (int)(i / u);
                    long w = Operations.modPow(u, t[v] - 1, v);
                    max = (u*w > max) ? u*w : max;
                }
            }
            result += max;
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        new p407();
        double end = (System.nanoTime() - start) / (double) 1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
