package advent2022.day1to5;
import java.util.Scanner;

/*code finished by Cameron Miller 11:22PM 12/1/2022 (CST), this is day 2, challenge 2*/
/*for the input, paste in the values to the terminal and then type a new line saying "done done"*/

public class RockPaperScissors2 {
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        int score = 0;

        String opponent = "", move = "";
        while (!opponent.equals("done")){
            opponent = stdin.next();
            move = stdin.next();

            score += gain(move, opponent);
        }

        System.out.println(score);
        stdin.close();
    }

    public static int gain(String move, String opponent){
        if (move.equals("Z")){
            switch (opponent){
                case "A":
                    return 2 + 6;
                case "B":
                    return 3 + 6;
                case "C":
                    return 1 + 6;
            }
        } else if (move.equals("Y")){
            switch (opponent){
                case "A":
                    return 1 + 3;
                case "B":
                    return 2 + 3;
                case "C":
                    return 3 + 3;
            }      
        } else {
            switch (opponent){
                case "A":
                    return 3;
                case "B":
                    return 1;
                case "C":
                    return 2;
            }
        }
        return 0;
    }
}
