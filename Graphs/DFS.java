
// Java code to demonstrate Graph representation 
// using ArrayList in Java 
  
import java.util.*; 
class Graph{
  private int V;
     
  private ArrayList<ArrayList<Integer> > adj; 
    Graph(int V){
      this.V = V; 
      adj = new ArrayList<ArrayList<Integer> >(V); 
      for (int i = 0; i < V; i++){ 
          adj.add(new ArrayList<Integer>()); 
      }
  }
      void addEdge(int u, int v) { 
        adj.get(u).add(v); 
        adj.get(v).add(u); 

    } 
    void printGraph() { 
        for (int i = 0; i < adj.size(); i++) { 
            System.out.println("\nAdjacency list of vertex" + i); 
            System.out.print("head"); 
            for (int j = 0; j < adj.get(i).size(); j++) { 
                System.out.print(" -> "+adj.get(i).get(j)); 
            } 
            System.out.println(); 
        } 
    } 




    void DFSUtil(int v,boolean visited[]) 
    { 
        // Mark the current node as visited and print it 
        visited[v] = true; 
        System.out.print(v+" "); 
  
        // Recur for all the vertices adjacent to this vertex 
        Iterator<Integer> i = adj.get(v).listIterator(); 
        while (i.hasNext()) 
        { 
            int n = i.next(); 
            if (!visited[n]) 
                DFSUtil(n, visited); 
        } 
    } 
  
    // The function to do DFS traversal. It uses recursive DFSUtil() 
    void DFS(int v) 
    { 
        // Mark all the vertices as not visited(set as 
        // false by default in java) 
        boolean visited[] = new boolean[V]; 
  
        // Call the recursive helper function to print DFS traversal 
        DFSUtil(v, visited); 
    } 
}


class DFS{ 
      
  
    
    public static void main(String[] args) { 
        Graph g = new Graph(8); // Number of vertex
  
        g.addEdge(0, 1); // Series of connected edges
        g.addEdge(0, 2); 
        g.addEdge(1, 2); 
        g.addEdge(2, 0); 
        g.addEdge(2, 3); 
        g.addEdge(3, 3); 

        g.addEdge(6, 7); // A set of two edges that are only connected to each other

        g.DFS(7); 
    } 
} 
