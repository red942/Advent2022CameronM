package advent2022.day6to10;
import java.util.Scanner;

public class RopeBridge2 {
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        String direction = "";
        int num = 0;
        char[][] traveled = new char[1200][1200];
        traveled[600][600] = 'O';
        int[] x = {600, 600, 600, 600, 600, 600, 600, 600, 600, 600};
        int[] y = {600, 600, 600, 600, 600, 600, 600, 600, 600, 600};

        while (true){

            direction = stdin.next();
            if (direction.equals("done"))
                break;

            num = stdin.nextInt();

            switch (direction){
                case "R":
                    for (int i = 0; i < num; i++){
                        x[0]++;
                        move(traveled, x, y);
                    }
                    break;
                case "L":
                    for (int i = 0; i < num; i++){
                        x[0]--;
                        move(traveled, x, y);
                    }
                    break;
                case "U":
                    for (int i = 0; i < num; i++){
                        y[0]--;
                        move(traveled, x, y);
                    }
                    break;
                case "D":
                    for (int i = 0; i < num; i++){
                        y[0]++;
                        move(traveled, x, y);
                    }
                    break;
            }

        }
        
        int total = 0;
        for (int i = 0; i < 1200; i++){
            for (int j = 0; j < 1200; j++){
                if (traveled[i][j] == 'O'){
                    total++;
                }
            }
        }
        System.out.println(total);
        stdin.close();
    }

    public static void move(char[][] traveled, int[] x, int[] y){
        for (int i = 1; i <= 9; i++){
            if (x[i-1] == x[i] - 1 && y[i-1] == y[i] - 2){
                x[i]--;
                y[i]--;
                if (i == 9)
                    traveled[x[i]][y[i]] = 'O';
            } else if (x[i-1] == x[i] && y[i-1] == y[i] - 2){
                y[i]--;
                if (i == 9)
                    traveled[x[i]][y[i]] = 'O';
            } else if (x[i-1] == x[i] + 1 && y[i-1] == y[i] - 2){
                x[i]++;
                y[i]--;
                if (i == 9)
                    traveled[x[i]][y[i]] = 'O';
            } else if (x[i-1] == x[i] + 2 && y[i-1] == y[i] - 1){
                x[i]++;
                y[i]--;
                if (i == 9)
                    traveled[x[i]][y[i]] = 'O';
            } else if (x[i-1] == x[i] + 2 && y[i-1] == y[i]){
                x[i]++;
                if (i == 9)
                    traveled[x[i]][y[i]] = 'O';
            } else if (x[i-1] == x[i] + 2 && y[i-1] == y[i] + 1){
                x[i]++;
                y[i]++;
                if (i == 9)
                    traveled[x[i]][y[i]] = 'O';
            } else if (x[i-1] == x[i] - 1 && y[i-1] == y[i] + 2){
                x[i]--;
                y[i]++;
                if (i == 9)
                    traveled[x[i]][y[i]] = 'O';
            } else if (x[i-1] == x[i] && y[i-1] == y[i] + 2){
                y[i]++;
                if (i == 9)
                    traveled[x[i]][y[i]] = 'O';
            } else if (x[i-1] == x[i] + 1 && y[i-1] == y[i] + 2){
                x[i]++;
                y[i]++;
                if (i == 9)
                    traveled[x[i]][y[i]] = 'O';
            } else if (x[i-1] == x[i] - 2 && y[i-1] == y[i] + 1){
                x[i]--;
                y[i]++;
                if (i == 9)
                    traveled[x[i]][y[i]] = 'O';
            } else if (x[i-1] == x[i] - 2 && y[i-1] == y[i]){
                x[i]--;
                if (i == 9)
                    traveled[x[i]][y[i]] = 'O';
            } else if (x[i-1] == x[i] - 2 && y[i-1] == y[i] - 1){
                x[i]--;
                y[i]--;
                if (i == 9)
                    traveled[x[i]][y[i]] = 'O';
            } else if (x[i-1] == x[i] - 2 && y[i-1] == y[i] + 2){
                x[i]--;
                y[i]++;
                if (i == 9)
                    traveled[x[i]][y[i]] = 'O';
            } else if (x[i-1] == x[i] - 2 && y[i-1] == y[i] - 2){
                x[i]--;
                y[i]--;
                if (i == 9)
                    traveled[x[i]][y[i]] = 'O';
            } else if (x[i-1] == x[i] + 2 && y[i-1] == y[i] - 2){
                x[i]++;
                y[i]--;
                if (i == 9)
                    traveled[x[i]][y[i]] = 'O';
            } else if (x[i-1] == x[i] + 2 && y[i-1] == y[i] + 2){
                x[i]++;
                y[i]++;
                if (i == 9)
                    traveled[x[i]][y[i]] = 'O';
            }
        }
    }
}