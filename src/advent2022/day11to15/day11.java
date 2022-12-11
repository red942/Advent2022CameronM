package advent2022.day11to15;
import java.util.ArrayList;
import java.util.Arrays;

public class day11 {

    public static void main(String[] args){
        data[] monkies = new data[8];
        ArrayList<Integer> m0 = new ArrayList<Integer>();
        m0.add(99);
        m0.add(67);
        m0.add(92);
        m0.add(61);
        m0.add(83);
        m0.add(64);
        m0.add(98);
        monkies[0] = new data(m0, '*', 17, 3, 4, 2);
        ArrayList<Integer> m1 = new ArrayList<Integer>();
        m1.add(78);
        m1.add(74);
        m1.add(88);
        m1.add(89);
        m1.add(50);
        monkies[1] = new data(m1, '*', 11, 5, 3, 5);
        ArrayList<Integer> m2 = new ArrayList<Integer>();
        m2.add(98);
        m2.add(91);
        monkies[2] = new data(m2, '+', 4, 2, 6, 4);
        ArrayList<Integer> m3 = new ArrayList<Integer>();
        m3.add(59);
        m3.add(72);
        m3.add(94);
        m3.add(91);
        m3.add(79);
        m3.add(88);
        m3.add(94);
        m3.add(51);
        monkies[3] = new data(m3, '^', 0, 13, 0, 5);
        ArrayList<Integer> m4 = new ArrayList<Integer>();
        m4.add(95);
        m4.add(72);
        m4.add(78);
        monkies[4] = new data(m4, '+', 7, 11, 7, 6);
        ArrayList<Integer> m5 = new ArrayList<Integer>();
        m5.add(76);
        monkies[5] = new data(m5, '+',8 ,17 ,0 , 2);
        ArrayList<Integer> m6 = new ArrayList<Integer>();
        m6.add(69);
        m6.add(60);
        m6.add(53);
        m6.add(89);
        m6.add(71);
        m6.add(88);
        monkies[6] = new data(m6, '+', 5, 19, 7, 1);
        ArrayList<Integer> m7 = new ArrayList<Integer>();
        m7.add(72);
        m7.add(54);
        m7.add(63);
        m7.add(80);
        monkies[7] = new data(m7, '+', 3, 7, 1, 3);
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
