package common;
import java.util.*;

public class Node implements Comparator<Node>{
    public int node, cost;

    public Node(){
    }

    public Node(int node, int cost){
        this.node = node;
        this.cost = cost;
    }

    @Override
    public int compare(Node a, Node b){
        if (a.cost < b.cost)
            return -1;
        else if (b.cost < a.cost)
            return 1;
        return 0;
    }
}