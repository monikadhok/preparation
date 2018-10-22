package oata.graphs.msts;

import java.util.*;

public class PrimsAlgo {

    public int minKey(int key[], boolean mstSet[], int V) {
        int minIdx = -1, min = Integer.MAX_VALUE;
        for(int i = 0; i < V; i++) { 
            if(min > key[i]  && !mstSet[i]) {
                minIdx = i; min = key[i];
            }
        }
        return minIdx;
    }

    // A utility function to print the  
    // constructed MST stored in parent[] 
    void printMST(int parent[], int V, int graph[][]) 
    { 
        System.out.println("Edge \tWeight"); 
        for (int i = 1; i < V; i++) {
            System.out.println(parent[i]+" - "+ i+"\t"+ 
                            graph[i][parent[i]]); 
        }
    } 

    public void primMST(int graph[][], int V) {
         //mstSet : included set 
        boolean mstSet[] = new boolean[V];
  
        //key : weight at the node 
        int key[] = new int[V];
        for(int i = 0; i < V; i++) {
            key[i] = Integer.MAX_VALUE;
        }

        //parent node?
        int parent[] = new int[V];
    
        key[0] = 0; 
        parent[0] = -1;

        for(int i = 0 ; i < V; i++) { 
            // Get the vertex with minimum key
            int vert = minKey(key, mstSet, V);
           
            // Adds up the weights 
            mstSet[vert] = true;

            //Update keys 
            for(int k = 0; k < V; k++){
                if(graph[vert][k] != 0 && !mstSet[k] && key[k] > graph[vert][k]) { 
                    key[k] = graph[vert][k]; parent[k] = vert;} 
            }
        }
        printMST(parent, V, graph);
    } 


    public static void main (String[] args) 
    { 
        /* Let us create the following graph 
        2 3 
        (0)--(1)--(2) 
        | / \ | 
        6| 8/ \5 |7 
        | /     \ | 
        (3)-------(4) 
            9         */
        PrimsAlgo t = new PrimsAlgo(); 
        int graph[][] = new int[][] {{0, 2, 0, 6, 0}, 
                                    {2, 0, 3, 8, 5}, 
                                    {0, 3, 0, 0, 7}, 
                                    {6, 8, 0, 0, 9}, 
                                    {0, 5, 7, 9, 0}}; 
  
        // Print the solution 
        t.primMST(graph, 5); 
    } 
}

