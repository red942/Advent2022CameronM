package advent2022.day21to25;
import java.util.*;
import java.io.*;

public class day23 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File(
            System.getProperty("user.dir") + "/lib/advent2022/t/day23.txt"));

        char[][] temp = new char[6][5];

        int cnt = 0;
        while (input.hasNextLine()){
            String in = input.nextLine();
            for (int i = 0; i < in.length(); i++)
                temp[cnt][i] = in.charAt(i);
            cnt++;
        }

        char[][] grove = new char[1000][1000];
        for (int i = 0; i < 1000; i++){
            for (int j = 0; j < 1000; j++)
                grove[i][j] = '.';
        }
        

        //puts the input into a larger array
        cnt = -1;
        for (int i = (grove.length / 2) - (temp.length / 2); i < (grove.length / 2) + (temp.length / 2); i++){
            cnt++; 
            int cnt2 = -1;
            for (int j = (grove[0].length / 2) - (temp[0].length / 2); j < (grove[0].length / 2) + (temp[0].length / 2); j++){
                cnt2++;
                grove[i][j] = temp[cnt][cnt2];
            }
        }

        for (int i = 497; i < 503; i++){
            for (int j = 498; j < 503; j++){
                System.out.print(grove[i][j]);
            }
            System.out.println();
        }
    }

    public static void move(char[][] grove){
        
    }
}
