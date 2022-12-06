package advent2022.day1to5;
import java.util.Scanner;
import java.util.Arrays;

/* For input, I manually transcribed the initial condition (see bottom of code), pasted that, then pasted the moves, followed by the word done on a new line */

public class SupplyStacks2 {
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        String word = "";
        int numOfCrates = 0, giver = 0, taker = 0;
        char[][] crates = new char[9][56];
        String[] stacks = new String[9];

        for (int i = 0; i < 9; i++)
            stacks[i] = stdin.nextLine();

        for (int i = 0; i < 9; i++){
            for (int j = 0; j < stacks[i].length(); j++){
                crates[i][j] = stacks[i].charAt(j);
            }
        }

        for (int i = 0; i < 9; i++){
            System.out.println(Arrays.toString(crates[i]));
        }

        while (true){
            word = stdin.next();
            if (word.equals("done"))
                break;

            numOfCrates = stdin.nextInt();
            word = stdin.next();
            giver = stdin.nextInt();
            word = stdin.next();
            taker = stdin.nextInt();

            move(numOfCrates, crates[giver-1], crates[taker-1]);
        }

        for (int i = 0; i < 9; i++){
            System.out.println(Arrays.toString(crates[i]));
        }

        stdin.close();
    }

    public static void move(int num, char[] giver, char[] taker){
        char[] nullStore = new char[1];

        int i = 0;
        while (taker[i] != 0){
            i++;
        }
        
        int j = 0;
        while (giver[j] != 0)
            j++;

        for (int k = 0; k < num; k++){
            taker[i+k] = giver[j-num+k];
            giver[j-num+k] = nullStore[0];
        }
    }
}

/*
FCJPHTW
GRVFZJBH
HPTR
ZSNPHT
NVFZHJCD
PMGFWDZ
MVZWSJDP
NDS
DZSFM
*/