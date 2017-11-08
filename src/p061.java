import java.util.HashSet;

/**
 * Created by Robert on 5/12/2017.
 */
public class p061 {

    HashSet<Integer>[] sets;
    int[] solution;

    public HashSet<Integer> generateNumbers(int type){
        HashSet<Integer> numbers = new HashSet<>();
        int number = 0;

        for (int n = 1; number < 10000; n++) {
            switch (type) {
                case 0:
                    number = n * (n + 1) / 2;
                    break;
                case 1:
                    number = n * n;
                    break;
                case 2:
                    number = n * (3 * n - 1) / 2;
                    break;
                case 3:
                    number = n * (2 * n - 1);
                    break;
                case 4:
                    number = n * (5 * n - 3) / 2;
                    break;
                case 5:
                    number = n * (3 * n - 2);
                    break;
            }
            if (number > 999 && (number%100)/10 != 0) numbers.add(number);
        }
        return numbers;
    }

    public boolean arrayContains(int[] array, int x){
        for (int i : array) {
            if (i == x) return true;
        }
        return false;
    }

    public boolean searchMaps(int last, int length){
        for (int i = 0; i < solution.length; i++){
            if (solution[i] != 0) continue;
            for (Integer j : sets[i]){
                if (!arrayContains(solution, j) && j / 100 == solution[last] % 100){
                    solution[i] = j;
                    if (length == 5 && solution[5] / 100 == solution[i] % 100) return true;
                    if (searchMaps(i, length+1)) return true;
                }
            }
            solution[i] = 0;
        }
        return false;
    }

    public p061(){
        sets = new HashSet[6];
        for (int i = 0; i < 6; i++){
            sets[i] = generateNumbers(i);
        }
        solution = new int[]{0, 0, 0, 0, 0, 0};
        for (Integer i : sets[5]){
            solution[5] = i;
            if (searchMaps(5, 1)) break;
        }
        int result = 0;
        for (int i : solution) {
            result += i;
            System.out.print(i + ", ");
        }
        System.out.println(result);
    }

    public static void main(String[] args){
        long start = System.nanoTime();
        new p061();
        double end = (System.nanoTime() - start)/(double)1000000;
        System.out.println("\nSolved in " + end + " ms");
    }


}
