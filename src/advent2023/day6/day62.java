package advent2023.day6;

import java.util.*;
import java.io.*;

public class day62 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new File(
                System.getProperty("user.dir") + "/lib/advent2023/day06.txt"));

        String time = "";
        String dist = "";

        for (long i = 0; i < 4; i++) {
            time += in.next();
        }
        for (long i = 0; i < 4; i++) {
            dist += in.next();
        }

        System.out.println(max(Long.valueOf(time), Long.valueOf(dist)) - min(Long.valueOf(time), Long.valueOf(dist)) + 1);

        in.close();
    }    

    public static long min(long t, long d) {
        for (long i = 0; i <= t; i++) {
            if (i * (t-i) > d)
                return i;
        }
        return -1;
    }
    public static long max(long t, long d) {
        for (long i = t; i >= 0; i--) {
            if (i * (t-i) > d)
                return i;
        }
        return -1;
    }
}
