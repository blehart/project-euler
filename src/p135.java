/**
 * Created by Robert on 5/28/2017.
 */
public class p135 {

    /**
     x^2 - y^2 - z^2 = n
     x = z+2d
     y = z+d
     3d^2 + 2dz - z^2 = n
     (3d-z)(d+z)=n
     i = 3d-z
     j = d+z
     d = u+v/4
     z = 3v-u/4
     */
    public p135() {
        int result = 0;
        int limit = 1000001;
        int[] n = new int[limit];

        for (int i = 1; i <= limit; i++){
            for (int j = 1; i*j <= limit; j++){
                if ((i + j) % 4 == 0 && 3*j > i && ((3*j-i)%4) == 0) n[i*j]++; // if d is integer && z is positive && z is integer
            }
        }
        for (int i : n){
            if (i == 10) result++;
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        new p135();
        double end = (System.nanoTime() - start) / (double) 1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
