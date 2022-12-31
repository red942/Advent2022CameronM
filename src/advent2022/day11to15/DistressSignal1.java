package advent2022.day11to15;
import java.util.*;
import java.io.*;

public class DistressSignal1 {
    public static void main(String[] args) throws FileNotFoundException{
        Scanner input = new Scanner(new File(
            System.getProperty("user.dir") + "/lib/advent2022/day13.txt"));

        int pair = 0;
        int sum = 0;
        while (input.hasNextLine()){

            String in1 = input.nextLine();

            if (in1.equals(""))
                continue;

            pair++;
            Listy l1 = Listy.fromString(in1);
            Listy l2 = Listy.fromString(input.nextLine());
           // System.out.println(l1.compareTo(l2));
            if (l1.compareTo(l2) == 1)
               sum += pair;
        }
        System.out.println(sum);
    }
    


}
