/**
 * Created by Robert on 5/29/2017.
 */
public class p139 {

    /*
    (a, b, c):
    3, 4, 5
    Volume cube = 5^2 = 25
    Volume tri = 3*4/2 = 6
    Volume middle = 25 - 6*4 = 1 = b - a
    5 % 1 = 0
    c % (b-a) = 0

    5, 12, 13
    VC = 169
    VT = 30
    VM = 169 - 120 = 49
    13%7 != 0
    c % (b-a) != 0


    Generate pythagorean triples, check if c%(b-a) == 0
    Given a primitive pythagorean triple that satifies condition, all multiples of it will also satisfy,
    and we have limit/p multiples below the limit
     */
    public p139() {

        long limit = 100000000L;
        long result = 0;
        long mlimit = (long)Math.sqrt(limit/2);

        for (long m = 2; m < mlimit; m++){
            for (long n = 1; n < m; n++){
                if (((n+m)%2 == 1) && Operations.coprime(m, n)){
                    long a = 2 * m * n;
                    long b = m * m - n * n;
                    long c = m * m + n * n;
                    long p = a + b + c;
                    if (c % (b - a) == 0) result += limit / p;
                }
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        new p139();
        double end = (System.nanoTime() - start) / (double) 1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
