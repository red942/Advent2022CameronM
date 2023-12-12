package advent2023.day6;
import java.util.*;

public class Temp {
    public static void main(String[] args) {
        HashSet<String> al = new HashSet<>();
        Scanner stdin = new Scanner(System.in);

        while (true) {
            String temp = toCase(stdin.next());
            if (al.add(temp))
                System.out.println("new");
            else 
                System.out.println("old");
            if (al.contains("End1"))
                break;
        }

        stdin.close();
    }    

    private static String toCase(String s) {
        return s.substring(0, 1).toUpperCase() + s.substring(1);
    }
}
