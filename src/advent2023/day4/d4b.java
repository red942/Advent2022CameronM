package advent2023.day4;

import common.*;
import java.util.*;
import java.io.*;

public class d4b {

    static int sum = 0;

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new File(
                System.getProperty("user.dir") + "/lib/advent2023/day04.txt"));

        ArrayList<String> cards = new ArrayList<>();
        while (in.hasNextLine()) {
            cards.add(in.nextLine());
        }


        for (int j = 0; j < cards.size(); j++) {
            inc(cards.get(j), cards);
            sum++;
        }

        System.out.println(sum);
        in.close();
    }    

    public static void inc(String card, ArrayList<String> cards) {
            int index = cards.indexOf(card);
            int total = 0;
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
            sum += total;
            for (int j = 0; j < total; j++)
                inc(cards.get(index + j + 1), cards);
    }
}
