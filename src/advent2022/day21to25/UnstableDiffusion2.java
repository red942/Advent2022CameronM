package advent2022.day21to25;
import java.util.*;
import java.io.*;


//!!!!!!!!!!!!!!!!!!
//FOR THIS TO WORK, YOU NEED TO ADD AN EXTRA '.' TO THE END OF EACH LINE IN YOUR INPUT
//THEN YOU NEED TO ADD AN EXTRA LINE (OF LENGTH 76) CONTAINING JUST '.'

public class UnstableDiffusion2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File(
            System.getProperty("user.dir") + "/lib/advent2022/day23.txt"));

        char[][] temp = new char[76][76]; //76 76 8 8 

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

        int num = -1;
        boolean over = false;
        while (true){
            num++;
            switch (num%4){
                case 0:
                    over = moveN(grove);
                    break;
                case 1:
                    over = moveS(grove);
                    break;
                case 2:
                    over = moveW(grove);
                    break;
                case 3:
                    over = moveE(grove);
                    break;
            }
            if (over)
                break;
        }

        System.out.println(num+1);
    }

    public static boolean moveN(char[][] grove){
        boolean over = true;
        //go through once and place a number down if it is going to move there. Ex: the first would plalce a 1, the second a 2 and eventually random ascii.
        //do a second pass through and if the target spot is a 1, move, else dont move.
        //at the end get rid of all of the left over numbers.
        for (int i = 5; i < grove.length-5; i++){
            for (int j = 5; j < grove[0].length-5; j++){
                if (grove[i][j] == '#'){
                    if (grove[i+1][j] == '#' || grove[i+1][j+1] == '#' || grove[i+1][j-1] == '#' || grove[i-1][j] == '#' || grove[i-1][j+1] == '#' || grove[i-1][j-1] == '#' || grove[i][j-1] == '#' || grove[i][j+1] == '#'){
                        if (grove[i-1][j-1] != '#' && grove[i-1][j] != '#' && grove[i-1][j+1] != '#')
                            grove[i-1][j]++;
                        else if (grove[i+1][j-1] != '#' && grove[i+1][j] != '#' && grove[i+1][j+1] != '#')
                            grove[i+1][j]++;
                        else if (grove[i-1][j-1] != '#' && grove[i][j-1] != '#' && grove[i+1][j-1] != '#')
                            grove[i][j-1]++;
                        else if (grove[i-1][j+1] != '#' && grove[i][j+1] != '#' && grove[i+1][j+1] != '#')
                            grove[i][j+1]++;
                    } else 
                        continue;
                } else 
                    continue;
            }
        }

        for (int i = 5; i < grove.length-5; i++){
            for (int j = 5; j < grove[0].length-5; j++){
                if (grove[i][j] == '#'){
                    if (grove[i+1][j] == '#' || grove[i+1][j+1] == '#' || grove[i+1][j-1] == '#' || grove[i-1][j] == '#' || grove[i-1][j+1] == '#' || grove[i-1][j-1] == '#' || grove[i][j-1] == '#' || grove[i][j+1] == '#'
                    || grove[i+1][j] == 'o' || grove[i+1][j+1] == 'o' || grove[i+1][j-1] == 'o' || grove[i-1][j] == 'o' || grove[i-1][j+1] == 'o' || grove[i-1][j-1] == 'o' || grove[i][j-1] == 'o' || grove[i][j+1] == 'o'){
                        if (grove[i-1][j-1] != '#' && grove[i-1][j] != '#' && grove[i-1][j+1] != '#' && grove[i-1][j-1] != 'o' && grove[i-1][j] != 'o' && grove[i-1][j+1] != 'o'){
                            if (grove[i-1][j] == '.'+1){
                                over = false;
                                grove[i][j] = 'o';
                                grove[i-1][j] = 'q';
                            }
                        }
                        else if (grove[i+1][j-1] != '#' && grove[i+1][j] != '#' && grove[i+1][j+1] != '#' && grove[i+1][j] != 'o' && grove[i+1][j-1] != 'o' && grove[i+1][j+1] != 'o'){
                            if (grove[i+1][j] == '.'+1){
                                over = false;
                                grove[i][j] = 'o';
                                grove[i+1][j] = 'q';
                            }
                        }
                        else if (grove[i-1][j-1] != '#' && grove[i][j-1] != '#' && grove[i+1][j-1] != '#'  && grove[i-1][j-1] != 'o' && grove[i][j-1] != 'o' && grove[i+1][j-1] != 'o'){
                            if (grove[i][j-1] == '.'+1){
                                over = false;
                                grove[i][j] = 'o';
                                grove[i][j-1] = 'q';
                            }
                        }
                        else if (grove[i-1][j+1] != '#' && grove[i][j+1] != '#' && grove[i+1][j+1] != '#'  && grove[i-1][j+1] != 'o' && grove[i][j+1] != 'o' && grove[i+1][j+1] != 'o'){
                            if (grove[i][j+1] == '.'+1){
                                over = false;
                                grove[i][j] = 'o';
                                grove[i][j+1] = 'q';
                            }
                        }
                    } else 
                        continue;
                } else 
                    continue;
            }
        }

        for (int i = 5; i < grove.length-5; i++){
            for (int j = 5; j < grove[0].length-5; j++){
                if (grove[i][j] == 'q')
                    grove[i][j] = '#';
                else if (grove[i][j] != '#')
                    grove[i][j] = '.';
                
            }
        }
        return over;
    }

    public static boolean moveS(char[][] grove){
        boolean over = true;
        //go through once and place a number down if it is going to move there. Ex: the first would plalce a 1, the second a 2 and eventually random ascii.
        //do a second pass through and if the target spot is a 1, move, else dont move.
        //at the end get rid of all of the left over numbers.
        for (int i = 5; i < grove.length-5; i++){
            for (int j = 5; j < grove[0].length-5; j++){
                if (grove[i][j] == '#'){
                    if (grove[i+1][j] == '#' || grove[i+1][j+1] == '#' || grove[i+1][j-1] == '#' || grove[i-1][j] == '#' || grove[i-1][j+1] == '#' || grove[i-1][j-1] == '#' || grove[i][j-1] == '#' || grove[i][j+1] == '#'){
                        if (grove[i+1][j-1] != '#' && grove[i+1][j] != '#' && grove[i+1][j+1] != '#')
                            grove[i+1][j]++;
                        else if (grove[i-1][j-1] != '#' && grove[i][j-1] != '#' && grove[i+1][j-1] != '#')
                            grove[i][j-1]++;
                        else if (grove[i-1][j+1] != '#' && grove[i][j+1] != '#' && grove[i+1][j+1] != '#')
                            grove[i][j+1]++;
                        else if (grove[i-1][j-1] != '#' && grove[i-1][j] != '#' && grove[i-1][j+1] != '#')
                            grove[i-1][j]++;
                    } else 
                        continue;
                } else 
                    continue;
            }
        }


        for (int i = 5; i < grove.length-5; i++){
            for (int j = 5; j < grove[0].length-5; j++){
                if (grove[i][j] == '#'){
                    if (grove[i+1][j] == '#' || grove[i+1][j+1] == '#' || grove[i+1][j-1] == '#' || grove[i-1][j] == '#' || grove[i-1][j+1] == '#' || grove[i-1][j-1] == '#' || grove[i][j-1] == '#' || grove[i][j+1] == '#'
                    || grove[i+1][j] == 'o' || grove[i+1][j+1] == 'o' || grove[i+1][j-1] == 'o' || grove[i-1][j] == 'o' || grove[i-1][j+1] == 'o' || grove[i-1][j-1] == 'o' || grove[i][j-1] == 'o' || grove[i][j+1] == 'o'){
                        if (grove[i+1][j-1] != '#' && grove[i+1][j] != '#' && grove[i+1][j+1] != '#' && grove[i+1][j] != 'o' && grove[i+1][j-1] != 'o' && grove[i+1][j+1] != 'o'){
                            if (grove[i+1][j] == '.'+1){
                                over = false;
                                grove[i][j] = 'o';
                                grove[i+1][j] = 'q';
                            }
                        }
                        else if (grove[i-1][j-1] != '#' && grove[i][j-1] != '#' && grove[i+1][j-1] != '#' && grove[i-1][j-1] != 'o' && grove[i][j-1] != 'o' && grove[i+1][j-1] != 'o'){
                            if (grove[i][j-1] == '.'+1){
                                over = false;
                                grove[i][j] = 'o';
                                grove[i][j-1] = 'q';
                            }
                        }
                        else if (grove[i-1][j+1] != '#' && grove[i][j+1] != '#' && grove[i+1][j+1] != '#' && grove[i-1][j+1] != 'o' && grove[i][j+1] != 'o' && grove[i+1][j+1] != 'o'){
                            if (grove[i][j+1] == '.'+1){
                                over = false;
                                grove[i][j] = 'o';
                                grove[i][j+1] = 'q';
                            }
                        } 
                        else if (grove[i-1][j-1] != '#' && grove[i-1][j] != '#' && grove[i-1][j+1] != '#' && grove[i-1][j-1] != 'o' && grove[i-1][j] != 'o' && grove[i-1][j+1] != 'o'){
                            if (grove[i-1][j] == '.'+1){
                                over = false;
                                grove[i][j] = 'o';
                                grove[i-1][j] = 'q';
                            }
                        }
                    } else 
                        continue;
                } else 
                    continue;
            }
        }

        for (int i = 5; i < grove.length-5; i++){
            for (int j = 5; j < grove[0].length-5; j++){
                if (grove[i][j] == 'q')
                    grove[i][j] = '#';
                else if (grove[i][j] != '#')
                    grove[i][j] = '.';
                
            }
        }
        return over;
    }

    public static boolean moveW(char[][] grove){
        boolean over = true;
        //go through once and place a number down if it is going to move there. Ex: the first would plalce a 1, the second a 2 and eventually random ascii.
        //do a second pass through and if the target spot is a 1, move, else dont move.
        //at the end get rid of all of the left over numbers.
        for (int i = 5; i < grove.length-5; i++){
            for (int j = 5; j < grove[0].length-5; j++){
                if (grove[i][j] == '#'){
                    if (grove[i+1][j] == '#' || grove[i+1][j+1] == '#' || grove[i+1][j-1] == '#' || grove[i-1][j] == '#' || grove[i-1][j+1] == '#' || grove[i-1][j-1] == '#' || grove[i][j-1] == '#' || grove[i][j+1] == '#'){
                        if (grove[i-1][j-1] != '#' && grove[i][j-1] != '#' && grove[i+1][j-1] != '#')
                            grove[i][j-1]++;
                        else if (grove[i-1][j+1] != '#' && grove[i][j+1] != '#' && grove[i+1][j+1] != '#')
                            grove[i][j+1]++;
                        else if (grove[i-1][j-1] != '#' && grove[i-1][j] != '#' && grove[i-1][j+1] != '#')
                            grove[i-1][j]++;
                        else if (grove[i+1][j-1] != '#' && grove[i+1][j] != '#' && grove[i+1][j+1] != '#')
                            grove[i+1][j]++;
                    } else 
                        continue;
                } else 
                    continue;
            }
        }



        for (int i = 5; i < grove.length-5; i++){
            for (int j = 5; j < grove[0].length-5; j++){
                if (grove[i][j] == '#'){
                    if (grove[i+1][j] == '#' || grove[i+1][j+1] == '#' || grove[i+1][j-1] == '#' || grove[i-1][j] == '#' || grove[i-1][j+1] == '#' || grove[i-1][j-1] == '#' || grove[i][j-1] == '#' || grove[i][j+1] == '#'
                    || grove[i+1][j] == 'o' || grove[i+1][j+1] == 'o' || grove[i+1][j-1] == 'o' || grove[i-1][j] == 'o' || grove[i-1][j+1] == 'o' || grove[i-1][j-1] == 'o' || grove[i][j-1] == 'o' || grove[i][j+1] == 'o'){
                        if (grove[i-1][j-1] != '#' && grove[i][j-1] != '#' && grove[i+1][j-1] != '#' && grove[i-1][j-1] != 'o' && grove[i][j-1] != 'o' && grove[i+1][j-1] != 'o'){
                            if (grove[i][j-1] == '.'+1){
                                over = false;
                                grove[i][j] = 'o';
                                grove[i][j-1] = 'q';
                            }
                        }
                        else if (grove[i-1][j+1] != '#' && grove[i][j+1] != '#' && grove[i+1][j+1] != '#' && grove[i-1][j+1] != 'o' && grove[i][j+1] != 'o' && grove[i+1][j+1] != 'o'){
                            if (grove[i][j+1] == '.'+1){
                                over = false;
                                grove[i][j] = 'o';
                                grove[i][j+1] = 'q';
                            }
                        } 
                        else if (grove[i-1][j-1] != '#' && grove[i-1][j] != '#' && grove[i-1][j+1] != '#' && grove[i-1][j-1] != 'o' && grove[i-1][j] != 'o' && grove[i-1][j+1] != 'o'){
                            if (grove[i-1][j] == '.'+1){
                                over = false;
                                grove[i][j] = 'o';
                                grove[i-1][j] = 'q';
                            }
                        }
                        else if (grove[i+1][j-1] != '#' && grove[i+1][j] != '#' && grove[i+1][j+1] != '#' && grove[i+1][j-1] != 'o' && grove[i+1][j] != 'o' && grove[i+1][j+1] != 'o'){
                            if (grove[i+1][j] == '.'+1){
                                over = false;
                                grove[i][j] = 'o';
                                grove[i+1][j] = 'q';
                            }
                        }
                    } else 
                        continue;
                } else 
                    continue;
            }
        }

        for (int i = 5; i < grove.length-5; i++){
            for (int j = 5; j < grove[0].length-5; j++){
                if (grove[i][j] == 'q')
                    grove[i][j] = '#';
                else if (grove[i][j] != '#')
                    grove[i][j] = '.';
                
            }
        }
        return over;
    }

    public static boolean moveE(char[][] grove){
        boolean over = true;
        //go through once and place a number down if it is going to move there. Ex: the first would plalce a 1, the second a 2 and eventually random ascii.
        //do a second pass through and if the target spot is a 1, move, else dont move.
        //at the end get rid of all of the left over numbers.
        for (int i = 5; i < grove.length-5; i++){
            for (int j = 5; j < grove[0].length-5; j++){
                if (grove[i][j] == '#'){
                    if (grove[i+1][j] == '#' || grove[i+1][j+1] == '#' || grove[i+1][j-1] == '#' || grove[i-1][j] == '#' || grove[i-1][j+1] == '#' || grove[i-1][j-1] == '#' || grove[i][j-1] == '#' || grove[i][j+1] == '#'){
                        if (grove[i-1][j+1] != '#' && grove[i][j+1] != '#' && grove[i+1][j+1] != '#')
                            grove[i][j+1]++;
                        else if (grove[i-1][j-1] != '#' && grove[i-1][j] != '#' && grove[i-1][j+1] != '#')
                            grove[i-1][j]++;
                        else if (grove[i+1][j-1] != '#' && grove[i+1][j] != '#' && grove[i+1][j+1] != '#')
                            grove[i+1][j]++;
                        else if (grove[i-1][j-1] != '#' && grove[i][j-1] != '#' && grove[i+1][j-1] != '#')
                            grove[i][j-1]++;
                    } else 
                        continue;
                } else 
                    continue;
            }
        }



        for (int i = 5; i < grove.length-5; i++){
            for (int j = 5; j < grove[0].length-5; j++){
                if (grove[i][j] == '#'){
                    if (grove[i+1][j] == '#' || grove[i+1][j+1] == '#' || grove[i+1][j-1] == '#' || grove[i-1][j] == '#' || grove[i-1][j+1] == '#' || grove[i-1][j-1] == '#' || grove[i][j-1] == '#' || grove[i][j+1] == '#'
                    || grove[i+1][j] == 'o' || grove[i+1][j+1] == 'o' || grove[i+1][j-1] == 'o' || grove[i-1][j] == 'o' || grove[i-1][j+1] == 'o' || grove[i-1][j-1] == 'o' || grove[i][j-1] == 'o' || grove[i][j+1] == 'o'){
                        if (grove[i-1][j+1] != '#' && grove[i][j+1] != '#' && grove[i+1][j+1] != '#' && grove[i-1][j+1] != 'o' && grove[i][j+1] != 'o' && grove[i+1][j+1] != 'o'){
                            if (grove[i][j+1] == '.'+1){
                                over = false;
                                grove[i][j] = 'o';
                                grove[i][j+1] = 'q';
                            }
                        } 
                        else if (grove[i-1][j-1] != '#' && grove[i-1][j] != '#' && grove[i-1][j+1] != '#' && grove[i-1][j-1] != 'o' && grove[i-1][j] != 'o' && grove[i-1][j+1] != 'o'){
                            if (grove[i-1][j] == '.'+1){
                                over = false;
                                grove[i][j] = 'o';
                                grove[i-1][j] = 'q';
                            }
                        }
                        else if (grove[i+1][j-1] != '#' && grove[i+1][j] != '#' && grove[i+1][j+1] != '#' && grove[i+1][j-1] != 'o' && grove[i+1][j] != 'o' && grove[i+1][j+1] != 'o'){
                            if (grove[i+1][j] == '.'+1){
                                over = false;
                                grove[i][j] = 'o';
                                grove[i+1][j] = 'q';
                            }
                        }
                        else if (grove[i-1][j-1] != '#' && grove[i][j-1] != '#' && grove[i+1][j-1] != '#' && grove[i-1][j-1] != 'o' && grove[i][j-1] != 'o' && grove[i+1][j-1] != 'o'){
                            if (grove[i][j-1] == '.'+1){
                                over = false;
                                grove[i][j] = 'o';
                                grove[i][j-1] = 'q';
                            }
                        }
                    } else 
                        continue;
                } else 
                    continue;
            }
        }

        for (int i = 5; i < grove.length-5; i++){
            for (int j = 5; j < grove[0].length-5; j++){
                if (grove[i][j] == 'q')
                    grove[i][j] = '#';
                else if (grove[i][j] != '#')
                    grove[i][j] = '.';
                
            }
        }
        return over;
    }
}
