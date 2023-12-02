package advent2023.day2;

import java.util.*;
import java.io.*;

public class CubeConumdrum1 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new File(
                System.getProperty("user.dir") + "/lib/advent2023/day02.txt"));

        int sum = 0;
        while (in.hasNextLine()) {
            String input = in.nextLine();
            if (pos(input.substring(input.indexOf(":") + 1))) {
                sum += Integer.valueOf(input.substring(input.indexOf(" ") + 1, input.indexOf(":")));
            }
        }

        System.out.println(sum);
        in.close();
    }    

    public static boolean pos(String s) {
        boolean next = false;
        while (true) {
            String curr;
            if (s.indexOf(";") != -1) {
                curr = s.substring(0, s.indexOf(";"));
                s = s.substring(s.indexOf(";") + 1);
            } else {
                curr = s;
            }
            

            if (curr.contains("blue")) {
                if ( getVal(curr, curr.indexOf("blue")) > 14)
                    return false;
            }
            if (curr.contains("red")) {
                if ( getVal(curr, curr.indexOf("red")) > 12)
                    return false;
            }
            if (curr.contains("green")) {
                if ( getVal(curr, curr.indexOf("green")) > 13)
                    return false;
            }

            if(next)
                return true;
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
