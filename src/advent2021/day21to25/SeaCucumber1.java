package advent2021.day21to25;
import java.util.Scanner;
import java.util.Arrays;

public class SeaCucumber1 {
    public static void main(String[] args) {
        int rows = 6, columns = 9;
        char[][] seaFloor = new char[rows][columns];
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < columns; j++)
                seaFloor[i][j] = 't';
        }
        for (int i = 0; i < rows; i++)
            System.out.println(Arrays.toString(seaFloor[i]));
    }
}
