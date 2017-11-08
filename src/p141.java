/**
 * Created by Robert on 5/29/2017.
 */
public class p141 {

    /*
    n = dq + r
    r < d < q
    Geometric progression: d = rc, q = rc^2
    c must be rational: c = a/b, a > b

    d = ra/b
    q = ra^2/b^2

    q must be rational: We know b^2 | a^2, so b^2 | r
    r = cb^2

    d = abc
    q = ca^2

    n = a^3bc^2 + cb^2
     */
    public p141() {
        long result = 0;
        long limit = (long)1e12;

        for (long a = 2; a < 10000; a++){
            for (long b = 1; b < a; b++){
                if (a*a*a*b*b + b*b >= limit) break;
                if (!Operations.coprime(a, b)) continue;

                for (long c = 1;;c++){
                    long n = a*a*a*b*c*c + c*b*b;
                    if (n >= limit) break;

                    double sqrt = Math.sqrt(n);
                    if (sqrt == (long)sqrt) result += n;
                }
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        new p141();
        double end = (System.nanoTime() - start) / (double) 1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
