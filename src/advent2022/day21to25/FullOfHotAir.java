package advent2022.day21to25;
import java.util.*;
import java.io.*;

public class FullOfHotAir {
    public static void main(String[] args) throws FileNotFoundException{
        Scanner input = new Scanner(new File(
            System.getProperty("user.dir") + "/lib/advent2022/day25.txt"));

        long sum = 0;
        while (input.hasNextLine()){
            String num = input.nextLine();
            for (int i = num.length()-1; i >= 0; i--){
                switch (num.charAt(i)){
                    case '2':
                        sum += (long)(2*Math.pow(5, num.length()-i-1));
                        break;
                    case '1':
                        sum += (long)(Math.pow(5, num.length()-i-1));
                        break;
                    case '0':
                        break;
                    case '-':
                        sum -= (long)(Math.pow(5, num.length()-i-1));
                        break;
                    case '=':
                        sum -= (long)(2*Math.pow(5, num.length()-i-1));
                        break;
                }
            }
        }
        System.out.println(decToSnafu(sum));
    }

    public static String decToSnafu(long num){
        String out = "";
        char[] symbols = {'0', '1', '2', '=', '-'};

        while (num != 0){
            out = symbols[(int)(num % 5)] + out;
            num = (num+2)/5;
        }

        return out;
    }
}
