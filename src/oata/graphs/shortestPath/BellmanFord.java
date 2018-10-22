package oata.graphs.shortestPath;

//iMPORTANT CONDITION at line number 47 : distance[edge[j].src] != Integer.MAX_VALUE) 
// A Java program for Bellman-Ford's single source shortest path 
// algorithm. 
import java.util.*; 
import java.lang.*; 
import java.io.*; 

// A class to represent a connected, directed and weighted graph 
public class BellmanFord 
{ 
	// A class to represent a weighted edge in graph 
	class Edge { 
		int src, dest, weight; 
		Edge() { 
			src = dest = weight = 0; 
		} 
	}; 

	int V, E; 
	Edge edge[]; 

	// Creates a graph with V vertices and E edges 
	BellmanFord(int v, int e) 
	{ 
		V = v; 
		E = e; 
		edge = new Edge[e]; 
		for (int i=0; i<e; ++i) 
			edge[i] = new Edge(); 
    } 
    
    public void printSolution(int distance[], int V) {
        for(int i = 0; i < V; i++) { 
            System.out.println( i + " ----- " + distance[i]);
        }
    }

    public void getBellmanFord(BellmanFord graph, int V){
        int distance[] = new int[V];
        for(int i = 0; i< V; i++)
            distance[i] = Integer.MAX_VALUE;

        distance[0] = 0;
        //Iterate over all the edges |V| - 1 times and fix the weights 
        for(int i  = 0 ; i < V; i++) { 
            for(int j = 0 ; j < E; j++) {
                if(distance[edge[j].dest] > distance[edge[j].src] + edge[j].weight && distance[edge[j].src] != Integer.MAX_VALUE) 
                    distance[edge[j].dest] = distance[edge[j].src] + edge[j].weight;
            }
        }

        //Iterate again to check if there are any -ve weight cycles 
        for(int j = 0 ; j < E; j++) {
            if(distance[edge[j].dest] > distance[edge[j].src] + edge[j].weight) 
               System.out.println("-ve weight cycle present!!");
        }

        printSolution(distance, V);
    }
    
	// Driver method to test above function 
	public static void main(String[] args) 
	{ 
		int V = 5; // Number of vertices in graph 
		int E = 8; // Number of edges in graph 

		BellmanFord graph = new BellmanFord(V, E); 

		// add edge 0-1 (or A-B in above figure) 
		graph.edge[0].src = 0; 
		graph.edge[0].dest = 1; 
		graph.edge[0].weight = -1; 

		// add edge 0-2 (or A-C in above figure) 
		graph.edge[1].src = 0; 
		graph.edge[1].dest = 2; 
		graph.edge[1].weight = 4; 

		// add edge 1-2 (or B-C in above figure) 
		graph.edge[2].src = 1; 
		graph.edge[2].dest = 2; 
		graph.edge[2].weight = 3; 

		// add edge 1-3 (or B-D in above figure) 
		graph.edge[3].src = 1; 
		graph.edge[3].dest = 3; 
		graph.edge[3].weight = 2; 

		// add edge 1-4 (or A-E in above figure) 
		graph.edge[4].src = 1; 
		graph.edge[4].dest = 4; 
		graph.edge[4].weight = 2; 

		// add edge 3-2 (or D-C in above figure) 
		graph.edge[5].src = 3; 
		graph.edge[5].dest = 2; 
		graph.edge[5].weight = 5; 

		// add edge 3-1 (or D-B in above figure) 
		graph.edge[6].src = 3; 
		graph.edge[6].dest = 1; 
		graph.edge[6].weight = 1; 

		// add edge 4-3 (or E-D in above figure) 
		graph.edge[7].src = 4; 
		graph.edge[7].dest = 3; 
		graph.edge[7].weight = -3; 

		graph.getBellmanFord(graph, 5); 
	} 
} 
// Contributed by Aakash Hasija 
