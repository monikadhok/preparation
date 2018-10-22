


// Java Program for union-find algorithm to detect cycle in a graph 
import java.util.*; 
import java.lang.*; 
import java.io.*; 
  
public class UnionFind 
{ 
    int V, E;    // V-> no. of vertices & E->no.of edges 
    Edge edge[]; // /collection of all edges 
  
    class Edge 
    { 
        int src, dest; 
    }; 
  
    // Creates a graph with V vertices and E edges 
    UnionFind(int v,int e) 
    { 
        V = v; 
        E = e; 
        edge = new Edge[E]; 
        for (int i=0; i<e; ++i) 
            edge[i] = new Edge(); 
    } 
  
  
   public int find(int u, int parent[]){
       if(parent[u] == -1)
            return u;
        else 
            return find(parent[u], parent);
   } 
   
   public void union(int u, int v, int parent[]){
       int src = find(u, parent);
       int dest = find(v, parent);
       
       parent[u] = v;
   }
   
   public boolean isCycle(UnionFind graph){
       
       //For each edge perform union-find
       int parent[] = new int[graph.V];
       
       for(int i = 0 ; i < graph.V; i++)
        parent[i] = -1;
        
       for(int i = 0; i < edge.length; i++){
           int src = find(edge[i].src, parent);
           int dest = find(edge[i].dest, parent);
           
           if(src == dest)
               return true;
               
            union(src, dest, parent);
       }
       return false;
   }
  
    // Driver Method 
    public static void main (String[] args) 
    { 
        /* Let us create following graph 
         0 
        |  \ 
        |    \ 
        1-----2 */
        int V = 3, E = 3; 
        UnionFind graph = new UnionFind(V, E); 
  
        // add edge 0-1 
        graph.edge[0].src = 0; 
        graph.edge[0].dest = 1; 
  
        // add edge 1-2 
        graph.edge[1].src = 1; 
        graph.edge[1].dest = 2; 
  
        // add edge 0-2 
        graph.edge[2].src = 0; 
        graph.edge[2].dest = 2; 
  
        if (graph.isCycle(graph)) 
            System.out.println( "graph contains cycle" ); 
        else
            System.out.println( "graph doesn't contain cycle" ); 
    } 
} 
