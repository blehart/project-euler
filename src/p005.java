/**
 * Created by Robert on 5/8/2017.
 */
public class p005 {

    public p005(){
        for(int i = 1;;i++){
            if (i%11==0 && i%12==0 && i%13==0 && i%14==0 && i%15==0 && i%16==0 && i%17==0 && i%18==0 && i%19==0 && i%20==0){
                System.out.println(i);
                break;
            }
        }
    }

    public static void main(String[] args){
        long start = System.nanoTime();
        new p005();
        double end = (System.nanoTime() - start)/(double)1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
