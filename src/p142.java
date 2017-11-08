
/**
 * Created by Robert on 5/24/2017.
 */
public class p142 {

    public boolean square(long x){
        double y = Math.sqrt(x);
        return y == (long)y;
    }

    public p142() {
        long a, b, c, d, e, f;
        boolean fini = false;
        long result = 0;

        for (long i = 4; !fini; i++){
            a = i * i;
            for (long j = 3; j < i && !fini; j++){
                c = j * j;
                f = a - c;
                if (f <= 0 || !square(f)) continue;

                long ki = (j % 2 == 1) ? 1 : 2;
                for (long k = ki; k < j; k += 2){
                    d = k * k;
                    e = a - d;
                    b = c - e;

                    if (b <= 0 || e <= 0 || !square(b) || !square(e)) continue;

                    long x = (d + c) / 2;
                    long y = (e + f) / 2;
                    long z = (c - d) / 2;

                    result = x + y + z;
                    fini = true;
                    break;
                }
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        new p142();
        double end = (System.nanoTime() - start) / (double) 1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
