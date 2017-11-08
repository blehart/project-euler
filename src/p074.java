import java.util.HashSet;

/**
 * Created by Robert on 5/14/2017.
 */
public class p074 {

    int[] factorials = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};
    public p074(){
        int result = 0;
        for (int i = 3; i < 1000000; i++){
            HashSet<Integer> chain = new HashSet<>();
            chain.add(i);
            int temp = i;
            for (int j = 1; j <= 60; j++){
                int nLink = 0;
                while (temp != 0){
                    nLink += factorials[temp%10];
                    temp /= 10;
                }
                if (chain.contains(nLink)){
                    if (j == 60){
                        result++;
                    }
                    else {
                        break;
                    }
                }
                chain.add(nLink);
                temp = nLink;
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args){
        long start = System.nanoTime();
        new p074();
        double end = (System.nanoTime() - start)/(double)1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
