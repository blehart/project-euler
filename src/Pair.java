/**
 * Created by Robert on 5/23/2017.
 */
public class Pair {
    int x;
    int y;

    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int hashCode(){
        return Integer.hashCode(x) * 31 + Integer.hashCode(y);
    }

    public boolean equals(Object o){
        if (o instanceof Pair) {
            Pair p = (Pair)o;
            return p.x == x && p.y == y;
        }
        return false;
    }

    public String toString(){
        return "(" + x + "," + y + ")" ;
    }
}