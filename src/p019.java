/**
 * Created by Robert on 5/7/2017.
 */
public class p019 {

    int dayOfWeek, month, year, result;

    public int addMonth(){

        switch(month){
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 2:
                if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
                    return 29;
                }
        }
        return 28;
    }

    public p019(){
        dayOfWeek = 1; //Monday
        month = 1; //January
        year = 1900;
        result = 0;

        while (year < 2001){

            dayOfWeek = (dayOfWeek + addMonth()) % 7;
            month++;

            if (year > 1900 && dayOfWeek == 0){
                result++;
            }
            if (month == 13) {
                month = 1;
                year++;
            }
        }
        System.out.println(result);
    }


    public static void main(String[] args){
        long start = System.nanoTime();
        new p019();
        double end = (System.nanoTime() - start)/(double)1000000;
        System.out.println("\nSolved in " + end + " ms");
    }
}
