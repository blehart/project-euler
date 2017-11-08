/**
 * Created by Robert on 5/27/2017.
 */
public class p126 {

    public int Cubes(int x, int y, int z, int n){
        return 2 * (x * y + y * z + x * z) + 4 * (x + y + z + n -2) * (n - 1);
    }

    public p126() {
        int limit = 20000;
        int[] count = new int[limit + 1];
        for (int z = 1; Cubes(z, z, z, 1) <= limit; z++){
            for (int y = z; Cubes(z, y, z, 1) <= limit; y++){
                for (int x = y; Cubes(z, y, x, 1) <= limit; x++){
                    for (int n = 1; Cubes(z, y, x, n) <= limit; n++){
                        count[Cubes(z, y, x, n)]++;
                    }
                }
            }
        }
        for (int i = 0; i < count.length; i++){
            if (count[i] == 1000){
                System.out.println(i);
                break;
            }
        }
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        new p126();
        double end = (System.nanoTime() - start) / (double) 1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
