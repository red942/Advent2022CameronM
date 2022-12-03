import java.util.Scanner;

public class Rucksack1 {
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        String line = "";
        int sum = 0;
        while(true){
            line = stdin.next();
            if (line.equals("done"))
                break;
        
            //takes the 2nd half of the line as the 2nd part,
            // I don't bother dropping it from the first half, since I just ignore it
            String line2 = line.substring(line.length()/2, line.length());
            char shared = ' ';
            for (int i = 0; i < line2.length(); i++){
                System.out.println(line.charAt(i));
                if (shared != ' ')
                    break;
                for (int j = 0; j < line2.length(); j++){
                    if (line.charAt(i) == line2.charAt(j)){
                        shared = line.charAt(i);
                        break;
                    }
                }
            }
            sum += value(shared);
        }
        System.out.println(sum);
    }

    //gives the corrosponding value to the letter
    public static int value(char letter){
            if (letter > 96){
                return (letter-96);
            }  else
                return (letter-38);
    }
}
