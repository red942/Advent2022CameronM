package advent2022.day11to15;
import java.util.ArrayList;


public class Monkey {
    ArrayList<Long> items;
    char operator;
    int operatorNum;
    int divisor;
    int truth, falth;

    public Monkey (ArrayList<Long> items, char operator, int operatorNum, int divisor, int truth, int falth){
        this.items = items;
        this.operator = operator;
        this.operatorNum = operatorNum;
        this.divisor = divisor;
        this.truth = truth;
        this.falth = falth;
    }
}
