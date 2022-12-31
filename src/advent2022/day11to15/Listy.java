package advent2022.day11to15;
import java.util.*;

public class Listy{
    public int length;
    public ArrayList<Boolean> type = new ArrayList<Boolean>(); //true means a listy at that index
    public ArrayList<Integer> nums = new ArrayList<Integer>();
    public ArrayList<Listy> listys = new ArrayList<Listy>();
    public Listy parent;
    public boolean open;

    public Listy(){
    }

    public Listy(boolean a){
        length = -1;
    }

    public void add(Listy listy){
        listy.parent = this;
        type.add(true);
        listys.add(listy);
        nums.add(-1);
        length++;
    }

    public void add(int num){
        type.add(false);
        listys.add(new Listy(true));
        nums.add(num);
        length++;
    }

    public String toString(){
        String out = "";
        out += "[";
        for (int i = 0; i < length; i++){
            if (!type.get(i)) {
                out += String.valueOf(nums.get(i));
                if (i != length - 1)
                    out += ",";
            }
            else {
                out += listys.get(i).toString();
                if (i != length - 1)
                    out += ",";
            }
        }
        out += "]";
        return out;
    }

    public static Listy fromString(String s){
        ArrayList<Listy> set = new ArrayList<Listy>();
        String num = "";
        char prev = ' ';

        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '['){
                set.add(new Listy());
                if (set.size() != 1){
                    for (int j = set.size() - 2; j >= 0; j--){
                        if (set.get(j).open){
                            set.get(set.size() - 1).parent = set.get(j);
                            set.get(j).add(set.get(set.size()-1));
                            prev = '[';
                            break;
                        }
                    }
                }
                set.get(set.size() - 1).open = true;
            } else if (s.charAt(i) == ']'){
                for (int j = set.size() - 1; j >= 0; j--){
                    if (set.get(j).open){
                        if (prev == 'n'){
                            set.get(j).add(Integer.valueOf(num));
                            num = "";
                        }
                        set.get(j).open = false;
                        prev = ']';
                        break;
                    }
                }
            } else if (s.charAt(i) == ','){
                if (prev == 'n'){
                    for (int j = set.size() - 1; j >=0 ; j--){
                        if (set.get(j).open){
                            set.get(j).add(Integer.valueOf(num));
                            num = "";
                            prev = ',';
                            break;
                        }
                    }
                } else {
                    prev = ',';
                    continue;
                }
            } else {
                prev = 'n';
                num += s.charAt(i);
            }   
        }
        return set.get(0);
    }

    public int compareTo(Listy other){ //returns 1 if "this" comes first, -1 if other comes first

        int length = (other.length > this.length)? this.length : other.length;
        //System.out.println(this + " compared to " + other);
        for (int i = 0; i < length; i++){
            if (this.type.get(i) && other.type.get(i)){ //2 lists

                if (this.listys.get(i).compareTo(other.listys.get(i)) == 0)
                    continue;
                else
                    return this.listys.get(i).compareTo(other.listys.get(i));
            } else if (!this.type.get(i) && !other.type.get(i)){ //2 ints
                if (this.nums.get(i) > other.nums.get(i))
                    return -1;
                else if (this.nums.get(i) < other.nums.get(i))
                    return 1;
            } else { //mixed
                if (this.type.get(i)){ //this is list
                    Listy temp = new Listy();
                    temp.add(other.nums.get(i));
                    if (this.listys.get(i).compareTo(temp) == 0)
                        continue;
                    else
                        return this.listys.get(i).compareTo(temp);
                } else { //other is list
                    //System.out.println("made it");
                    Listy temp = new Listy();
                    temp.add(this.nums.get(i));
                    if (temp.compareTo(other.listys.get(i)) == 0)
                        continue;
                    else
                        return temp.compareTo(other.listys.get(i));
                }
            }
        }
        if (this.length < other.length)
            return 1;
        else if (other.length < this.length)
            return -1;
        return 0;
    }

    public boolean equals(Listy b){
        if (this.length == b.length){
            for (int i = 0; i < b.length; i++){
                if (b.nums.get(i) == this.nums.get(i) && b.listys.get(i).equals(this.listys.get(i)))
                    continue;
                else return false;
            }
        } else 
            return false;
        return true;
    }

}