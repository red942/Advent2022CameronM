package advent2022.day6to10;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class CathodeRayTube1 {
    public static void main(String[] args) throws FileNotFoundException{
        Scanner input = new Scanner(new File(System.getProperty("user.dir") + "/lib/advent2022/day10.txt"));
        int cycle = 0;
        int x = 1;
        int sum = 0;
        int progress = 0;
        int temp = 0;
        while (input.hasNextLine()){

            String command = input.next();

            if (command.equals("noop") && progress == 1){
                cycle++;
                progress = 0;
                if (cycle == 20 || cycle == 60 || cycle == 100 || cycle == 140 || cycle == 180 || cycle == 220){
                    sum += cycle*x;
                }
                x += temp;
                cycle++;
                if (cycle == 20 || cycle == 60 || cycle == 100 || cycle == 140 || cycle == 180 || cycle == 220){
                    sum += cycle*x;
                }
            } else if (command.equals("noop")){
                cycle++;

                if (cycle == 20 || cycle == 60 || cycle == 100 || cycle == 140 || cycle == 180 || cycle == 220){
                }
            }
            
            if (command.equals("addx") && progress == 1){
                cycle++;

                if (cycle == 20 || cycle == 60 || cycle == 100 || cycle == 140 || cycle == 180 || cycle == 220){
                    sum += cycle*x;
                }
                x += temp;
                temp = input.nextInt();
                cycle++;

                if (cycle == 20 || cycle == 60 || cycle == 100 || cycle == 140 || cycle == 180 || cycle == 220){
                    sum += cycle*x;
                }
            } else if (command.equals("addx")){
                temp = input.nextInt();
                progress = 1;
                cycle++;
                if (cycle == 20 || cycle == 60 || cycle == 100 || cycle == 140 || cycle == 180 || cycle == 220){
                    sum += cycle*x;
                }
            }
        }
        System.out.print(sum);
        input.close();
    }
}
