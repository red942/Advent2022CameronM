package advent2022.day6to10;
import java.util.Scanner;

public class TreetopTreeHouse1 {
    
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        int[][] forest = new int[99][99];

        String input = "";
        int temp = 0;
        while(true){

            input = stdin.nextLine();
            if (input.equals("done"))
                break;

            for (int i = 0; i < 99; i++){
                forest[temp][i] = input.charAt(i) - '0';
            }
            
            temp++;
        }

        int numVisible = 0;
        for (int i = 0; i < 99; i++) {
            for (int j = 0; j < 99; j++){
                if (i == 0 || i == 98 || j == 0 || j == 98 || isVisible(forest, i, j))
                    numVisible++;
            }
        }

        System.out.println(numVisible);

        stdin.close();
    }

    public static boolean isVisible(int[][] arr, int i, int j){
        int height = arr[i][j];
        boolean broke = false;

        for (int k = j - 1; k >= 0; k--){
            if (arr[i][k] >= height){
                broke = true;
                break;
            }
        }

        if (!broke)
            return true;
        
        broke = false;
        for (int k = 98; k > j; k--){
            if (arr[i][k] >= height){
                broke = true;
                break;
            }
        }

        if (!broke)
            return true;

        broke = false;
        for (int k = 98; k > i; k--){
            if (arr[k][j] >= height){
                broke = true;
                break;
            }
        }

        if (!broke)
            return true;

        broke = false;
        for (int k = i - 1; k >= 0; k--){
            if (arr[k][j] >= height){
                broke = true;
                break;
            }
        }

        if (!broke)
            return true;
        
        return false;
    }
}
