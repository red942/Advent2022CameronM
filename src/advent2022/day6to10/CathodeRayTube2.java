package advent2022.day6to10;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class CathodeRayTube2 {
    public static void main(String[] args) throws FileNotFoundException{
        char[] sprite = new char[40];
        Scanner input = new Scanner(new File(System.getProperty("user.dir") + "/lib/advent2022/day10.txt"));
        int cycle = 0;
        int x = 1;
        int progress = 0;
        int temp = 0;
        while (input.hasNextLine()){

            String command = input.next();

            if (command.equals("noop") && progress == 1){
                cycle++;
                cycle(x, cycle, sprite);
                progress = 0;
                x += temp;
                cycle++;
                cycle(x, cycle, sprite);
            } else if (command.equals("noop")){
                cycle++;
                cycle(x, cycle, sprite);
            }
            
            if (command.equals("addx") && progress == 1){
                cycle++;
                cycle(x, cycle, sprite);
                x += temp;
                temp = input.nextInt();
                cycle++;
                cycle(x, cycle, sprite);
            } else if (command.equals("addx")){
                temp = input.nextInt();
                progress = 1;
                cycle++;
                cycle(x, cycle, sprite);
            }
        }
    }

    public static void cycle(int x, int cycle, char[] sprite){

        for (int i = 0; i < 40; i++){
            if (i >= 0 && i < 40)
                sprite[i] = ' ';
        }

        for (int i = x-1; i <= x+1; i++){
            if (i >= 0 && i < 40)
                sprite[i] = '#';
        }
        
        cycle--; //goes from cycle number to array number
        while (cycle > 39)
            cycle -= 40;

        if (cycle == 39)
            System.out.println(sprite[cycle]);
        else
            System.out.print(sprite[cycle]);
    }

}
