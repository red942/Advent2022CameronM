package advent2023.day2;

import common.*;
import java.util.*;
import java.io.*;

public class Day2 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new File(
                System.getProperty("user.dir") + "/lib/advent2023/day.txt"));

        int sum = 0;
        while (in.hasNextLine()) {
            String input = in.nextLine();
            if (pos(input.substring(input.indexOf(":") + 1)))
                sum += Integer.valueOf(input.substring(input.indexOf(" ") + 1, input.indexOf(":")));
        }

        System.out.println(sum);
        in.close();
    }    

    public static boolean pos(String s) {
        while (true) {
            String curr = s.substring(0, s.indexOf(";"));
            s = s.substring(s.indexOf(";") + 1);
            if (curr.contains("blue")) {
                if ( getVal(s, s.indexOf("blue")) > 14))
                    return false;
            }
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
