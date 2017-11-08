import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

/**
 * Created by Robert on 5/10/2017.
 */
public class Operations {

    public static boolean isPalindrome(String s){
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) return false;
        }
        return true;
    }

    public static boolean isPalindrome(long x){
        long temp = x;
        long reverse = 0;

        while (temp != 0){
            reverse = reverse * 10 + (temp % 10);
            temp /= 10;
        }
        return x == reverse;
    }

    public static boolean isPandigital(long n){
        int digits = 0, count = 0, tmp;
        for (; n > 0; n /= 10, count++){
            if ((tmp = digits) == (digits |= 1 << (n - ((n / 10) * 10) -1))) return false;
        }
        return digits == (1 << count) -1;
    }

    public static long numDigits(long x){
        return (long)(Math.log10(x)+1);
    }

    public static int log10(BigInteger x){
        int digits = 0;
        int bits = x.bitLength();

        while (bits > 4){
            int reduce = bits / 4;
            x = x.divide(BigInteger.TEN.pow(reduce));
            digits += reduce;
            bits = x.bitLength();
        }

        if (x.intValue() > 9){
            digits += 1;
        }
        return digits;
    }

    public static long sumDigits(long x){
        long result = 0;
        while (x != 0){
            result += x % 10;
            x /= 10;
        }
        return result;
    }
    public static long sumDigits(BigInteger x){
        long result = 0;
        while (!x.equals(BigInteger.ZERO)){
            result += x.mod(BigInteger.TEN).longValue();
            x = x.divide(BigInteger.TEN);
        }
        return result;
    }

    public static long factorial(long x){
        if (x == 0) return 1;
        return x * factorial(x - 1);
    }
    public static BigInteger factorial(BigInteger x){
        BigInteger i = x;
        BigInteger result = BigInteger.ONE;
        while (i.compareTo(BigInteger.ONE) > 0){
            result = result.multiply(i);
            i = i.add(BigInteger.ONE);
        }
        return result;
    }

    public static long GCD(long a, long b) { return b==0 ? a : GCD(b, a%b);}

    public static BigInteger nchoosek(long n, long k){
        return factorial(BigInteger.valueOf(n)).divide(factorial(BigInteger.valueOf(k)).multiply(factorial(BigInteger.valueOf(n - k))));
    }

    public static List<Integer> period(int S){
        List<Integer> m = new ArrayList<>(), d = new ArrayList<>(), a = new ArrayList<>();
        m.add(0, 0);
        d.add(0, 1);
        a.add(0, (int)Math.sqrt(S));
        for (int n = 0;;n++){
            m.add(n+1, d.get(n) * a.get(n) - m.get(n));
            d.add(n+1, (S - m.get(n+1) * m.get(n+1)) / d.get(n));
            a.add(n+1, (int)((a.get(0) + m.get(n+1))/ d.get(n+1)));
            if (a.get(n+1) == 2 * a.get(0)) break;
        }
        return a;
    }

    public static BigInteger solveXPell(long D){
        BigInteger sqrt = BigInteger.valueOf((int)Math.sqrt(D));
        BigInteger m = BigInteger.ZERO;
        BigInteger d = BigInteger.ONE;
        BigInteger a = sqrt;

        BigInteger pnum = BigInteger.ONE;
        BigInteger num = a;
        BigInteger pden = BigInteger.ZERO;
        BigInteger den = BigInteger.ONE;

        while (!num.pow(2).subtract(den.pow(2).multiply(BigInteger.valueOf(D))).equals(BigInteger.ONE)){  //num^2 - D * den^2 != 1
            m = d.multiply(a).subtract(m);
            d = BigInteger.valueOf(D).subtract(m.pow(2)).divide(d);
            a = sqrt.add(m).divide(d);

            BigInteger tempNum = pnum;
            pnum = num;

            BigInteger tempDen = pden;
            pden = den;

            num = a.multiply(pnum).add(tempNum);
            den = a.multiply(pden).add(tempDen);
        }
        return num;
    }

    public static boolean isPermutation(String x, String y){
        char[] x1 = x.toCharArray();
        char[] y1 = y.toCharArray();
        Arrays.sort(x1);
        Arrays.sort(y1);
        return Arrays.equals(x1, y1);
    }

    public static List<Integer> sieveOfEratosthenes(int lower, int limit){

        List<Integer> primes = new ArrayList<>((int)(limit/(Math.log(limit)-1.08366)));
        BitSet sieve = new BitSet(limit + 1);
        if (lower < 2) primes.add(2);
        int limitSqrt = (int)Math.sqrt(limit);

        for (int i = 3; i <= limit; i += 2){
            if(!sieve.get(i)){
                if (i < limitSqrt){
                    for (int j = i * i; j <= limit; j+=2*i)
                        sieve.set(j, true);
                }
                if (i >= lower)
                    primes.add(i);
            }
        }
        return primes;
    }

    public static List<Long> segmentedSieve(long lower, long limit){

        int sqrt = (int)Math.sqrt(limit)+1;
        List<Integer> primes = sieveOfEratosthenes(sqrt);
        List<Long> result = new ArrayList<>();
        for (int p : primes){
            if (p >= lower) result.add((long)p);
        }

        long low = sqrt, high = 2 * sqrt;

        while (low < limit){
            System.out.println(low + " " + limit);
            BitSet sieve = new BitSet(sqrt + 1);

            for (int i = 0; i < primes.size(); i++){
                long loLim = low / primes.get(i) * primes.get(i);
                if (loLim < low) loLim += primes.get(i);

                for (long j = loLim; j < high; j+=primes.get(i)) sieve.set((int)(j-low), false);
            }
            for (long i = low; i < high; i++){
                if (!sieve.get((int)(i-low)) && i >= lower) result.add(i);
            }
            low = low + sqrt;
            high = high + sqrt;
            if (high > limit) high = limit;
        }
        return result;
    }

    public static List<Integer> sieveOfEratosthenes(int limit){
        return sieveOfEratosthenes(0, limit);
    }


    public static List<Integer> sieveOfAtkin(int limit) {

        BitSet sieve = new BitSet(limit + 1);
        sieve.set(2, true);
        sieve.set(3, true);
        int limitSqrt = (int)Math.sqrt(limit);

        for (int x = 1; x <= limitSqrt; x++) {
            for (int y = 1; y <= limitSqrt; y++) {
                int n = (4 * x * x) + (y * y);
                if (n <= limit && (n % 12 == 1 || n % 12 == 5)) {
                    sieve.flip(n);
                }
                n = (3 * x * x) + (y * y);
                if (n <= limit && (n % 12 == 7)) {
                    sieve.flip(n);
                }
                n = (3 * x * x) - (y * y);
                if (x > y && n <= limit && (n % 12 == 11)) {
                    sieve.flip(n);
                }
            }
        }
        for (int n = 5; n <= limitSqrt; n++) {
            if (sieve.get(n)) {
                int x = n * n;
                for (int i = x; i <= limit; i += x) {
                    sieve.set(i, false);
                }
            }
        }
        List<Integer> primes = new ArrayList<>((int)(limit/(Math.log(limit)-1.08366)));
        for (int i = 0, j = 0; i <= limit; i++) {
            if (sieve.get(i)) {
                primes.add(i);
            }
        }
        return primes;
    }

    public static boolean _isPrime(long x){
        if (x < 2) return false;
        if (x < 4) return true;
        if (x % 2 == 0) return false;
        if (x < 9) return true;
        if (x % 3 == 0) return false;
        if (x < 25) return true;

        long s = (long)Math.sqrt(x);
        for (long i = 5; i <= s; i += 6){
            if (x % i == 0) return false;
            if (x % (i + 2) == 0) return false;
        }
        return true;
    }

    public static int[] nextCombo(int n, int k, int[] combo){
        int i = k - 1;
        combo[i]++;
        while (i > 0 && combo[i] >= n - k + 1 + i){
            i--;
            combo[i]++;
        }
        if (combo[0] > n - k) return null;
        for (i = i + 1; i < k; i++){
            combo[i] = combo[i-1] + 1;
        }
        return combo;
    }

    public static int[] nextPermutation(int[] permu) {

        boolean nextExists = false;
        for (int i = 0; i < permu.length-1; i++) {
            if (permu[i] < permu[i + 1]) nextExists = true;
        }
        if (!nextExists) return null;

        int i = permu.length - 1;
        while (permu[i - 1] >= permu[i]) i--;

        int j = permu.length;
        while (permu[j - 1] <= permu[i - 1]) j--;

        int temp = permu[i - 1];
        permu[i - 1] = permu[j - 1];
        permu[j - 1] = temp;

        i++;
        j = permu.length;

        while (i < j) {
            temp = permu[i - 1];
            permu[i - 1] = permu[j - 1];
            permu[j - 1] = temp;
            i++;
            j--;
        }
        return permu;
    }

    public static boolean coprime(long u, long v){
        if (((u | v) & 1) == 0) return false;

        while ((u & 1) == 0) u >>= 1;
        if (u == 1) return true;

        do {
            while ((v & 1) == 0) v >>= 1;
            if (v == 1) return true;

            if (u > v){
                long t = v;
                v = u;
                u = t;
            }
            v -= u;
        } while (v != 0);

        return false;
    }

    public static BigDecimal sqrt(BigDecimal A, final int SCALE){
        BigDecimal x0 = new BigDecimal("0");
        BigDecimal x1 = new BigDecimal(Math.sqrt(A.doubleValue()));
        BigDecimal TWO = BigDecimal.valueOf(2);
        while (!x0.equals(x1)) {
            x0 = x1;
            x1 = A.divide(x0, SCALE, BigDecimal.ROUND_HALF_UP);
            x1 = x1.add(x0);
            x1 = x1.divide(TWO, SCALE, BigDecimal.ROUND_HALF_UP);
        }
        return x1;
    }

    public static int modPow(long x, long y, long z){
        int result = 1;
        while (y > 0){
            if ((y & 1) == 1){
                result = (int)(result * x % z);
            }
            y >>= 1;
            x = x * x % z;
        }
        return result;
    }

    public static boolean isProbablyPrime(long n){
        if (n < 1373653) return isProbablyPrime(n, new int[]{2, 3});
        if (n < 9080171) return isProbablyPrime(n, new int[]{31, 73});
        if (n < 4759123141L) return isProbablyPrime(n, new int[]{2, 7, 61});
        if (n < 2152302898747L) return isProbablyPrime(n, new int[]{2, 3, 5, 7, 11});
        if (n < 3474749660383L) return isProbablyPrime(n, new int[]{2, 3, 5, 7, 11, 13});

        return isProbablyPrime(n, new int[]{2, 3, 5, 7, 11, 13, 17});

    }

    public static boolean isProbablyPrime(long n, int[] ar){
        for (int i = 0; i < ar.length; i++){
            if (Witness(ar[i], BigInteger.valueOf(n))) return false;
        }
        return true;
    }

    private static boolean Witness(int a, BigInteger n){
        int t = 0;
        BigInteger u = n.subtract(BigInteger.ONE);
        while (u.getLowestSetBit() != 0){
            t++;
            u = u.divide(BigInteger.valueOf(2));
        }

        BigInteger xi1 = BigInteger.valueOf(a).modPow(u, n);
        BigInteger xi2;

        for (int i = 0; i < t; i++){
            xi2 = xi1.modPow(BigInteger.valueOf(2), n);
            if (xi2.equals(BigInteger.ONE) && !xi1.equals(BigInteger.ONE) && xi1.compareTo(n.subtract(BigInteger.ONE)) != 0) return true;
            xi1 = xi2;
        }
        return !xi1.equals(BigInteger.ONE);
    }
}
