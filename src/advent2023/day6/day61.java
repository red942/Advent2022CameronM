package advent2023.day6;

import common.*;
import java.util.*;
import java.io.*;

public class day61 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new File(
                System.getProperty("user.dir") + "/lib/advent2023/day06.txt"));

        int[] times = new int[4];
        int[] dists = new int[4];

        for (int i = 0; i < times.length; i++) {
            times[i] = in.nextInt();
        }
        for (int i = 0; i < times.length; i++) {
            dists[i] = in.nextInt();
        }

        int prod = 1;
        for (int i = 0; i < dists.length; i++) {
            prod *= (max(times[i], dists[i]) - min(times[i], dists[i]) + 1);
        }

        System.out.println(prod);

        in.close();
    }    

    public static int min(int t, int d) {
        for (int i = 0; i <= t; i++) {
            if (i * (t-i) > d)
                return i;
        }
        return -1;
    }
    public static int max(int t, int d) {
        for (int i = t; i >= 0; i--) {
            if (i * (t-i) > d)
                return i;
        }
        return -1;
    }
}
