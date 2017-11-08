/**
 * Created by Robert on 5/10/2017.
 */
public class p039 {

    public int numTriangles(int perimeter){
        int result = 0;
        for (int i = 1; i < perimeter; i++){
            for (int j = i + 1; j < perimeter; j++){
                if (i + j + Math.sqrt(i*i + j*j) == perimeter){
                    result++;
                }
            }
        }
        return result;
    }

    public p039(){
        int result = 0;
        int max = 0;
        for (int i = 10; i <= 1000; i++){
            int temp = numTriangles(i);
            if (temp > max){
                max = temp;
                result = i;
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args){
        long start = System.nanoTime();
        new p039();
        double end = (System.nanoTime() - start)/(double)1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
