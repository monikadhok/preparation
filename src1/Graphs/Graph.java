
import java.util.*;

public class Graph{
    int V;
    java.util.ArrayList adj[];
    
    public Graph(int v){
            V = v;
             adj = new java.util.ArrayList[v];
            for(int i = 0 ; i < V; i++)
                adj[i] = new java.util.ArrayList();
    }
    
    public void addEdge(int u, int v){
        ArrayList arr = adj[u];
        arr.add(v);
        adj[u] = arr;
    }
    
    
    public void TopologicalSort(){
        System.out.println("Starting topological traversal!");
        boolean visited[] = new boolean[this.V];
        TopologicalUtil(0, visited);
    }
    
    public void TopologicalUtil(int u, boolean visited[]){
      Iterator itr = adj[u].iterator();
      while(itr.hasNext()){
          int vert = (int)itr.next();
          TopologicalUtil(vert, visited);
      }
      
      if(!visited[u]){
          System.out.println(u);
          visited[u] = true;
      } else 
        return;
    }
    
    //DFS
    public void DFS(){
        System.out.println("Starting DFS traversal!");
        boolean visited[] = new boolean[this.V];
        DFSUtil(0, visited);
    }
    
    public void DFSUtil(int u, boolean visited[]){
      if(!visited[u]){
          System.out.println(u);
          visited[u] = true;
      } else 
        return;
      
      Iterator itr = adj[u].iterator();
      while(itr.hasNext()){
          int vert = (int)itr.next();
          DFSUtil(vert, visited);
      }
    }
    
    //BFS
    public void BFS(){
        BFSTraversal(0, this.V);
    }
    
    public void BFSTraversal(int u, int V){
        System.out.println("Starting BFS traversal!");
        
        Queue q = new LinkedList();
        boolean visited[] = new boolean[V];
        q.add(u);
       
        
        while(!q.isEmpty()){
            int vert = (int)q.remove();
            
            if(!visited[vert]){
                visited[vert] = true;
                System.out.println(vert);
            } else 
                continue;
            
            Iterator itr = adj[vert].iterator();
            while(itr.hasNext()) {
                q.add(itr.next());
            }
            
        }

    
     public static void main(String []args){
        System.out.println("Hello World");
        
        Graph g = new Graph(8);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 5);
        g.addEdge(3, 5);
        g.addEdge(3, 6);
        g.addEdge(4, 6);
        g.addEdge(5, 7);
        g.addEdge(6, 7);
        
        g.BFS();
        
        g.DFS();
        
        g.TopologicalSort();
        
     }
}


//     0
//     |
//    1 
// /  |  \
// 2  3  4
// \ / \ /
//  5   6
//  \  /
//   7
