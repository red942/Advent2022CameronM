package advent2023.day5;

import java.util.*;
import java.io.*;

public class hell1 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new File(
                System.getProperty("user.dir") + "/lib/advent2023/day05.txt"));

        ArrayList<Long> seeds = new ArrayList<>();

        String ln = in.nextLine();
        String[] inp = ln.split(" ");
        for (int i = 1; i < inp.length; i++) {
            seeds.add(Long.valueOf(inp[i]));
        }

        String curr;
        Mapping soil = new Mapping();
        curr = ln = in.nextLine();
        ln = in.nextLine();
        ln = in.nextLine();
        while (!ln.equals(curr)) {
            String[] tempS = ln.split(" ");
            long[] temp = new long[tempS.length];
            for (int i = 0; i < temp.length; i++) 
                temp[i] = Long.valueOf(tempS[i]);
            soil.add(temp[0], temp[1], temp[2]);
            ln = in.nextLine();
        }
        Mapping fert = new Mapping();
        ln = in.nextLine();
        ln = in.nextLine();
        while (!ln.equals(curr)) {
            String[] tempS = ln.split(" ");
            long[] temp = new long[tempS.length];
            for (int i = 0; i < temp.length; i++) 
                temp[i] = Long.valueOf(tempS[i]);
            fert.add(temp[0], temp[1], temp[2]);
            ln = in.nextLine();
        }
        Mapping water = new Mapping();
        ln = in.nextLine();
        ln = in.nextLine();
        while (!ln.equals(curr)) {
            String[] tempS = ln.split(" ");
            long[] temp = new long[tempS.length];
            for (int i = 0; i < temp.length; i++) 
                temp[i] = Long.valueOf(tempS[i]);
            water.add(temp[0], temp[1], temp[2]);
            ln = in.nextLine();
        }
        Mapping light = new Mapping();
        ln = in.nextLine();
        ln = in.nextLine();
        while (!ln.equals(curr)) {
            String[] tempS = ln.split(" ");
            long[] temp = new long[tempS.length];
            for (int i = 0; i < temp.length; i++) 
                temp[i] = Long.valueOf(tempS[i]);
            light.add(temp[0], temp[1], temp[2]);
            ln = in.nextLine();
        }
        Mapping tempe = new Mapping();
        ln = in.nextLine();
        ln = in.nextLine();
        while (!ln.equals(curr)) {
            String[] tempS = ln.split(" ");
            long[] temp = new long[tempS.length];
            for (int i = 0; i < temp.length; i++) 
                temp[i] = Long.valueOf(tempS[i]);
            tempe.add(temp[0], temp[1], temp[2]);
            ln = in.nextLine();
        }
        Mapping hum = new Mapping();
        ln = in.nextLine();
        ln = in.nextLine();
        while (!ln.equals(curr)) {
            String[] tempS = ln.split(" ");
            long[] temp = new long[tempS.length];
            for (int i = 0; i < temp.length; i++) 
                temp[i] = Long.valueOf(tempS[i]);
            hum.add(temp[0], temp[1], temp[2]);
            ln = in.nextLine();
        }
        Mapping loc = new Mapping();
        ln = in.nextLine();
        ln = in.nextLine();
        while (!ln.equals(curr)) {
            String[] tempS = ln.split(" ");
            long[] temp = new long[tempS.length];
            for (int i = 0; i < temp.length; i++) 
                temp[i] = Long.valueOf(tempS[i]);
            loc.add(temp[0], temp[1], temp[2]);
            try {
                ln = in.nextLine();
            } catch (NoSuchElementException e) {
                break;
            }
        }

        long min = Long.MAX_VALUE;
        for (Long seed : seeds) {
            Long val = loc.eval(hum.eval(tempe.eval(light.eval(water.eval(fert.eval(soil.eval(seed)))))));
            if (val < min) {
                min = val;
            }
        }

        System.out.println(min);

        in.close();
    }    
}
