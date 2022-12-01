package advent2022.day1to5;
import java.util.Scanner;
import java.util.Arrays;

/*code finished by Cameron Miller 10:54AM 12/1/2022 (CST), this is day 1, challenge 2*/
/*for the input, paste in the values to the terminal and then type a new line saying "done" after a blank line */

public class elfCalorie2 {
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        int[] elfHighs = new int[3];
        int elfTemp = 0;
        while (true){
            Arrays.sort(elfHighs);
            String num = stdin.nextLine();
            if (num.equals("done"))
                break;
            if (num.equals("")){

                if (elfTemp > elfHighs[0]){
                    elfHighs[0] = elfTemp;
                }
                elfTemp = 0;
                continue;
            }
            elfTemp += Integer.valueOf(num);
        }
        System.out.println(Arrays.toString(elfHighs));
        int sum = 0;
        for (int n : elfHighs)
            sum += n;
        System.out.println(sum);
        stdin.close();
    }
}
