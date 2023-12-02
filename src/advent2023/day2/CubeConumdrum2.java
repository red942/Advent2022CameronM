package advent2023.day2;

import java.util.*;
import java.io.*;

public class CubeConumdrum2 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new File(
                System.getProperty("user.dir") + "/lib/advent2023/day02.txt"));

        int sum = 0;
        while (in.hasNextLine()) {
            String input = in.nextLine();
            sum += (pos(input.substring(input.indexOf(":") + 1)));
                
        }

        System.out.println(sum);
        in.close();
    }    

    public static int pos(String s) {
        boolean next = false;
        int maxB = 0, maxR = 0, maxG = 0;
        while (true) {
            String curr;
            if (s.indexOf(";") != -1) {
                curr = s.substring(0, s.indexOf(";"));
                s = s.substring(s.indexOf(";") + 1);
            } else {
                curr = s;
            }
            

            if (curr.contains("blue")) {
                if ( getVal(curr, curr.indexOf("blue")) > maxB)
                    maxB = getVal(curr, curr.indexOf("blue"));
            }
            if (curr.contains("red")) {
                if ( getVal(curr, curr.indexOf("red")) > maxR)
                    maxR = getVal(curr, curr.indexOf("red"));
            }
            if (curr.contains("green")) {
                if ( getVal(curr, curr.indexOf("green")) > maxG)
                    maxG = getVal(curr, curr.indexOf("green"));
            }

            if(next)
                return maxB * maxG * maxR;
            if (s.indexOf(";") == -1)
                next = true;
        }
    }

    public static int getVal(String s, int ind) {
        String val = "";
        for (int i = ind - 2; i >= 0; i--) {
            if (s.charAt(i) == ' ')
                break;
            val = s.charAt(i) + val;
        }
        return Integer.valueOf(val);
    }
}
