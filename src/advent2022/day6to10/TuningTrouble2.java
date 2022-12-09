package advent2022.day6to10;
import java.util.Scanner;

public class TuningTrouble2 {
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        String input = stdin.next();
        String marker = "";
        int position = 0;
        boolean found = false;

        while (!found){
            found = true;
            marker = input.substring(position, position+14);

            for (int j = 0; j < 13; j++){
                for (int k = j + 1; k < 14; k++){
                    if (marker.charAt(j) == marker.charAt(k)){
                        found = false;
                    }
                }
            }

            position++;
        }

        System.out.print(position+13);
        stdin.close();
    }
}
