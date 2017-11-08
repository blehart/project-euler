/**
 * Created by Robert on 5/7/2017.
 */
public class p018 {


    int[][] triangle = {
            {4, 62, 98, 27, 23, 9, 70, 98, 73, 93, 38, 53, 60, 4, 23},
            {63, 66, 4, 68, 89, 53, 67, 30, 73, 16, 69, 87, 40, 31},
            {91, 71, 52, 38, 17, 14, 91, 43, 58, 50, 27, 29, 48},
            {70, 11, 33, 28, 77, 73, 17, 78, 39, 68, 17, 57},
            {53, 71, 44, 65, 25, 43, 91, 52, 97, 51, 14},
            {41, 48, 72, 33, 47, 32, 37, 16, 94, 29},
            {41, 41, 26, 56, 83, 40, 80, 70, 33},
            {99, 65, 4, 28, 6, 16, 70, 92},
            {88, 2, 77, 73, 7, 63, 67},
            {19, 1, 23, 75, 3, 34},
            {20, 4, 82, 47, 65},
            {18, 35, 87, 10},
            {17, 47, 82},
            {95, 64},
            {75}};


    public p018(){
        for (int i = 1; i < 15; i++){
            for (int j = 0; j < 15-i; j++){
                triangle[i][j] += Math.max(triangle[i-1][j], triangle[i-1][j+1]);
            }
        }
        System.out.println(triangle[14][0]);
    }

    public static void main(String[] args){
        long start = System.nanoTime();
        new p018();
        double end = (System.nanoTime() - start)/(double)1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
