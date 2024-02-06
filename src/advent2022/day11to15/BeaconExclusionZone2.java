package advent2022.day11to15;
import java.util.*;
import java.io.*;
import java.awt.Point;

public class BeaconExclusionZone2 {
    public static void main(String[] args) throws FileNotFoundException{
        Scanner input = new Scanner(new File(
            System.getProperty("user.dir") + "/lib/advent2022/day15.txt"));

        int[] sXs = new int[25];
        int[] sYs = new int[25];
        int[] bXs = new int[25];
        int[] bYs = new int[25];
        int[] radii = new int[25];
        Point[] sensors = new Point[25];
        
        int cnt = 0;
        while (input.hasNextLine()){
            String s = input.nextLine().substring(12);
            String temp = "";
            for (int i = 0; i < s.length(); i++){
                if (s.charAt(i) == ','){
                    s = s.substring(i + 4);
                    break;
                }
                else
                    temp += s.charAt(i);
            }
            sXs[cnt] = Integer.valueOf(temp);

            temp = "";
            for (int i = 0; i < s.length(); i++){
                if (s.charAt(i) == ':'){
                    s = s.substring(i + 25);
                    break;
                }
                else
                    temp += s.charAt(i);
            }
            sYs[cnt] = Integer.valueOf(temp);

            temp = "";
            for (int i = 0; i < s.length(); i++){
                if (s.charAt(i) == ','){
                    s = s.substring(i + 4);
                    break;
                }
                else
                    temp += s.charAt(i);
            }
            bXs[cnt] = Integer.valueOf(temp);
            bYs[cnt] = Integer.valueOf(s);
            cnt++;

        }

        for (int i = 0; i < bXs.length; i++)
            radii[i] = Math.abs(bXs[i]-sXs[i]) + Math.abs(bYs[i]-sYs[i]);
        for (int i = 0; i < 25; i++)
            sensors[i] = new Point(sXs[i], sYs[i]);

        Point beacon = getBeacon(sensors, radii);
        long x = (long)beacon.getX();
        long y = (long)beacon.getY();
        System.out.println((x*4_000_000) + y);
        input.close();
    }

    public static Point getBeacon(Point[] sensors, int[] radii){
        for (int i = 0; i < sensors.length; i++){
            int x = (int) sensors[i].getX();
            int y = (int) sensors[i].getY();
            int radius = radii[i];
            
            //the lower bound for the values we are testing is either 0 or the furthest left point
            //the upper bound is either 4,000,000 or the furthest right point
            //testX is an x coordinate of a point, just outside the radius of sensors[i], same for testY later on
            for (int testX = Math.max(0, x - radius - 1); testX < Math.min(4_000_000 + 1, x + radius + 2); testX++){
                int dx = Math.abs(x - testX);

                //for each x value, there are 2 ys that we need to test, I store these in an array and then enhanced for through it
                int[] ys = {y + (radius - dx) + 1, y - (radius - dx) - 1};

                for (int testY : ys){
                    boolean inRadius = false;
                    Point testPoint = new Point(testX, testY);

                    //tests to see if it lies within each sensor's radius
                    for (int j = 0; j < sensors.length; j++){
                        //sees if the test point is within the radius of the current sensor we are testing
                        if (distance(testPoint, sensors[j]) <= radii[j]){
                            inRadius = true;
                            break;
                        }
                    }

                    if (!inRadius)
                        return testPoint;
                }
            }

        }
        return null;
    }

    public static int distance(Point a, Point b){
        return Math.abs(((int) a.getX()) - ((int) b.getX())) + Math.abs(((int) a.getY()) - ((int) b.getY()));
    }

}


