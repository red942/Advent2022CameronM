package advent2022.day21to25;

public class Monkey {
    String name;
    int type; //0 is int, 1 is add, 2 is subtract, 3 is multiply, 4 is divide
    Monkey[] others;
    long val; //if type is 0;


    public Monkey(){
    }

    public void setName(String name){
        this.name = name;
    }
    public void set(int type, Monkey o1, Monkey o2, long val){
        this.type = type;
        others = new Monkey[2];
        others[0] = o1;
        others[1] = o2;
        this.val = val;
    }

    public long getVal(){
        switch(type){
            case 0:
                return val;
            case 1:
                return (others[0].getVal() + others[1].getVal());
            case 2:
                return (others[0].getVal() - others[1].getVal());
            case 3:
                return (others[0].getVal() * others[1].getVal());
            case 4:
                return (others[0].getVal() / others[1].getVal());
        }
        return -11111L;
    }

    public void setVal(long n){
        val = n;
    }

    public String toString(){
        if (type == 0)
            return (name + ": " + val);

        String s = "";
        switch (type){
            case 1:
                s = "+";
                break;
            case 2:
                s = "-";
                break;
            case 3:
                s = "*";
                break;
            case 4:
                s = "/";
                break;
        }
        return (name + ": " + others[0].name + " " + s + " " + others[1].name);
    }
}
