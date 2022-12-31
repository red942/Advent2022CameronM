package advent2022.day16to20;

import java.util.*;
import java.io.*;

public class BoilingBoulders1 {
    public static void main(String[] args) throws FileNotFoundException{
        Scanner input = new Scanner(new File(
            System.getProperty("user.dir") + "/lib/advent2022/day18.txt"));

        char[][][] grid = new char[100][100][100];

        while (input.hasNextLine()){
            
            String s = input.nextLine();
            String temp = "";
            int i = 0;
            while (s.charAt(i) != ','){
                temp += s.charAt(i);
                i++;
            }

            s = s.substring(i+1);
            i = 0;
            int x = Integer.valueOf(temp);
            temp = "";
            while (s.charAt(i) != ','){
                temp += s.charAt(i);
                i++;
            }
            s = s.substring(i+1);
            int y = Integer.valueOf(temp);
            int z = Integer.valueOf(s);
            grid[x+3][y+3][z+3] = 'O';
        }

        int sum = 0;
        for (int i = 1; i < 99; i++){
            for (int j = 1; j < 99; j++){
                for (int k = 1; k < 99; k++)
                    sum += exposed(grid, i, j, k);
            }
        }
        System.out.println(sum);
    }

    public static int exposed(char[][][] grid, int x, int y, int z){
        if (grid[x][y][z] != 'O')
            return 0;

        int num = 0;
        if (grid[x][y][z+1] != 'O')
            num++;
        if (grid[x][y][z-1] != 'O')
            num++;
        if (grid[x][y+1][z] != 'O')
            num++;
        if (grid[x][y-1][z] != 'O')
            num++;
        if (grid[x+1][y][z] != 'O')
            num++;
        if (grid[x-1][y][z] !=  'O')
            num++;
        return num;
    }
}
