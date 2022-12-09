package advent2022.day6to10;

public class Directory {
    Directory parent;
    Directory[] children = new Directory[100];
    private int[] files = new int[100];
    private int cnt;
    private int cnt2;
    public String name;

    public Directory(Directory parent, String name){
        this.parent = parent;
        this.name = name;
    }

    public void addChild(Directory child){
        children[cnt] = child;
        cnt++;
    }

    public int getSize(){
        int sum = 0;
        for (int n : files)
            sum += n;
        for (Directory c : children){
            if (c != null)
            sum += c.getSize();
        }
        return sum;
    }

    public void addFile(int sz){
        files[cnt2] = sz;
        cnt2++;
    }

    public boolean isChild(Directory p){
        if (this.parent == p)
            return true;
        return false;
    }
}
