import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Robert on 5/9/2017.
 */
public class p024 {

    public p024(){
        ArrayList<Long> permus = new ArrayList<>();
        for (int a = 0; a < 10; a++){
            for (int b = 0; b < 10; b++){
                if (b == a) continue;
                for (int c = 0; c < 10; c++){
                    if (c == a || c == b) continue;
                    for (int d = 0; d < 10; d++){
                        if (d == a || d == b || d == c) continue;
                        for (int e = 0; e < 10; e++){
                            if (e == a || e == b || e == c || e == d) continue;
                            for (int f = 0; f < 10; f++){
                                if (f == a || f == b || f == c || f == d || f == e) continue;
                                for (int g = 0; g < 10; g++){
                                    if (g == a || g == b || g == c || g == d || g == e || g == f) continue;
                                    for (int h = 0; h < 10; h++){
                                        if (h == a || h == b || h == c || h == d || h == e || h == f || h == g) continue;
                                        for (int i = 0; i < 10; i++){
                                            if (i == a || i == b || i == c || i == d || i == e || i == f || i == g || i == h) continue;
                                            for (int j = 0; j < 10; j++){
                                                if (j == a || j == b || j == c || j == d || j == e || j == f || j == g || j == h || j == i) continue;
                                                permus.add(j + i * 10 + h * 100 + g * 1000 + f * 10000 + e * 100000 + d * 1000000 + c * 10000000 + b * 100000000 + a * 1000000000L);
                                                System.out.println(a + ": " + b);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        Collections.sort(permus);
        System.out.println(permus.get(999999));
    }

    public static void main(String[] args){
        long start = System.nanoTime();
        new p024();
        double end = (System.nanoTime() - start)/(double)1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
