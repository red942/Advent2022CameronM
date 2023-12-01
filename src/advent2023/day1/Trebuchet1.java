package advent2023.day1;

import java.util.*;
import java.io.*;

public class Trebuchet1 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new File(
                System.getProperty("user.dir") + "/lib/advent2023/day01.txt"));

        int sum = 0;
        while (in.hasNextLine()) {
            String ln = in.nextLine();
            String num = "";
            for (int i = 0; i < ln.length(); i++) 
                if (ln.charAt(i) >= '0' && ln.charAt(i) <= '9') {
                    num += ln.charAt(i);
                    break;
                }
    
            for (int i = ln.length() - 1; i >= 0; i--) 
                if (ln.charAt(i) >= '0' && ln.charAt(i) <= '9') {
                    num += ln.charAt(i);
                    break;
                }
            
            sum += Integer.valueOf(num);
        }
        
        System.out.println(sum);
        in.close();
    }    
}
