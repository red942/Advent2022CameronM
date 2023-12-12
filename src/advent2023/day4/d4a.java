package advent2023.day4;

import common.*;
import java.util.*;
import java.io.*;

public class d4a {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new File(
                System.getProperty("user.dir") + "/lib/advent2023/day04.txt"));

        int sum = 0;
        while (in.hasNextLine()) {
            int total = 0;
            String card = in.nextLine();
            card = card.substring(card.indexOf(":") + 2);
            String[] nums = card.split(" ");
            int i = 0;
            HashSet<Integer> set = new HashSet<>();
            while (!nums[i].equals("|")) {
                if (nums[i].equals("")) {
                    i++;
                    continue;
                }
                
                set.add(Integer.valueOf(nums[i]));
                i++;
            }
            i++;
            while (i != nums.length) {
                if (nums[i].equals("")) {
                    i++;
                    continue;
                }
                if (set.contains(Integer.valueOf(nums[i])))
                    total++;
                i++;
            }
            sum += Math.pow(2, total-1);
        }

        System.out.println(sum);
        in.close();
    }    
}
