package advent2022.day11to15;
import java.util.*;
import java.io.*;

public class BeaconExclusionZone1 {
    public static void main(String[] args) throws FileNotFoundException{
        Scanner input = new Scanner(new File(
            System.getProperty("user.dir") + "/lib/advent2022/day15.txt"));


        //calculate the effect on the row, without calculating any of the diamond.

        //find distance, by subtracting points and then adding x and y
        //if the y of sensor +- that doesnt cross 2 mil, don't worry about it
        //if it is exactly distance away, it will make 1 #, if its 1 less than distance, 
        //it will make 3 #s, then 5#s and so on. (center of these is the sensor's x)
        char[] row2_000_000 = new char[10_000_001];
        for (int i = 0; i < 10_000_001; i++)
                row2_000_000[i] = '.';
        
        while (input.hasNextLine()){
            String s = input.nextLine().substring(12);
            String temp = "";
            for (int i = 0; i < s.length(); i++){
                if (s.charAt(i) == ','){
                    s = s.substring(i + 4);
                    break;
                }
                else
                    temp += s.charAt(i);
            }
            int sX = Integer.valueOf(temp) + 5_000_001;

            temp = "";
            for (int i = 0; i < s.length(); i++){
                if (s.charAt(i) == ':'){
                    s = s.substring(i + 25);
                    break;
                }
                else
                    temp += s.charAt(i);
            }
            int sY = Integer.valueOf(temp) + 5_000_001;

            temp = "";
            for (int i = 0; i < s.length(); i++){
                if (s.charAt(i) == ','){
                    s = s.substring(i + 4);
                    break;
                }
                else
                    temp += s.charAt(i);
            }
            int bX = Integer.valueOf(temp) + 5_000_001;

            int bY = Integer.valueOf(s) + 5_000_001;


            if (sY == (5_000_001+2_000_000))
                row2_000_000[sX] = 'S';
            if (bY == (5_000_001+2_000_000))
                row2_000_000[bX] = 'B';

            int distance = Math.abs(bX-sX) + Math.abs(bY-sY);

            if (2_000_000+5_000_001 <= sY + distance && 2_000_000+5_000_001 >= sY - distance){
                distance -= Math.abs(sY - (2_000_000+5_000_001));
                for (int i = 0; i <= distance; i++){
                    if (row2_000_000[sX+i] == '.')
                        row2_000_000[sX+i] = '#';
                    if (row2_000_000[sX-i] == '.')
                        row2_000_000[sX-i] = '#';
                }
            }
        }


        int n = 0;
        for (char c : row2_000_000){
            if (c == '#')
                n++;
        }

        System.out.println(n);

    }


}
