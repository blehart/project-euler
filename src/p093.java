/**
 * Created by Robert on 5/17/2017.
 */
public class p093 {

    public double op(double x, double y, int op){
        switch (op){
            case 0:
                return x + y;
            case 1:
                return x - y;
            case 2:
                return x * y;
            case 3:
                if (y == 0) return -1;
                return (double)x / y;
        }
        return -1;
    }

    public p093() {
        int[] best = null;
        int bestcount = 0;

        int[] combo = {0, 1, 2, 3};
        while (combo != null){
            boolean[] results = new boolean[3024];
            int[] permu = combo.clone();

            while (permu != null){

                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {
                        for (int k = 0; k < 4; k++) {
                            double value = op(op(op(permu[0], permu[1], i), permu[2], j), permu[3], k);
                            if (value == (int)value && value < 3024 && value > 0) results[(int)value] = true;

                            value = op(op(op(permu[1], permu[2], j), permu[0], i), permu[3], k);
                            if (value == (int)value && value < 3024 && value > 0) results[(int)value] = true;

                            value = op(permu[0], op(op(permu[1], permu[2], j), permu[3], k), i);
                            if (value == (int)value && value < 3024 && value > 0) results[(int)value] = true;

                            value = op(permu[0], op(permu[1],op(permu[2], permu[3], k),j),i);
                            if (value == (int)value && value < 3024 && value > 0) results[(int)value] = true;

                            value = op(op(permu[0], permu[1], i), op(permu[2], permu[3], k), j);
                            if (value == (int)value && value < 3024 && value > 0) results[(int)value] = true;
                        }
                    }
                }

                int i = 1;
                while (results[i]) i++;
                if (i > bestcount){
                    best = combo.clone();
                    bestcount = i;
                }
                permu = Operations.nextPermutation(permu);
            }
            combo = Operations.nextCombo(10, 4, combo);
        }
        for (int i : best) System.out.print(i);
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        new p093();
        double end = (System.nanoTime() - start) / (double) 1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
