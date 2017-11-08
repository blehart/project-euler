/**
 * Created by Robert on 5/27/2017.
 */
public class p106 {

    public boolean needCheck(int[] set1, int[] set2){
        if (set1[0] > set2[0]) return false;
        boolean needCheck = false;
        for (int i = 0; i < set1.length; i++){
            if (set1[i] > set2[i]) needCheck = true;
            for (int j : set2){
                if (set1[i] == j) return false;
                if (set1[i] < j) break;
            }
        }
        return needCheck;
    }

    public p106() {

        int result = 0;
        int n = 12;

        for (int i = 2; i <= n/2; i++){
            int[] set1 = new int[i];
            for (int j = 0; j < i; j++){
                set1[j] = j;
            }
            while (set1 != null){
                int[] set2 = new int[i];
                for (int j = 0; j < i; j++){
                    set2[j] = j;
                }
                while (set2 != null) {

                    if (needCheck(set1, set2)){
                        for (int aSet1 : set1) {
                            System.out.print(aSet1 + " ");
                        }
                        System.out.println();
                        for (int aSet2 : set2) {
                            System.out.print(aSet2 + " ");
                        }
                        System.out.println("\n---------");
                        result++;

                    }
                    set2 = Operations.nextCombo(n, i, set2);
                }
                set1 = Operations.nextCombo(n, i, set1);
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        new p106();
        double end = (System.nanoTime() - start) / (double) 1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
