import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.PriorityQueue;

/**
 * Created by Robert on 5/23/2017.
 */
public class p107 {

    int[][] matrix;
    PriorityQueue<Pair> heap;
    boolean[] visited;

    public void addToHeap(int row){
        for (int i = 0; i < 40; i++){
            if ((!visited[i] || !visited[row]) && matrix[row][i] != -1){
                heap.add(new Pair(row, i));
            }
        }
    }

    public p107() {

        matrix = new int[40][40];
        heap = new PriorityQueue<>((Pair p1, Pair p2) -> matrix[p1.x][p1.y] - matrix[p2.x][p2.y]);
        visited = new boolean[40];
        int result = 0;
        int initial = 0;
        int min = Integer.MAX_VALUE;
        Pair minPair = null;
        try {
            BufferedReader br = new BufferedReader(new FileReader("p107_network.txt"));
            int i = 0;
            String line;
            while ((line = br.readLine()) != null){
                String[] split = line.split(",");
                for (int j = 0; j < split.length; j++){
                    if (split[j].equals("-")){
                        matrix[i][j] = -1;
                    } else {
                        matrix[i][j] = Integer.parseInt(split[j]);
                        initial += matrix[i][j];
                        if (matrix[i][j] < min){
                            min = matrix[i][j];
                            minPair = new Pair(i, j);
                        }
                    }
                }
                i++;
            }
        } catch (IOException e){
            e.printStackTrace();
        }

        heap.add(minPair);
        while(!heap.isEmpty()){
            Pair p = heap.poll();
            if (!visited[p.x] || !visited[p.y]) {
                result += matrix[p.x][p.y];
                visited[p.x] = true;
                visited[p.y] = true;
                addToHeap(p.x);
                addToHeap(p.y);
            }
        }
        System.out.println((initial/2) - result);

    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        new p107();
        double end = (System.nanoTime() - start) / (double) 1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
