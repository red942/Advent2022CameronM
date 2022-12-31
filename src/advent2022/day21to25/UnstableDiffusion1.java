package advent2022.day21to25;
import java.util.*;
import java.io.*;


//!!!!!!!!!!!!!!!!!!
//FOR THIS TO WORK, YOU NEED TO ADD AN EXTRA '.' TO THE END OF EACH LINE IN YOUR INPUT
//THEN YOU NEED TO ADD AN EXTRA LINE (OF LENGTH 76) CONTAINING JUST '.'

public class UnstableDiffusion1 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File(
            System.getProperty("user.dir") + "/lib/advent2022/day23.txt"));

        char[][] temp = new char[76][76];

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

        for (int i = 0; i < 10; i++){
            switch (i%4){
                case 0:
                    moveN(grove);
                    break;
                case 1:
                    moveS(grove);
                    break;
                case 2:
                    moveW(grove);
                    break;
                case 3:
                    moveE(grove);
                    break;
            }
        }


        int yMin = -1, xMin = -1, yMax = 9999, xMax = 9999;

        boolean found = false;
        for (int i = 0; i < 1000; i++){
            for (int j = 0; j < 1000; j++){
                if (grove[i][j] == '#'){
                    found = true;
                    yMin = i;
                    break;
                }
            }
            if (found)
                break;
        }

        found = false;
        for (int i = 1000-1; i >= 0; i--){
            for (int j = 0; j < 1000; j++){
                if (grove[i][j] == '#'){
                    found = true;
                    yMax = i;
                    break;
                }
            }
            if (found)
                break;
        }

        found = false;
        for (int i = 1000-1; i >= 0; i--){
            for (int j = 0; j < 1000; j++){
                if (grove[j][i] == '#'){
                    found = true;
                    xMax = i;
                    break;
                }
            }
            if (found)
                break;
        }

        found = false;
        for (int i = 0; i < 1000; i++){
            for (int j = 0; j < 1000; j++){
                if (grove[j][i] == '#'){
                    found = true;
                    xMin = i;
                    break;
                }
            }
            if (found)
                break;
        }

        int num = 0;
        for (int i = yMin; i <= yMax; i++){
            for (int j = xMin; j <= xMax; j++){
                if (grove[i][j] == '.')
                    num++;
                System.out.print(grove[i][j]);
            }
            System.out.println();
        }
        System.out.println(num);
    }

    public static void moveN(char[][] grove){
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
                                grove[i][j] = 'o';
                                grove[i-1][j] = 'q';
                            }
                        }
                        else if (grove[i+1][j-1] != '#' && grove[i+1][j] != '#' && grove[i+1][j+1] != '#' && grove[i+1][j] != 'o' && grove[i+1][j-1] != 'o' && grove[i+1][j+1] != 'o'){
                            if (grove[i+1][j] == '.'+1){
                                grove[i][j] = 'o';
                                grove[i+1][j] = 'q';
                            }
                        }
                        else if (grove[i-1][j-1] != '#' && grove[i][j-1] != '#' && grove[i+1][j-1] != '#'  && grove[i-1][j-1] != 'o' && grove[i][j-1] != 'o' && grove[i+1][j-1] != 'o'){
                            if (grove[i][j-1] == '.'+1){
                                grove[i][j] = 'o';
                                grove[i][j-1] = 'q';
                            }
                        }
                        else if (grove[i-1][j+1] != '#' && grove[i][j+1] != '#' && grove[i+1][j+1] != '#'  && grove[i-1][j+1] != 'o' && grove[i][j+1] != 'o' && grove[i+1][j+1] != 'o'){
                            if (grove[i][j+1] == '.'+1){
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
    }

    public static void moveS(char[][] grove){
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
                                grove[i][j] = 'o';
                                grove[i+1][j] = 'q';
                            }
                        }
                        else if (grove[i-1][j-1] != '#' && grove[i][j-1] != '#' && grove[i+1][j-1] != '#' && grove[i-1][j-1] != 'o' && grove[i][j-1] != 'o' && grove[i+1][j-1] != 'o'){
                            if (grove[i][j-1] == '.'+1){
                                grove[i][j] = 'o';
                                grove[i][j-1] = 'q';
                            }
                        }
                        else if (grove[i-1][j+1] != '#' && grove[i][j+1] != '#' && grove[i+1][j+1] != '#' && grove[i-1][j+1] != 'o' && grove[i][j+1] != 'o' && grove[i+1][j+1] != 'o'){
                            if (grove[i][j+1] == '.'+1){
                                grove[i][j] = 'o';
                                grove[i][j+1] = 'q';
                            }
                        } 
                        else if (grove[i-1][j-1] != '#' && grove[i-1][j] != '#' && grove[i-1][j+1] != '#' && grove[i-1][j-1] != 'o' && grove[i-1][j] != 'o' && grove[i-1][j+1] != 'o'){
                            if (grove[i-1][j] == '.'+1){
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
    }

    public static void moveW(char[][] grove){
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
                                grove[i][j] = 'o';
                                grove[i][j-1] = 'q';
                            }
                        }
                        else if (grove[i-1][j+1] != '#' && grove[i][j+1] != '#' && grove[i+1][j+1] != '#' && grove[i-1][j+1] != 'o' && grove[i][j+1] != 'o' && grove[i+1][j+1] != 'o'){
                            if (grove[i][j+1] == '.'+1){
                                grove[i][j] = 'o';
                                grove[i][j+1] = 'q';
                            }
                        } 
                        else if (grove[i-1][j-1] != '#' && grove[i-1][j] != '#' && grove[i-1][j+1] != '#' && grove[i-1][j-1] != 'o' && grove[i-1][j] != 'o' && grove[i-1][j+1] != 'o'){
                            if (grove[i-1][j] == '.'+1){
                                grove[i][j] = 'o';
                                grove[i-1][j] = 'q';
                            }
                        }
                        else if (grove[i+1][j-1] != '#' && grove[i+1][j] != '#' && grove[i+1][j+1] != '#' && grove[i+1][j-1] != 'o' && grove[i+1][j] != 'o' && grove[i+1][j+1] != 'o'){
                            if (grove[i+1][j] == '.'+1){
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
    }

    public static void moveE(char[][] grove){
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
                                grove[i][j] = 'o';
                                grove[i][j+1] = 'q';
                            }
                        } 
                        else if (grove[i-1][j-1] != '#' && grove[i-1][j] != '#' && grove[i-1][j+1] != '#' && grove[i-1][j-1] != 'o' && grove[i-1][j] != 'o' && grove[i-1][j+1] != 'o'){
                            if (grove[i-1][j] == '.'+1){
                                grove[i][j] = 'o';
                                grove[i-1][j] = 'q';
                            }
                        }
                        else if (grove[i+1][j-1] != '#' && grove[i+1][j] != '#' && grove[i+1][j+1] != '#' && grove[i+1][j-1] != 'o' && grove[i+1][j] != 'o' && grove[i+1][j+1] != 'o'){
                            if (grove[i+1][j] == '.'+1){
                                grove[i][j] = 'o';
                                grove[i+1][j] = 'q';
                            }
                        }
                        else if (grove[i-1][j-1] != '#' && grove[i][j-1] != '#' && grove[i+1][j-1] != '#' && grove[i-1][j-1] != 'o' && grove[i][j-1] != 'o' && grove[i+1][j-1] != 'o'){
                            if (grove[i][j-1] == '.'+1){
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
    }
}
