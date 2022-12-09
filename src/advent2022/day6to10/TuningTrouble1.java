package advent2022.day6to10;
import java.util.Scanner;

public class TuningTrouble1 {
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        String input = stdin.next();
        String marker = "";
        int position = 0;
        boolean found = false;

        while (!found){
            found = true;
            marker = input.substring(position, position+4);

            for (int j = 0; j < 3; j++){
                for (int k = j + 1; k < 4; k++){
                    if (marker.charAt(j) == marker.charAt(k)){
                        found = false;
                    }
                }
            }

            position++;
        }

        System.out.print(position+3);
        stdin.close();
    }
}
