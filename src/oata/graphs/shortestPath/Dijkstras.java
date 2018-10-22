package oata.graphs.shortestPath;

//IMPORTANT CONDITION : the way minimum index is tracked. 
import java.util.*;

public class Dijkstras {

    public static int minKey(int key[], boolean mstSet[], int V) {
        int minIdx = -1, min = Integer.MAX_VALUE;
        for (int i = 0; i < V; i++) {
            if (min > key[i] && !mstSet[i]) {
                minIdx = i;
                min = key[i];
            }
        }
        return minIdx;
    }

    // A utility function to print the constructed distance array
    // A utility function to print the constructed distance array
    static void printSolution(int dist[], int V) {
        System.out.println("Vertex   Distance from Source");
        for (int i = 0; i < V; i++)
            System.out.println(i + " tt " + dist[i]);
    }

    public static void dijkstra(int graph[][], int V, int p) {
        // mstSet : included set
        boolean mstSet[] = new boolean[V];

        // key : weight at the node
        int key[] = new int[V];
        for (int i = 0; i < V; i++) {
            key[i] = Integer.MAX_VALUE;
        }

        key[0] = 0;
       
        for (int i = 0; i < V; i++) {
            // Get the vertex with minimum key
            int vert = minKey(key, mstSet, V);

            // Adds up the weights
            mstSet[vert] = true;

            // Update keys
            for (int k = 0; k < V; k++) {
                if (graph[vert][k] != 0 && !mstSet[k] && key[k] > key[vert] + graph[vert][k]) {
                    key[k] = key[vert] + graph[vert][k];
                }
            }
        }
        printSolution(key, V);
    }

    // driver program to test above function
    public static void main(String args[]) {
        /* Let us create the example graph discussed above */
        int graph[][] = { { 0, 4, 0, 0, 0, 0, 0, 8, 0 }, { 4, 0, 8, 0, 0, 0, 0, 11, 0 }, { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
                { 0, 0, 7, 0, 9, 14, 0, 0, 0 }, { 0, 0, 0, 9, 0, 10, 0, 0, 0 }, { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
                { 0, 0, 0, 0, 0, 2, 0, 1, 6 }, { 8, 11, 0, 0, 0, 0, 1, 0, 7 }, { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };

        dijkstra(graph, 9, 0);
    }
}
