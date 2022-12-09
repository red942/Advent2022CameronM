package advent2022.day6to10;
import java.util.Scanner;

public class NoSpaceLeftOnDevice1 {
    
    Directory rootDirectory;
    Directory[] directories = new Directory[1000];
    private int cnt = 1;
    public static void main(String[] args){
        NoSpaceLeftOnDevice1 object = new NoSpaceLeftOnDevice1();
        Scanner stdin = new Scanner(System.in);
        String input = "";

        while (true){

            input = stdin.nextLine();
            if (input.equals("done"))
                break;

            if (input.charAt(0) == '$'){
                input = input.substring(2);
                object.cmd(input);
            } else if (input.substring(0,3).equals("dir")){
                input = input.substring(4);
                object.directories[object.cnt] = new Directory(object.directories[0], input);
                object.directories[0].addChild(object.directories[object.cnt]);
                object.cnt++;
            } else {
                String temp = "";
                int i = 0;
                while (input.charAt(i) != ' '){
                    temp += ("" + input.charAt(i));
                    i++;
                }
                object.directories[0].addFile(Integer.valueOf(temp));
            }

        }

        System.out.println(object.getSum());
        stdin.close();
    }

    public void cmd(String input){
        if (input.substring(0, 2).equals("cd")){
            input = input.substring(3);
            switch(input){
                case "/":
                    rootDirectory = new Directory(null, "/");
                    directories[0] = rootDirectory;
                    break;
                case "..":
                    swap(find(directories[0].parent));
                    break;
                default:
                    swap(find(input, directories[0]));
                    break;
            }
        }
    }

    public int getSum(){
        int sum = 0;

        for (Directory dir : directories){
            if (dir != null && dir.getSize() <= 100000)
                sum += dir.getSize();
        }

        return sum;
    }

    public int find(Directory parent){
        for (int i = 1; i < 1000; i++){
            if (directories[i] == parent)
                return i;
        }
        return -1;
    }

    public int find(String targetName, Directory parent){
        for (int i = 1; 1 < 1000; i++){
            if(directories[i].isChild(parent) && directories[i].name.equals(targetName)){
                    return i;
            }
        }
    }

    public void swap(int target){
        Directory[] temp = new Directory[1000];
        temp[0] = directories[target];

        for (int i = 1; i < target; i++){
            temp[i] = directories[i];
        }

        temp[target] = directories[0];

        for (int i = target+1; i < 1000; i++){
            temp[i] = directories[i];
        }

        directories = temp;
    }
}
