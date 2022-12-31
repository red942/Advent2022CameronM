package advent2022.day11to15;
import java.util.ArrayList;
import java.util.Arrays;

public class MonkeyInTheMiddle1 {
    public static void main(String[] args){
        Monkey[] monkies = new Monkey[8];
        ArrayList<Long> m0 = new ArrayList<Long>();
        m0.add(99L);
        m0.add(67L);
        m0.add(92L);
        m0.add(61L);
        m0.add(83L);
        m0.add(64L);
        m0.add(98L);
        monkies[0] = new Monkey(m0, '*', 17, 3, 4, 2);
        ArrayList<Long> m1 = new ArrayList<Long>();
        m1.add(78L);
        m1.add(74L);
        m1.add(88L);
        m1.add(89L);
        m1.add(50L);
        monkies[1] = new Monkey(m1, '*', 11, 5, 3, 5);
        ArrayList<Long> m2 = new ArrayList<Long>();
        m2.add(98L);
        m2.add(91L);
        monkies[2] = new Monkey(m2, '+', 4, 2, 6, 4);
        ArrayList<Long> m3 = new ArrayList<Long>();
        m3.add(59L);
        m3.add(72L);
        m3.add(94L);
        m3.add(91L);
        m3.add(79L);
        m3.add(88L);
        m3.add(94L);
        m3.add(51L);
        monkies[3] = new Monkey(m3, '^', 0, 13, 0, 5);
        ArrayList<Long> m4 = new ArrayList<Long>();
        m4.add(95L);
        m4.add(72L);
        m4.add(78L);
        monkies[4] = new Monkey(m4, '+', 7, 11, 7, 6);
        ArrayList<Long> m5 = new ArrayList<Long>();
        m5.add(76L);
        monkies[5] = new Monkey(m5, '+',8 ,17 ,0 , 2);
        ArrayList<Long> m6 = new ArrayList<Long>();
        m6.add(69L);
        m6.add(60L);
        m6.add(53L);
        m6.add(89L);
        m6.add(71L);
        m6.add(88L);
        monkies[6] = new Monkey(m6, '+', 5, 19, 7, 1);
        ArrayList<Long> m7 = new ArrayList<Long>();
        m7.add(72L);
        m7.add(54L);
        m7.add(63L);
        m7.add(80L);
        monkies[7] = new Monkey(m7, '+', 3, 7, 1, 3);
        int[] cnt = new int[monkies.length];

        for (int index = 0; index < 20; index++){
            for (int i = 0; i < monkies.length; i++){
                for (int j = 0; j < monkies[i].items.size(); j++){
                    if (monkies[i].operator == '+')
                        monkies[i].items.set(j, (monkies[i].items.get(j) + monkies[i].operatorNum)/3);
                    else if (monkies[i].operator == '*')
                        monkies[i].items.set(j, (monkies[i].items.get(j) * monkies[i].operatorNum)/3);
                    else 
                        monkies[i].items.set(j, (monkies[i].items.get(j) * monkies[i].items.get(j))/3);
                    
                    if (monkies[i].items.get(j) % monkies[i].divisor == 0)
                        monkies[monkies[i].truth].items.add(monkies[i].items.get(j));
                    else 
                        monkies[monkies[i].falth].items.add(monkies[i].items.get(j));
                    cnt[i]++;
                }
                monkies[i].items.clear();
            }
        }
        Arrays.sort(cnt);
        System.out.println(cnt[cnt.length - 2] * cnt[cnt.length - 1]);
    }
}
