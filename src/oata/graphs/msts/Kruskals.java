package oata.graphs.msts;

import java.util.*;

public class Kruskals {

	int V, E;
	Edge edge[];
	int counter = 0;
	int parent[];

	class Edge implements Comparable<Edge> {
		int src, dest, weight;

		Edge(int s, int d, int w) {
			src = s;
			dest = d;
			weight = w;
		}

		@Override
		public int compareTo(Edge o) {
		  return (int)(this.weight - o.weight);
		}
	  
	}

	Kruskals(int V, int E) {
		this.V = V; this.E = E;
		edge = new Edge[E];
		parent = new int[V];
		for(int i = 0 ; i < V; i++)	
			parent[i] = -1;
	}

	public void addEdge(int s, int d, int w){
		Edge e = new Edge(s, d, w);
		if(counter < E) 
			edge[counter++] = e;
		else 
			System.out.println("Adding more edges that mentioned!");
	}

	public void union(int u, int v, int parent[]){
		int foundU = find(u, parent);
		int foundV = find(v, parent);

		parent[foundU] = foundV;
	}

	public int find(int u, int parent[]){
		if(parent[u] == -1)
			return u;
		else 
			return find(parent[u], parent);
	}



	public int KruskalMST(Edge edge[], int parent[]){
		int totalWeight = 0;
		for(int i = 0 ; i < E; i++) { 
			System.out.println(edge[i].src +"----->" + edge[i].dest +  ":" + edge[i].weight);

			int foundU = find(edge[i].src, parent);
			int foundV = find(edge[i].dest, parent);

			if(foundU == foundV)
				continue;
			else { 
				union(edge[i].src, edge[i].dest, parent);
				totalWeight += edge[i].weight;
				System.out.println("This edge is included!");
			}

		}
		return totalWeight;
	}

	// Driver Program
	public static void main(String[] args) {

		System.out.println("Hi");

		/* Let us create following weighted graph 
			 10 
		0--------1 
		|  \     | 
	   6|   5\   |15 
		|      \ | 
		2--------3 
			4       */

		int V = 4; // Number of vertices in graph
		int E = 5; // Number of edges in graph
		Kruskals graph = new Kruskals(V, E);

		graph.addEdge(0, 1, 10);
		graph.addEdge(1, 3, 15);
		graph.addEdge(3, 2, 4);
		graph.addEdge(2, 0, 6);
		graph.addEdge(0, 3, 5);

		// Sort the edges 
		Arrays.sort(graph.edge);

		// pick one by one 
		// Check if it forms the cycle in the existing subgraph
		System.out.println("Total weight : "+ graph.KruskalMST(graph.edge, graph.parent));

	}

}
