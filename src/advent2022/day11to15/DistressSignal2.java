package advent2022.day11to15;
import java.util.*;
import java.io.*;

public class DistressSignal2 {
    public static void main(String[] args) throws FileNotFoundException{
        Scanner input = new Scanner(new File(
            System.getProperty("user.dir") + "/lib/advent2022/day13.txt"));

        Listy[] listies = new Listy[302];
        int cnt = 0;
        while (input.hasNextLine()){

            String in = input.nextLine();

            if (in.equals(""))
                continue;

            listies[cnt] = Listy.fromString(in);
            cnt++;
        }
        Arrays.sort(listies, (a, b) -> b.compareTo(a));
        int product = 1;
        for (int i = 0; i < 302; i++){
            if (listies[i].equals(Listy.fromString("[[2]]")) || listies[i].equals(Listy.fromString("[[6]]")))
                product *= (i+1);
        }
        System.out.println(product);
            
    }
    


}
