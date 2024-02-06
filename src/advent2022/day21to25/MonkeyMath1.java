package advent2022.day21to25;
import java.util.*;
import java.io.*;

public class MonkeyMath1 {
    public static void main(String[] args) throws FileNotFoundException{
        Scanner input = new Scanner(new File(
            System.getProperty("user.dir") + "/lib/advent2022/day21.txt"));


        Monkey[] monkeys = new Monkey[2161];
        for (int i = 0; i < monkeys.length; i++)
            monkeys[i] = new Monkey();
        ArrayList<String> strings = new ArrayList<>();
        ArrayList<Integer> ints = new ArrayList<>();

        int cnt = 0;
        while (input.hasNextLine()){
            String s = input.nextLine();
            String name = s.substring(0, 4);
            s = s.substring(6);

            if (s.charAt(0) < 63){
                monkeys[cnt].setName(name);
                monkeys[cnt].set(0, null, null, Long.valueOf(s));
            } else {
                monkeys[cnt].setName(name);
                strings.add(s);
                ints.add(cnt);
            }
            cnt++;
        }

        for (int i = 0; i < strings.size(); i++){
            char op = strings.get(i).charAt(5);
            int type = -1;
            switch (op){
                case '+':
                    type = 1;
                    break;
                case '-':
                    type = 2;
                    break;
                case '*':
                    type = 3;
                    break;
                case '/':
                    type = 4;
                    break;
            }

            int index1 = -1, index2 = -1;
            index1 = findName(strings.get(i).substring(0, 4), monkeys);
            index2 = findName(strings.get(i).substring(7, 11), monkeys);

            monkeys[ints.get(i)].set(type, monkeys[index1], monkeys[index2], -11111L);
        }

        System.out.println(monkeys[findName("root", monkeys)].getVal());
        input.close();
    }

    public static int findName(String name, Monkey[] monkeys){
        for (int i = 0; i < monkeys.length; i++){
            if (monkeys[i].name.equals(name))
                return i;
        }
        return -1;
    }
}
