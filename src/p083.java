import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by Robert on 5/15/2017.
 */
public class p083 {

    int[][] grid;
    int[][] dist;
    final int size = 80;

    public int dijkstra(){
        PriorityQueue<Pair> Q = new PriorityQueue<>((Pair p1, Pair p2) -> (dist[p1.x][p1.y] - dist[p2.x][p2.y]));
        dist = new int[size][size];
        boolean[][] visited = new boolean[size][size];
        Pair[][] prev = new Pair[size][size];

        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                dist[i][j] = Integer.MAX_VALUE;
                Q.add(new Pair(i, j));
            }
        }
        dist[0][0] = grid[0][0];

        while (!Q.isEmpty()){
            Pair u = Q.poll();
            visited[u.x][u.y] = true;
            if (u.equals(new Pair(size-1, size-1))) break;
            System.out.println(u.x + ", " + u.y);

            for (int i = 0; i < 4; i++){
                List<Pair> neighbors = new ArrayList<>();
                if (u.x > 0) neighbors.add(new Pair(u.x - 1, u.y));
                if (u.x < size-1) neighbors.add(new Pair(u.x + 1, u.y));
                if (u.y > 0) neighbors.add(new Pair(u.x, u.y - 1));
                if (u.y < size-1) neighbors.add(new Pair(u.x, u.y + 1));

                for (Pair v : neighbors) {
                    if (visited[v.x][v.y]) continue;
                    int alt = dist[u.x][u.y] + grid[v.x][v.y];
                    if (alt < dist[v.x][v.y]) {
                        dist[v.x][v.y] = alt;
                        prev[v.x][v.y] = u;
                    }
                    Q.remove(v);
                    Q.add(v);
                }
            }
        }

        Pair start = new Pair(0, 0);
        Pair cur = new Pair(size-1, size-1);
        int sum = 0;
        while (!cur.equals(start)){
            System.out.println("(" + cur.x + ", " + cur.y + ")");
            sum += grid[cur.x][cur.y];
            cur = prev[cur.x][cur.y];
        }
        return sum + grid[0][0];
    }

    public p083() {
        grid = new int[size][size];
        try {
            BufferedReader br = new BufferedReader(new FileReader("p081_matrix.txt"));
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                for (int j = 0; j < row.length; j++) {
                    grid[i][j] = Integer.parseInt(row[j]);
                }
                i++;
            }
            System.out.println(dijkstra());
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        new p083();
        double end = (System.nanoTime() - start) / (double) 1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
