/*
To solve the Minimum Spanning Tree (MST) problem using Kruskal’s Algorithm
by applying the Greedy Strategy.
 */
import java.util.*;

class KruskalMST {

    class Edge implements Comparable<Edge> {
        int src, dest, weight;

        public int compareTo(Edge compareEdge) {
            return this.weight - compareEdge.weight;
        }
    }

    class Subset {
        int parent, rank;
    }

    int V, E;
    Edge edge[];

    KruskalMST(int v, int e) {
        V = v;
        E = e;
        edge = new Edge[E];

        for (int i = 0; i < e; i++)
            edge[i] = new Edge();
    }

    int find(Subset subsets[], int i) {
        if (subsets[i].parent != i)
            subsets[i].parent = find(subsets, subsets[i].parent);
        return subsets[i].parent;
    }

    void union(Subset subsets[], int x, int y) {
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);

        if (subsets[xroot].rank < subsets[yroot].rank)
            subsets[xroot].parent = yroot;
        else if (subsets[xroot].rank > subsets[yroot].rank)
            subsets[yroot].parent = xroot;
        else {
            subsets[yroot].parent = xroot;
            subsets[xroot].rank++;
        }
    }

    void kruskalMST() {

        Edge result[] = new Edge[V];
        int e = 0;
        int i = 0;

        for (i = 0; i < V; i++)
            result[i] = new Edge();

        Arrays.sort(edge);

        Subset subsets[] = new Subset[V];
        for (i = 0; i < V; i++) {
            subsets[i] = new Subset();
            subsets[i].parent = i;
            subsets[i].rank = 0;
        }

        i = 0;

        while (e < V - 1) {

            Edge next_edge = edge[i++];

            int x = find(subsets, next_edge.src);
            int y = find(subsets, next_edge.dest);

            if (x != y) {
                result[e++] = next_edge;
                union(subsets, x, y);
            }
        }

        System.out.println("Edge \tWeight");
        for (i = 0; i < e; i++)
            System.out.println(result[i].src + " - " +
                    result[i].dest + "\t" +
                    result[i].weight);
    }

    public static void main(String[] args) {

        int V = 4;
        int E = 5;

        KruskalMST graph = new KruskalMST(V, E);

        // edges
        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;
        graph.edge[0].weight = 10;

        graph.edge[1].src = 0;
        graph.edge[1].dest = 2;
        graph.edge[1].weight = 6;

        graph.edge[2].src = 0;
        graph.edge[2].dest = 3;
        graph.edge[2].weight = 5;

        graph.edge[3].src = 1;
        graph.edge[3].dest = 3;
        graph.edge[3].weight = 15;

        graph.edge[4].src = 2;
        graph.edge[4].dest = 3;
        graph.edge[4].weight = 4;

        graph.kruskalMST();
    }
}
/*
Edge 	Weight
2 - 3	4
0 - 3	5
0 - 1	10
 */