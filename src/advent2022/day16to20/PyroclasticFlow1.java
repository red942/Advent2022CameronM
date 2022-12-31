package advent2022.day16to20;
import java.util.*;
import java.io.*;

public class PyroclasticFlow1 {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner input = new Scanner(new File(
            System.getProperty("user.dir") + "/lib/advent2022/day17.txt"));
        String in = input.next();

        LinkedList<Character> gas = new LinkedList<>();
        while (gas.size() < 100_000){
            for (int i = 0; i < in.length(); i++)
                gas.add(in.charAt(i));
        }

        char[][] cave = new char[100_000][7];
        for (int i = 0; i < 100_000; i++){
            for (int j = 0; j < 7; j++){
                cave[i][j] = '.';
            }
        }

        for (int i = 0; i < 7; i++)
            cave[0][i] = '#';

        for (int i = 0; i < 2022; i++){ //i < 2022
            drop(cave, i % 5, getHeight(cave), gas);
        }
        
        System.out.println(getHeight(cave));

    }

    public static void drop(char[][] cave, int type, int height, LinkedList<Character> gas){
        height += 4;
        boolean left = (gas.get(0) == '<');
        gas.remove(0);
        switch(type){

            case 0: //hor line
                if (true){
                    int x1 = 2, x2 = 3, x3 = 4, x4 = 5;
                    
                    while (true){

                        //gas
                        if (left){
                            if (x1 != 0 && cave[height][x1-1] != '#'){
                                x1--;
                                x2--;
                                x3--;
                                x4--;
                            }
                        } else {
                            if (x4 != 6 && cave[height][x4+1] != '#'){
                                x1++;
                                x2++;
                                x3++;
                                x4++;
                            }
                        }

                        //falling
                        if (cave[height-1][x1] != '#' && cave[height-1][x2] != '#' && cave[height-1][x3] != '#' && cave[height-1][x4] != '#' ){
                            height--;
                        } else
                            break;

                        //assigning next gas
                        left = (gas.get(0) == '<');
                        gas.remove(0);
                    }

                    cave[height][x1] = '#';
                    cave[height][x2] = '#';
                    cave[height][x3] = '#';
                    cave[height][x4] = '#';
                }
                break;
            case 1: // t
                if (true){
                    int y1 = height + 2, y2 = height + 1, y3 = height;
                    int x1 = 2, x2 = 3, x3 = 4;

                    while (true){
                        //gas
                        if (left){
                            if (x1 != 0 && cave[y2][x1-1] != '#' && cave[y1][x2-1] != '#' && cave[y3][x2-1] != '#'){
                                x1--;
                                x2--;
                                x3--;
                            }
                        } else {
                            if (x3 != 6 && cave[y2][x3+1] != '#' && cave[y1][x2+1] != '#' && cave[y3][x2+1] != '#'){
                                x1++;
                                x2++;
                                x3++;
                            }
                        }

                        //falling
                        if (cave[y3][x1] != '#' && cave[y3-1][x2] != '#' && cave[y3][x3] != '#'){
                            y1--;
                            y2--;
                            y3--;
                        } else
                            break;

                        //assigning next gas
                        left = (gas.get(0) == '<');
                        gas.remove(0);
                    }

                    cave[y1][x2] = '#'; //top
                    cave[y2][x1] = '#'; //left
                    cave[y2][x2] = '#'; //center
                    cave[y2][x3] = '#'; //right
                    cave[y3][x2] = '#'; //bottom
                }
                break;
            case 2: // backwards L
                if (true){
                    int y1 = height + 2, y2 = height + 1, y3 = height;
                    int x1 = 2, x2 = 3, x3 = 4;

                    while (true){

                        //gas
                        if (left){
                            if (x1 != 0 && cave[y1][x3-1] != '#' && cave[y2][x3-1] != '#' && cave[y3][x1-1] != '#'){
                                x1--;
                                x2--;
                                x3--;
                            }
                        } else {
                            if (x3 != 6 && cave[y1][x3+1] != '#' && cave[y2][x3+1] != '#' && cave[y3][x3+1] != '#'){
                                x1++;
                                x2++;
                                x3++;
                            }
                        }

                        //falling
                        if (cave[y3-1][x1] != '#' && cave[y3-1][x2] != '#' && cave[y3-1][x3] != '#'){
                            y1--;
                            y2--;
                            y3--;
                        } else
                            break;

                        //Assigning next gas
                        left = (gas.get(0) == '<');
                        gas.remove(0);
                    }

                    cave[y1][x3] = '#';
                    cave[y2][x3] = '#';
                    cave[y3][x3] = '#';
                    cave[y3][x2] = '#';
                    cave[y3][x1] = '#';
                }
                break;
            case 3: //vert line
                if (true){
                    int x = 2;
                    int y1 = height + 3, y2 = height + 2, y3 = height + 1, y4 = height;

                    while (true){

                        //gas
                        if (left){
                            if (x != 0 && cave[y1][x-1] != '#' && cave[y2][x-1] != '#' && cave[y3][x-1] != '#' && cave[y4][x-1] != '#'){
                                x--;
                            }
                        } else {
                            if (x != 6 && cave[y1][x+1] != '#' && cave[y2][x+1] != '#' && cave[y3][x+1] != '#' && cave[y4][x+1] != '#'){
                                x++;
                            }
                        }
                        
                        //falling
                        if (cave[y4-1][x] != '#'){
                            y1--;
                            y2--;
                            y3--;
                            y4--;
                        } else 
                            break;

                        //Assigning next gas
                        left = (gas.get(0) == '<');
                        gas.remove(0);
                    }

                    cave[y1][x] = '#';
                    cave[y2][x] = '#';
                    cave[y3][x] = '#';
                    cave[y4][x] = '#';
                }
                break;
            case 4: //square
                if (true){
                    int y1 = height + 1, y2 = height;
                    int x1 = 2, x2 = 3;

                    while (true){
                        //gas
                        if (left){
                            if (x1 != 0 && cave[y1][x1-1] != '#' && cave[y2][x1-1] != '#'){
                                x1--;
                                x2--;
                            }
                        } else {
                            if (x2 != 6 && cave[y1][x2+1] != '#' && cave[y2][x2+1] != '#'){
                                x1++;
                                x2++;
                            }
                        }

                        //falling
                        if (cave[y2-1][x1] != '#' && cave[y2-1][x2] != '#'){
                            y1--;
                            y2--;
                        } else
                            break;

                        //Assigning next gas
                        left = (gas.get(0) == '<');
                        gas.remove(0);                        
                    }

                    cave[y1][x1] = '#';
                    cave[y1][x2] = '#';
                    cave[y2][x1] = '#';
                    cave[y2][x2] = '#';
                }
                break;
        }
    }

    //gas, fall, next gas, then set and break
    public static int getHeight(char[][] cave){
        for (int i = 0; i < 100_000; i++){
            boolean cont = false;
            for (int j = 0; j < 7; j++){
                if (cave[i][j] == '#'){
                    cont = true;
                    break;
                }
            }
            if (cont)
                continue;
            return i-1;
        }
        return -1;
    }
}
