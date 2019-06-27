import java.util.*;

public class Maxflow{
    
     public static void main(String []args){
        List<Edge> edges = new LinkedList<Edge>();
        int nodeNum = 6;
        int max = 0;

        edges.add(new Edge(0, 1, 3, 0));
        edges.add(new Edge(0, 3, 2, 0));
        edges.add(new Edge(1, 4, 1, 0));
        edges.add(new Edge(1, 2, 2, 0));
        edges.add(new Edge(2, 5, 2, 0));
        edges.add(new Edge(3, 2, 1, 0));
        edges.add(new Edge(3, 4, 1, 0));
        edges.add(new Edge(4, 5, 2, 0));

        Digraph g = new Digraph(edges, nodeNum);

        Edge[] edgeTo = new Edge[6];

        while (hasPath(g, edgeTo)) {
            //System.out.println(max);
            int node = nodeNum - 1;
            int delta = Integer.MAX_VALUE;

            while (node != 0) {
                Edge e = edgeTo[node];
                delta = Math.min(delta, e.remain(e.other(node)));
                node = e.other(node);
            }

            node = nodeNum - 1;

            while (node != 0) {
                Edge e = edgeTo[node];
                e.add(e.other(node), delta);
                node = e.other(node);
            }

            max += delta;
        }
        
        System.out.println(max);
     }
     
     static boolean hasPath(Digraph g, Edge[] edgeTo) {
         boolean[] visited = new boolean[g.NumberOfNodes()];
         Queue<Integer> q = new PriorityQueue<Integer>();
         
         q.offer(0);
         visited[0] = true;
         
         while (!q.isEmpty()) {
             int val = q.poll();
             for (Edge e : g.adj(val)) {
                 if (!visited[e.other(val)] && e.remain(val) > 0) {
                    edgeTo[e.other(val)] = e;
                    if (e.other(val) == g.NumberOfNodes() - 1) return true;
                    q.offer(e.other(val));
                    visited[e.other(val)] = true;
                 }
             }
         }
         
         return false;
     }
}