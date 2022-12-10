package advent2022.day6to10;
import java.util.Scanner;

public class RopeBridge1 {
    public static void main(String[] args){

        Scanner stdin = new Scanner(System.in);
        String direction = "";
        int num = 0;
        char[][] bridge = new char[1200][1200];
        char[][] traveled = new char[1200][1200];

        bridge[600][600] = 'B';
        traveled[600][600] = 'O';

        while (true){

            direction = stdin.next();
            if (direction.equals("done"))
                break;

            num = stdin.nextInt();

            switch (direction){
                case "R":
                    for (int i = 0; i < num; i++)
                        moveR(bridge, traveled);
                    break;
                case "L":
                    for (int i = 0; i < num; i++)
                        moveL(bridge, traveled);
                    break;
                case "U":
                    for (int i = 0; i < num; i++)
                        moveU(bridge, traveled);
                    break;
                case "D":
                    for (int i = 0; i < num; i++)
                        moveD(bridge, traveled);
                    break;
            }
        }
        
        int total = 0;
        for (int i = 0; i < 1200; i++){
            for (int j = 0; j < 1200; j++){
                if (traveled[i][j] == 'O')
                    total++;
            }
        }
        System.out.println(total);
        stdin.close();
    }

    public static void moveR(char[][] bridge, char[][] traveled){

        int tx = -1, hx = -1, ty = -1, hy = -1;
        for (int i = 0; i < 1200; i++){
            for (int j = 0; j < 1200; j++){
                if (bridge[i][j] == 'T'){
                    tx = i;
                    ty = j;
                } else if (bridge[i][j] == 'H'){
                    hx = i;
                    hy = j;
                } else if (bridge[i][j] == 'B'){
                    tx = i;
                    hx = i;
                    ty = j;
                    hy = j;
                }
            }
        }

        
        char[] nullStore = new char[1];
        if (hy == ty - 1){ //above
            if (hx == tx - 1){
                bridge[hx+1][hy] = 'H';
                bridge[hx][hy] = nullStore[0];
            } else if (hx == tx){
                bridge[hx+1][hy] = 'H';
                bridge[hx][hy] = nullStore[0];
            } else {
                bridge[hx+1][hy] = 'H';
                bridge[hx][hy] = 'T';
                bridge[tx][ty] = nullStore[0];
                traveled[hx][hy] = 'O';
            }
        } else if (hy == ty){ //same
            if (hx == tx - 1){
                bridge[hx+1][hy] = 'B';
                bridge[hx][hy] = nullStore[0];
            } else if (hx == tx){
                bridge[hx+1][hy] = 'H';
                bridge[hx][hy] = 'T';
            } else {
                bridge[hx+1][hy] = 'H';
                bridge[hx][hy] = 'T';
                bridge[tx][ty] = nullStore[0];
                traveled[hx][hy] = 'O';
            }
        } else { //below
            if (hx == tx - 1){
                bridge[hx+1][hy] = 'H';
                bridge[hx][hy] = nullStore[0];
            } else if (hx == tx){
                bridge[hx+1][hy] = 'H';
                bridge[hx][hy] = nullStore[0];
            } else {
                bridge[hx+1][hy] = 'H';
                bridge[hx][hy] = 'T';
                bridge[tx][ty] = nullStore[0];
                traveled[hx][hy] = 'O';
            }
        }
    }

    public static void moveL(char[][] bridge, char[][] traveled){

        int tx = -1, hx = -1, ty = -1, hy = -1;
        for (int i = 0; i < 1200; i++){
            for (int j = 0; j < 1200; j++){
                if (bridge[i][j] == 'T'){
                    tx = i;
                    ty = j;
                } else if (bridge[i][j] == 'H'){
                    hx = i;
                    hy = j;
                } else if (bridge[i][j] == 'B'){
                    tx = i;
                    hx = i;
                    ty = j;
                    hy = j;
                }
            }
        }

        char[] nullStore = new char[1];
        if (hy == ty - 1){ //above
            if (hx == tx - 1){
                bridge[hx-1][hy] = 'H';
                bridge[hx][hy] = 'T';
                bridge[tx][ty] = nullStore[0];
                traveled[hx][hy] = 'O';
            } else if (hx == tx){
                bridge[hx-1][hy] = 'H';
                bridge[hx][hy] = nullStore[0];
            } else {
                bridge[hx-1][hy] = 'H';
                bridge[hx][hy] = nullStore[0];
            }
        } else if (hy == ty){ //same
            if (hx == tx - 1){
                bridge[hx-1][hy] = 'H';
                bridge[hx][hy] = 'T';
                bridge[tx][ty] = nullStore[0];
                traveled[hx][hy] = 'O';
            } else if (hx == tx){
                bridge[hx-1][hy] = 'H';
                bridge[hx][hy] = 'T';
            } else {
                bridge[hx-1][hy] = 'B';
                bridge[hx][hy] = nullStore[0];
            }
        } else { //below
            if (hx == tx - 1){
                bridge[hx-1][hy] = 'H';
                bridge[hx][hy] = 'T';
                bridge[tx][ty] = nullStore[0];
                traveled[hx][hy] = 'O';
            } else if (hx == tx){
                bridge[hx-1][hy] = 'H';
                bridge[hx][hy] = nullStore[0];
            } else {
                bridge[hx-1][hy] = 'H';
                bridge[hx][hy] = nullStore[0];
            }
        }
    }

    public static void moveU(char[][] bridge, char[][] traveled){

        int tx = -1, hx = -1, ty = -1, hy = -1;
        for (int i = 0; i < 1200; i++){
            for (int j = 0; j < 1200; j++){
                if (bridge[i][j] == 'T'){
                    tx = i;
                    ty = j;
                } else if (bridge[i][j] == 'H'){
                    hx = i;
                    hy = j;
                } else if (bridge[i][j] == 'B'){
                    tx = i;
                    hx = i;
                    ty = j;
                    hy = j;
                }
            }
        }

        char[] nullStore = new char[1];
        if (hy == ty - 1){ //above
            if (hx == tx - 1){
                bridge[hx][hy-1] = 'H';
                bridge[hx][hy] = 'T';
                bridge[tx][ty] = nullStore[0];
                traveled[hx][hy] = 'O';
            } else if (hx == tx){
                bridge[hx][hy-1] = 'H';
                bridge[hx][hy] = 'T';
                bridge[tx][ty] = nullStore[0];
                traveled[hx][hy] = 'O';
            } else {
                bridge[hx][hy-1] = 'H';
                bridge[hx][hy] = 'T';
                bridge[tx][ty] = nullStore[0];
                traveled[hx][hy] = 'O';
            }
        } else if (hy == ty){ //same
            if (hx == tx - 1){
                bridge[hx][hy-1] = 'H';
                bridge[hx][hy] = nullStore[0];
            } else if (hx == tx){
                bridge[hx][hy-1] = 'H';
                bridge[hx][hy] = 'T';
            } else {
                bridge[hx][hy-1] = 'H';
                bridge[hx][hy] = nullStore[0];
            }
        } else { //below
            if (hx == tx - 1){
                bridge[hx][hy-1] = 'H';
                bridge[hx][hy] = nullStore[0];
            } else if (hx == tx){
                bridge[hx][hy-1] = 'B';
                bridge[hx][hy] = nullStore[0];
            } else {
                bridge[hx][hy-1] = 'H';
                bridge[hx][hy] = nullStore[0];
            }
        }
    }

    public static void moveD(char[][] bridge, char[][] traveled){

        int tx = -1, hx = -1, ty = -1, hy = -1;
        for (int i = 0; i < 1200; i++){
            for (int j = 0; j < 1200; j++){
                if (bridge[i][j] == 'T'){
                    tx = i;
                    ty = j;
                } else if (bridge[i][j] == 'H'){
                    hx = i;
                    hy = j;
                } else if (bridge[i][j] == 'B'){
                    tx = i;
                    hx = i;
                    ty = j;
                    hy = j;
                }
            }
        }

        char[] nullStore = new char[1];
        if (hy == ty - 1){ //above
            if (hx == tx - 1){
                bridge[hx][hy+1] = 'H';
                bridge[hx][hy] = nullStore[0];
            } else if (hx == tx){
                bridge[hx][hy+1] = 'B';
                bridge[hx][hy] = nullStore[0];
            } else {
                bridge[hx][hy+1] = 'H';
                bridge[hx][hy] = nullStore[0];
            }
        } else if (hy == ty){ //same
            if (hx == tx - 1){
                bridge[hx][hy+1] = 'H';
                bridge[hx][hy] = nullStore[0];
            } else if (hx == tx){
                bridge[hx][hy+1] = 'H';
                bridge[hx][hy] = 'T';
            } else {
                bridge[hx][hy+1] = 'H';
                bridge[hx][hy] = nullStore[0];
            }
        } else { //below
            if (hx == tx - 1){
                bridge[hx][hy+1] = 'H';
                bridge[hx][hy] = 'T';
                bridge[tx][ty] = nullStore[0];
                traveled[hx][hy] = 'O';
            } else if (hx == tx){
                bridge[hx][hy+1] = 'H';
                bridge[hx][hy] = 'T';
                bridge[tx][ty] = nullStore[0];
                traveled[hx][hy] = 'O';
            } else {
                bridge[hx][hy+1] = 'H';
                bridge[hx][hy] = 'T';
                bridge[tx][ty] = nullStore[0];
                traveled[hx][hy] = 'O';
            }
        }
    }
}
