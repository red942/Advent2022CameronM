import java.util.Scanner;

public class Rucksack2 {
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        String line = "";
        String line2 = "";
        String line3 = "";
        int sum = 0;
        while(true){
            line = stdin.next();
            if (line.equals("done"))
                break;
            line2 = stdin.next();
            if (line2.equals("done"))
                break;
            line3 = stdin.next();
            if (line3.equals("done"))
                break;
            char shared = ' ';
            for (int i = 0; i < line.length(); i++){
                if (shared != ' ')
                    break;
                for (int j = 0; j < line2.length(); j++){
                    if (line.charAt(i) == line2.charAt(j)){
                        for (int k = 0; k < line3.length(); k++){
                            if (line.charAt(i) == line3.charAt(k)){
                                shared = line.charAt(i);
                                break;
                            }
                        }
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
