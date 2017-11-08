import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Robert on 5/12/2017.
 */
public class p059 {

    public int[] encrypt(List<Integer> message, int[] key){
        int[] encryptMessage = new int[message.size()];
        for (int i = 0; i < message.size(); i++){
            encryptMessage[i] = message.get(i) ^ key[i % 3];
        }
        return encryptMessage;
    }

    public int[] freqAnalysis(List<Integer> message){
        int max = 0;
        for (int val : message) {
            max = Math.max(max, val);
        }

        int[][] aMessage = new int[3][max+1];
        int[] key = new int[3];

        /*
            Looking for frequency of numbers, but must split into 3 groups between key is 3 chars long
            Set key[i] to most frequent number
         */
        for (int i = 0; i < message.size(); i++){
            int j = i % 3;
            aMessage[j][message.get(i)]++;
            if (aMessage[j][message.get(i)] > aMessage[j][key[j]]){
                key[j] = message.get(i);
            }
        }
        /*
            We assume the space is the most frequent, so we use XOR to get actually keys
         */
        int space = 32;
        for (int i = 0; i < 3; i++){
            key[i] = key[i] ^ space;
        }
        return key;
    }

    public p059(){
        ArrayList<Integer> listValues = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("p059_cipher.txt"));
            String input = br.readLine();
            input = input.replaceAll(",", " ");
            Scanner sc = new Scanner(input);
            int i = 0;
            while (sc.hasNextInt()) {
                int val = sc.nextInt();
                listValues.add(val);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        int[] keys = freqAnalysis(listValues);
        int[] unEncryptedMessage = encrypt(listValues, keys);
        int result = 0;
        for (int val : unEncryptedMessage){
            result += val;
        }
        System.out.println(result);
    }

    public static void main(String[] args){
        long start = System.nanoTime();
        new p059();
        double end = (System.nanoTime() - start)/(double)1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
