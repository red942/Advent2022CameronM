package advent2022.day16to20;
import java.util.*;
import java.io.*;
import java.awt.Point;

public class day20 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File(
            System.getProperty("user.dir") + "/lib/advent2022/day20.txt"));

        int[] order = new int[5000];
        for (int i = 0; i < order.length; i++)
            order[i] = input.nextInt();
         
        ArrayList<Point> actual = new ArrayList<>();
        for (int i = 0; i < order.length; i++)
            actual.add(new Point(i, order[i]));

        for (int i = 0; i < order.length; i++){
            move(actual, i);
        }

        int start = findNum(actual, 0);
        System.out.println( actual.get((start + 1000) % actual.size()).y + actual.get((start + 2000) % actual.size()).y + actual.get((start + 3000) % actual.size()).y);

    }

    public static void move(ArrayList<Point> nums, int n){
        int start = find(nums, n);

        int val = nums.get(start).y;
        int end = start + val;
        if (end < 0)
            end--;
        while (end < 0)
            end += nums.size();
        
        while (end >= nums.size())
            end -= nums.size()-1;

        if (start < end){
            for (int i = start; i < end; i++){
                Collections.swap(nums, i, i+1);
            }
        } else if (start > end) {
            for (int i = start; i > end; i--){
                Collections.swap(nums, i, i-1);
            }
        }
    }

    public static int find(ArrayList<Point> nums, int n){
        for (int i = 0; i < nums.size(); i++){
            if (nums.get(i).x == n)
                return i;
        }
        return -1;
    }

    public static int findNum(ArrayList<Point> nums, int n){
        for (int i = 0; i < nums.size(); i++){
            if (nums.get(i).y == n)
                return i;
        }
        return -1;
    }
}
