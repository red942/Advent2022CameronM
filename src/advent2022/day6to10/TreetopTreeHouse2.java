package advent2022.day6to10;
import java.util.Scanner;

public class TreetopTreeHouse2 {
    
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

        int high = 0;
        for (int i = 1; i < 98; i++) {
            for (int j = 1; j < 98; j++){
                if (scenicScore(forest, i, j) > high){
                    high = scenicScore(forest, i, j);
                }
            }
        }

        System.out.println(high);
        stdin.close();
    }

    public static int scenicScore(int[][] forest, int i, int j){
        int height = forest[i][j];
        int left = 1, right = 1 , down = 1, up = 1;

        for (int k = j - 1; k >= 0; k--){

            if (forest[i][k] >= height){
                break;
            }

            if (k == 0)
                left--;
            left++;
        }

        for (int k = j+1; k < 99; k++){

            if (forest[i][k] >= height){
                break;
            }

            if (k == 98)
                right--;
            right++;
        }

        for (int k = i+1; k < 99; k++){

            if (forest[k][j] >= height){
                break;
            }

            if (k == 98)
                down--;
            down++;
        }

        for (int k = i - 1; k >= 0; k--){

            if (forest[k][j] >= height){
                break;
            }

            if (k == 0)
                up--;
            up++;
        }

        return left*right*down*up;
    }
}