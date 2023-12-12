package advent2023.day3;

import common.*;
import java.util.*;
import java.io.*;

public class Day3_1 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new File(
                System.getProperty("user.dir") + "/lib/advent2023/day03.txt"));

        //store innput as str arr
        //go through uintil number, get number, use indecies to check (store first and last index oif the number)
        //if valid add it to the sum\
        //oputput the sum

        ArrayList<String> schem = new ArrayList<>();
        while (in.hasNextLine()) {
            schem.add(in.nextLine());
        }
        int length = schem.get(0).length();

        int sum = 0;
        for (int i = 0; i < schem.size(); i++) {
            boolean isNum = false;
            String num = "";
            for (int j = 0; j < length; j++) {
                if (schem.get(i).charAt(j) >= '0' && schem.get(i).charAt(j) <= '9' ) {
                    isNum = true;
                    num += schem.get(i).charAt(j);
                } else if (isNum) {
                    isNum = false;
                    if (i == 0) 
                        sum += valid(num, schem.get(i), schem.get(i+1), true, j - 1);
                    else if (i == schem.size() - 1)
                        sum += valid(num, schem.get(i), schem.get(i - 1), j - 1);
                    else
                        sum += valid(num, schem.get(i), schem.get(i + 1), schem.get(i - 1), j - 1);
                    
                    num = "";
                }
            }
            if (num != "") {
                
                if (i == 0) 
                        sum += valid(num, schem.get(i), schem.get(i+1), true, length - 1);
                    else if (i == schem.size() - 1)
                        sum += valid(num, schem.get(i), schem.get(i - 1), length - 1);
                    else
                        sum += valid(num, schem.get(i), schem.get(i + 1), schem.get(i - 1), length - 1);
                    
                    num = "";
            }
                

        }
        
        // 535463 too low
        // 537347 too high
        // 537249 wrong
        System.out.println(sum);
        in.close();
    }    

    public static boolean sym(char c) {
        if (c == '/' || c == '+' || c == '-' || c == '*' || c == '&' || c == '$' || c == '@' || c == '#' || c == '=' || c == '%')
            return true;
        return false;
    }

    //..234 3
    public static int valid(String n, String curr, String after, boolean temp, int end) {
        int num = Integer.valueOf(n);
        int strt = end - n.length() + 1;

        if (strt != 0 && sym(curr.charAt(strt-1)))
            return num;
        if (end != curr.length() - 1 && sym(curr.charAt(end + 1)))
            return num;
        
        for (int i = (strt != 0)? strt-1:strt; (i <= end + 1) && (end != curr.length() - 1 || i <= end); i++) 
            if (sym(after.charAt(i)))
                return num;
        
        return 0;    
    }
    public static int valid(String n, String curr, String before, int end) {
        int num = Integer.valueOf(n);
        int strt = end - n.length() + 1;

        if (strt != 0 && sym(curr.charAt(strt-1)))
            return num;
        if (end != curr.length() - 1 && sym(curr.charAt(end + 1)))
            return num;
        
        
        for (int i = (strt != 0)? strt-1:strt; (i <= end + 1) && (end != curr.length() - 1 || i <= end); i++) 
            if (sym(before.charAt(i)))
                return num;
        
        return 0;    
    }
    public static int valid(String n, String curr, String after, String before, int end) {
        int num = Integer.valueOf(n);
        int strt = end - n.length() + 1;

        if (strt != 0 && sym(curr.charAt(strt-1)))
            return num;
        if (end != curr.length() - 1 && sym(curr.charAt(end + 1)))
            return num;
        
        for (int i = (strt != 0)? strt-1:strt; (i <= end + 1) && (end != curr.length() - 1 || i <= end); i++) 
            if (sym(after.charAt(i)))
                return num;
        
        for (int i = (strt != 0)? strt-1:strt; (i <= end + 1) && (end != curr.length() - 1 || i <= end); i++) 
            if (sym(before.charAt(i)))
                return num;
        
        return 0;    
    }
}
