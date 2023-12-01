package advent2023.day1;

import java.util.*;
import java.io.*;

public class Trebuchet2 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new File(
                System.getProperty("user.dir") + "/lib/advent2023/day01.txt"));

        int sum = 0;
        while (in.hasNextLine()) {
            String ln = in.nextLine();
            String num = "";
            for (int i = 0; i < ln.length(); i++) {
                if (ln.charAt(i) >= '0' && ln.charAt(i) <= '9') {
                    num += ln.charAt(i);
                    break;
                }

                String bef = num;
                if (ln.substring(0, i + 1).contains("one")) 
                    num += '1';
                else if (ln.substring(0, i + 1).contains("two"))
                    num += '2';
                else if (ln.substring(0, i + 1).contains("three"))
                    num += '3';
                else if (ln.substring(0, i + 1).contains("four"))
                    num += '4';
                else if (ln.substring(0, i + 1).contains("five"))
                    num += '5';
                else if (ln.substring(0, i + 1).contains("six"))
                    num += '6';
                else if (ln.substring(0, i + 1).contains("seven"))
                    num += '7';
                else if (ln.substring(0, i + 1).contains("eight"))
                    num += '8';
                else if (ln.substring(0, i + 1).contains("nine"))
                    num += '9';
                else if (ln.substring(0, i + 1).contains("zero"))
                    num += '0';

                if (!num.equals(bef))
                    break;
            }

            for (int i = ln.length() - 1; i >= 0; i--) {
                if (ln.charAt(i) >= '0' && ln.charAt(i) <= '9') {
                    num += ln.charAt(i);
                    break;
                }

                String bef = num;
                if (ln.substring(i).contains("one")) 
                    num += '1';
                else if (ln.substring(i).contains("two"))
                    num += '2';
                else if (ln.substring(i).contains("three"))
                    num += '3';
                else if (ln.substring(i).contains("four"))
                    num += '4';
                else if (ln.substring(i).contains("five"))
                    num += '5';
                else if (ln.substring(i).contains("six"))
                    num += '6';
                else if (ln.substring(i).contains("seven"))
                    num += '7';
                else if (ln.substring(i).contains("eight"))
                    num += '8';
                else if (ln.substring(i).contains("nine"))
                    num += '9';
                else if (ln.substring(i).contains("zero"))
                    num += '0';

                if (!num.equals(bef))
                    break;
            }
            sum += Integer.valueOf(num);
        }
        
        System.out.println(sum);
        in.close();
    }    
}
