package advent2022.day1to5;
import java.util.Scanner;

/*code finished by Cameron Miller 10:39AM 12/1/2022 (CST), this is day 1, challenge 1*/
/*for the input, paste in the values to the terminal and then type a new line saying "done" after a blank line*/

public class CalorieCounting1 {
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        int elfHigh = 0;
        int elfNum = 0;
        int elfNumTemp = 0;
        int elfTemp = 0;
        while (true){
            String num = stdin.nextLine();
            if (num.equals("done"))
                break;
            if (num.equals("")){
                elfNumTemp++;
                if (elfTemp > elfHigh){
                    elfHigh = elfTemp;
                    elfNum = elfNumTemp;
                }
                elfTemp = 0;
                continue;
            }
            elfTemp += Integer.valueOf(num);
        }
        System.out.println(elfNum);
        System.out.println(elfHigh);
        stdin.close();
    }
}
