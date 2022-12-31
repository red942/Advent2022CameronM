package advent2022.day11to15;
import java.util.*;
import java.io.*;

public class RegolithReservoir1 {
    public static void main(String[] args) throws FileNotFoundException{
        Scanner input = new Scanner(new File(
            System.getProperty("user.dir") + "/lib/advent2022/day14.txt"));

        
        char[][] cave = new char[200][600];
        for (int i = 0; i < 200; i++){
            for (int j = 0; j < 600; j++)
                cave[i][j] = '.';
        }

        while (input.hasNextLine()){
            String rocks = input.nextLine();
            int cnt = 0;
            for (int i = 0; i < rocks.length(); i++){
                if (rocks.charAt(i) == ',')
                    cnt++;
            }

            int[] xs = new int[cnt];
            int[] ys = new int[cnt];
            for (int i = 0; i < cnt; i++){
                int usedChars = 0;
                while(rocks.charAt(usedChars) != ',')
                    usedChars++;
                xs[i] = Integer.valueOf(rocks.substring(0, usedChars));
                rocks = rocks.substring(usedChars + 1);
                
                usedChars = 0;
                while(usedChars != rocks.length() && rocks.charAt(usedChars) != ' ')
                    usedChars++;
                if (usedChars != rocks.length())
                    ys[i] = Integer.valueOf(rocks.substring(0, usedChars));
                else
                    ys[i] = Integer.valueOf(rocks);
                if (i != cnt-1)
                    rocks = rocks.substring(usedChars + 4);
            }

            for (int k = 0; k < cnt - 1; k++){
                if (xs[k] != xs[k+1]){
                    int n = 0;
                    if (xs[k] < xs[k+1]){
                        while (xs[k] + n <= xs[k+1]){
                            cave[ys[k]][xs[k] + n] = '#';
                            n++;
                        }
                    } else {
                        while (xs[k] + n >= xs[k+1]){
                            cave[ys[k]][xs[k] + n] = '#';
                            n--;
                        }
                    }
                } else {
                    int n = 0;
                    if (ys[k] < ys[k+1]){
                        while (ys[k] + n <= ys[k+1]){
                            cave[ys[k] + n][xs[k]] = '#';
                            n++;
                        }
                    } else {
                        while (ys[k] + n >= ys[k+1]){
                            cave[ys[k] + n][xs[k]] = '#';
                            n--;
                        }
                    }
                }
            }
        }

        int num = 0;
        while (true){
            int x = 500;
            int y = 0;
            num++;

            try {
                boolean cont;
                while (true){
                    cont = false;

                    while (cave[y+1][x] == '.'){
                            y++;
                    }

                    
                    if (cave[y+1][x-1] == '.'){
                        y++;
                        x--;
                        cont = true;
                    }
                    if (cont){
                        continue;
                    }

                    if (cave[y+1][x+1] == '.'){
                        y++;
                        x++;
                        cont = true;
                    }
                    if (cont){
                        continue;
                    }

                    cave[y][x] = 'o';
                    break;
                }
            } catch (Exception e) {
                break;
            }
        }


        System.out.println(num - 1);
    }
}
