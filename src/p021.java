/**
 * Created by Robert on 5/7/2017.
 */
public class p021 {

    public int sumOfDivisors(int x){
        int result = 0;
        for (int i = 1; i <= x/2; i++){
            if (x % i == 0){
                result += i;
            }
        }
        return result;
    }

    public p021(){
        int result = 0;
        int[] sumDivisors = new int[10000];

        for (int i = 1; i < 10000; i++){
            sumDivisors[i] = sumOfDivisors(i);
        }

        for (int i = 1; i < 10000; i++){
            int temp = sumDivisors[i];
            if (temp < 10000 && temp != i && sumDivisors[temp] == i){
                result += temp + sumDivisors[temp];
            }
        }
        System.out.println(result/2);
    }

    public static void main(String[] args){
        long start = System.nanoTime();
        new p021();
        double end = (System.nanoTime() - start)/(double)1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
