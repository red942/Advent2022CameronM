package advent2022.day16to20;
import java.util.*;
import java.io.*;

public class GrovePositioningSystem2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File(
            System.getProperty("user.dir") + "/lib/advent2022/day20.txt"));

        long[] order = new long[5000];
        for (int i = 0; i < order.length; i++)
            order[i] = input.nextLong() * 811589153;
         
        ArrayList<Pointy> actual = new ArrayList<>();
        for (int i = 0; i < order.length; i++)
            actual.add(new Pointy(i, order[i]));

        for (int j = 0; j < 10; j++){
            for (int i = 0; i < order.length; i++){
                move(actual, i);
            }
        }

        int start = findNum(actual, 0);
        System.out.println(actual.get((start + 1000) % actual.size()).y + actual.get((start + 2000) % actual.size()).y + actual.get((start + 3000) % actual.size()).y);
        input.close();
    }

    public static void move(ArrayList<Pointy> nums, int n){
        int start = find(nums, n);
        Pointy temp = nums.get(start);

        nums.remove(start);
        int end = Math.floorMod(start + temp.y, nums.size());
        nums.add(end, temp);
    }

    public static int find(ArrayList<Pointy> nums, int n){
        for (int i = 0; i < nums.size(); i++){
            if (nums.get(i).x == n)
                return i;
        }
        return -1;
    }

    public static int findNum(ArrayList<Pointy> nums, int n){
        for (int i = 0; i < nums.size(); i++){
            if (nums.get(i).y == n)
                return i;
        }
        return -1;
    }
}
