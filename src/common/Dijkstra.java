package common;
import java.util.*;

public class Dijkstra {

    public int[] dist;
    private Set<Integer> settled;
    private PriorityQueue<Node> pq;
    private int verts;
    List<List<Node>> adj;
    public static void main(String[] args){
        int verts = 5;
        int source = 2;
        List<List<Node>> adj = new ArrayList<List<Node>>();

        for (int i = 0; i < verts; i++){
            List<Node> item = new ArrayList<Node>();
            adj.add(item);
        }

        //adj.get(node).add(new Node(conectingNode, costToNode))
        //these adds are one way, so you'll need to add both to make a 2 way path between 2 nodes
        adj.get(2).add(new Node(1, 2));
        adj.get(2).add(new Node(3, 4));
        adj.get(2).add(new Node(0, 6));

        adj.get(0).add(new Node(1, 9));
        adj.get(0).add(new Node(2, 6));
        adj.get(0).add(new Node(3, 5));
        adj.get(0).add(new Node(4, 3));

        Dijkstra object = new Dijkstra(verts);
        object.algorithm(adj, source);

        //gives distance from source to the index node of dist (in this case from 2 to 3)
        System.out.println(object.dist[3]);
    }

    public Dijkstra(int verts){
        this.verts = verts;
        dist = new int[verts];
        settled = new HashSet<Integer>();
        pq = new PriorityQueue<Node>(verts, new Node());
    }

    private void e_neighbors(int u){
        int edgeDistance = -1;
        int newDistance = -1;

        for (int i = 0; i < adj.get(u).size(); i++){
            Node v = adj.get(u).get(i);

            if(!settled.contains(v.node)) {
                edgeDistance = v.cost;
                newDistance = dist[u] + edgeDistance;

                if (newDistance < dist[v.node])
                    dist[v.node] = newDistance;

                pq.add(new Node(v.node, dist[v.node]));
            }
        }
    }

    public void algorithm(List<List<Node>> adj, int src){
        this.adj = adj;

        for (int i = 0; i < verts; i++)
            dist[i] = Integer.MAX_VALUE;

        pq.add(new Node(src, 0));
        dist[src] = 0;

        while (settled.size() != verts){

            if (pq.isEmpty())
                return;

            int u = pq.remove().node;

            if (settled.contains(u))
                continue;

            settled.add(u);
            e_neighbors(u);
        }
    }
}

