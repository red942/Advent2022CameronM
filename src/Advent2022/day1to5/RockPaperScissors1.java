package advent2022.day1to5;
import java.util.Scanner;

/*code finished by Cameron Miller 11:13PM 12/1/2022 (CST), this is day 2, challenge 1*/
/*for the input, paste in the values to the terminal and then type a new line saying "done done"*/

public class RockPaperScissors1 {
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        int score = 0;

        String opponent = "", player = "";
        while (!opponent.equals("done")){
            opponent = stdin.next();
            player = stdin.next();
            switch(player){
                case "X": //default score for rock
                    score += 1;
                    break;
                case "Y": //default score for paper
                    score += 2;
                    break;
                case "Z": //default score for scissors
                    score += 3;
                    break;
            }
            score += gain(player, opponent);
        }

        System.out.println(score);
        stdin.close();
    }

    //figures out how much we gain from a game
    public static int gain(String player, String opponent){
        if (player.equals("X")){ 
            switch (opponent){
                case "A":
                    return 3;
                case "B":
                    return 0;
                case "C":
                    return 6;
            }
        } else if (player.equals("Y")){ 
            switch (opponent){
                case "A":
                    return 6;
                case "B":
                    return 3;
                case "C":
                    return 0;
            }      
        } else {
            switch (opponent){
                case "A":
                    return 0;
                case "B":
                    return 6;
                case "C":
                    return 3;
            }
        }
        return 0;
    }
}
