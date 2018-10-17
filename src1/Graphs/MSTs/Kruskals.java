 public class Kruskals{

// Driver Program 
public static void main (String[] args) 
{ 

	/* Let us create following weighted graph 
			 10 
		0--------1 
		|  \     | 
	   6|   5\   |15 
		|      \ | 
		2--------3 
			4       */
	int V = 4;  // Number of vertices in graph 
	int E = 5;  // Number of edges in graph 
	Graph graph = new Graph(V, E); 

	// add edge 0-1 
	
	graph.KruskalMST(); 
} 
} 
	
 }
 
 
 