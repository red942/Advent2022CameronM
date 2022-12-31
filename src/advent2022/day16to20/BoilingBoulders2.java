package advent2022.day16to20;

import java.util.*;
import java.io.*;

public class BoilingBoulders2 {
    public static void main(String[] args) throws FileNotFoundException{
        Scanner input = new Scanner(new File(
            System.getProperty("user.dir") + "/lib/advent2022/day18.txt"));

        char[][][] grid = new char[25][25][25];

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
            grid[x+1][y+1][z+1] = 'O';
        }

        int sum = 0;
        for (int i = 1; i < 24; i++){
            for (int j = 1; j < 24; j++){
                for (int k = 1; k < 24; k++)
                    sum += exposed(grid, i, j, k);
            }
        }
        for (int i = 1; i < 24; i++){
            for (int j = 1; j < 24; j++){
                for (int k = 1; k < 24; k++){
                   sum += holeExposed(grid, i, j, k);
                }
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

    public static boolean isHole(char[][][] grid, int x, int y, int z){
        char[][][] copy = new char[25][25][25];
        for (int i = 0; i < 25; i++){
            for (int j = 0; j < 25; j++){
                for (int k = 0; k < 25; k++)
                    copy[i][j][k] = grid[i][j][k];
            }
        }

        copy[x][y][z] = 's';

        long start = System.currentTimeMillis();
        try {
            while (true){
                if (System.currentTimeMillis() > start + 20)
                    return true;
                boolean expanded = false;

                for (int i = 0; i < 25; i++){
                    for (int j = 0; j < 25; j++){
                        for (int k = 0; k < 25; k++){
                            if (copy[i][j][k] == 's'){
                                if (copy[i-1][j][k] != 'O'){
                                    copy[i-1][j][k] = 's';
                                    expanded = true;
                                }
                                if (copy[i+1][j][k] != 'O'){
                                    copy[i+1][j][k] = 's';
                                    expanded = true;
                                }
                                if (copy[i][j-1][k] != 'O'){
                                    copy[i][j-1][k] = 's';
                                    expanded = true;
                                }
                                if (copy[i][j+1][k] != 'O'){
                                    copy[i][j+1][k] = 's';
                                    expanded = true;
                                }
                                if (copy[i][j][k-1] != 'O'){
                                    copy[i][j][k-1] = 's';
                                    expanded = true;
                                }
                                if (copy[i][j][k+1] != 'O'){
                                    copy[i][j][k+1] = 's';
                                    expanded = true;
                                }
                            }
                        }
                    }
                }

                if (!expanded)
                    break;
            }
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public static int holeExposed(char[][][] grid, int x, int y, int z){
        
        if (grid[x][y][z] == 'O' || !isHole(grid, x, y, z))
            return 0;

        int num = 0;
        if (grid[x][y][z+1] == 'O')
            num--;
        if (grid[x][y][z-1] == 'O')
            num--;
        if (grid[x][y+1][z] == 'O')
            num--;
        if (grid[x][y-1][z] == 'O')
            num--;
        if (grid[x+1][y][z] == 'O')
            num--;
        if (grid[x-1][y][z] ==  'O')
            num--;
        return num;
    }
}
