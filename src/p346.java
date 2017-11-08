import java.util.HashSet;


public class p346 {

    public p346() {
        long limit = (long) Math.pow(10, 12);
        long sqrt = (long) Math.sqrt(limit);

        HashSet<Long> reps = new HashSet<>();
        reps.add(1L);

        for (long b = 2; b < sqrt; b++) {
            long num = (b * b - 1) / (b - 1);
            while (true) {
                num = num * b + 1;
                if (num >= limit) break;
                reps.add(num);
            }
        }
        long sum = 0;
        for (long x : reps) {
            sum += x;
        }
        System.out.println(sum);
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        new p346();
        double end = (System.nanoTime() - start) / (double) 1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
