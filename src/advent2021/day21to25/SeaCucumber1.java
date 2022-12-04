package advent2021.day21to25;
import java.util.Scanner;

public class SeaCucumber1 {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int rows = 137, columns = 139; //These numbers are found by counting the number in the input

        //makes and assigns the arrays
        char[][] seaFloor = new char[rows][columns];
        for (int i = 0; i < rows; i++){
            String row = stdin.nextLine();
            for (int j = 0; j < columns; j++)
                seaFloor[i][j] = row.charAt(j);
        }

        int cnt = 0;
        boolean moved = true; //keeps tracked if it moved that loop
        while(moved){
            cnt++;
            moved = false; 

            //does the east movement
            for (int i = 0; i < rows; i++){
                for (int j = 0; j < columns; j++){
                    if (j != columns - 1){
                        if (seaFloor[i][j] == '>' && seaFloor[i][j+1] == '.'){
                            seaFloor[i][j] = 'f'; //This makes sure that if the 1st in a row moves, the last won't move to where it was
                            seaFloor[i][j+1] = 'e'; //This does the same thing, but marks this as the new location
                            moved = true;
                        }
                    } else {
                        if (seaFloor[i][j] == '>' && seaFloor[i][0] == '.'){
                            seaFloor[i][j] = 'f';
                            seaFloor[i][0] = 'e';
                            moved = true;
                        }
                    }
                }
            }

            //resets the dots for the east part
            for (int i = 0; i < rows; i++){
                for (int j = 0; j < columns; j++){
                    if (seaFloor[i][j] == 'f')
                        seaFloor[i][j] = '.';
                }
            }

            //does the south movement
            for (int i = 0; i < columns; i++){
                for (int j = 0; j < rows; j++){
                    if (j != rows - 1){
                        if (seaFloor[j][i] == 'v' && seaFloor[j+1][i] == '.'){
                            seaFloor[j][i] = 'f';
                            seaFloor[j+1][i] = 's';
                            moved = true;
                        }
                    } else {
                        if (seaFloor[j][i] == 'v' && seaFloor[0][i] == '.'){
                            seaFloor[j][i] = 'f';
                            seaFloor[0][i] = 's';
                            moved = true;
                        }
                    }
                }
            }

            //this converts the temporary letters back into the symbols
            for (int i = 0; i < rows; i++){
                for (int j = 0; j < columns; j++){
                    if (seaFloor[i][j] == 'e')
                        seaFloor[i][j] = '>';
                    else if (seaFloor[i][j] == 's')
                        seaFloor[i][j] = 'v';
                    else if (seaFloor[i][j] == 'f')
                        seaFloor[i][j] = '.';
                }
            }
        }
        System.out.println(cnt);
        stdin.close();
    }
}
