package advent2023.day5;
import java.util.*;

public class Mapping {
    ArrayList<long[]> ranges; //each long[] is of form start, dest, range, distance

    public Mapping(){
        ranges = new ArrayList<>();
    }

    public void add(long dest, long start, long range) {
        long[] temp = new long[4];
        temp[0] = start;
        temp[1] = dest;
        temp[2] = range;
        temp[3] = dest - start;
        ranges.add(temp);
    }

    public long eval(long num) {
        for (long[] range : ranges) 
            if (num < range[0]+range[2] && num >= range[0]) 
                return num + range[3];    
        return num;
    }

}
