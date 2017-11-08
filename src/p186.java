/**
 * Created by Robert on 6/8/2017.
 */
public class p186 {

    int mil = 1000000;
    int[] parent = new int[mil], height = new int[mil], friends = new int[mil], s = new int[55];

    public void prep(int i){
        parent[i] = i;  // root of tree
        height[i] = 0;  // tree has height 0
        friends[i] = 1; // tree has 1 element
    }

    // Follow parent until we reach root of tree
    public int head(int x){
        if (parent[x] == x) return x;
        return parent[x] = head(parent[x]);
    }

    // If x and y aren't already in the same tree, we need to combine their trees
    public void combine(int x, int y){
        int xhead = head(x), yhead = head(y);
        if (xhead != yhead){
            friends[xhead] = friends[yhead] = friends[xhead] + friends[yhead];
            // Make the root of one tree, the parent of the other's root
            // We balance the tree to make head() faster
            if (height[xhead] > height[yhead]) parent[yhead] = xhead;
            else if (height[yhead] > height[xhead]) parent[xhead] = yhead;
            else {
                parent[yhead] = xhead;
                height[xhead]++;
            }
        }
    }

    public int sk (int k){
        if (k < 55) return (int)((100003 - 200003*(k+1) + 300007L * Math.pow(k+1, 3)) % mil);
        return (s[(k-24+55)%55] + s[k%55])%mil;
    }

    public p186() {
        int k = 0, miss = 0;
        for (int i = 0; i < mil; i++){
            prep(i);
        }
        while (friends[head(524287)] < 990000){
            int u, v;
            u = s[k%55] = sk(k);
            k++;
            v = s[k%55] = sk(k);
            k++;
            if (u == v) miss++;
            else combine(u, v);
        }
        System.out.println(k/2-miss);
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        new p186();
        double end = (System.nanoTime() - start) / (double) 1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
