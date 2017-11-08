import java.math.BigInteger;

/**
 * Created by Robert on 5/11/2017.
 */
public class p051 {

    private int[][] get5digitPatterns() {
        int[][] retVal = new int[4][];
        retVal[0] = new int[]{1,0,0,0,1};
        retVal[1] = new int[]{0,1,0,0,1};
        retVal[2] = new int[]{0,0,1,0,1};
        retVal[3] = new int[]{0,0,0,1,1};
        return retVal;
    }

    private int[][] get6digitPatterns() {
        int[][] retVal = new int[10][];
        retVal[0] = new int[] { 1, 1, 0, 0, 0, 1 };
        retVal[1] = new int[] { 1, 0, 1, 0, 0, 1 };
        retVal[2] = new int[] { 1, 0, 0, 1, 0, 1 };
        retVal[3] = new int[] { 1, 0, 0, 0, 1, 1 };
        retVal[4] = new int[] { 0, 1, 1, 0, 0, 1 };
        retVal[5] = new int[] { 0, 1, 0, 1, 0, 1 };
        retVal[6] = new int[] { 0, 1, 0, 0, 1, 1 };
        retVal[7] = new int[] { 0, 0, 1, 1, 0, 1 };
        retVal[8] = new int[] { 0, 0, 1, 0, 1, 1 };
        retVal[9] = new int[] { 0, 0, 0, 1, 1, 1 };
        return retVal;
    }

    private int[] fillPattern(int[] pattern, int number){
        int[] filledPattern = new int[pattern.length];
        int temp = number;
        for (int i = filledPattern.length - 1; i >= 0; i--){
            if (pattern[i] == 1){
                filledPattern[i] = temp % 10;
                temp /= 10;
            } else {
                filledPattern[i] = -1;
            }
        }
        return filledPattern;
    }

    private int generateNumber(int repNumber, int[] filledPattern){
        int temp = 0;
        for (int i = 0; i < filledPattern.length; i++){
            temp = temp * 10;
            temp += (filledPattern[i] == -1) ? repNumber : filledPattern[i];
        }
        return temp;
    }

    private int familySize(int repeatingNumber, int[] pattern){
        int familySize = 1;
        for (int i = repeatingNumber + 1; i < 10; i++){
            if (BigInteger.valueOf(generateNumber(i, pattern)).isProbablePrime(10)){
                familySize++;
            }
        }
        return familySize;
    }

    public p051(){
        int[][] fiveDigitPattern = get5digitPatterns();
        int[][] sixDigitPattern = get6digitPatterns();
        int result = Integer.MAX_VALUE;

        for (int i = 11; i < 1000; i += 2){
            if (i % 5 == 0) continue;
            int[][] patterns = (i < 100) ? fiveDigitPattern : sixDigitPattern;

            for (int j = 0; j < patterns.length; j++){
                for (int k = 0; k < 3; k++){
                    if (patterns[j][0] == 0 && k == 0) continue;
                    int[] pattern = fillPattern(patterns[j], i);
                    int candidate = generateNumber(k, pattern);

                    if (candidate < result && BigInteger.valueOf(candidate).isProbablePrime(10)){
                        if (familySize(k, pattern) == 8)
                            result = candidate;
                        break;
                    }
                }
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args){
        long start = System.nanoTime();
        new p051();
        double end = (System.nanoTime() - start)/(double)1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
