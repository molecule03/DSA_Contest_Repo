package DSA.DataStructures.NonLinear.Graphs;
import java.util.*;

public class Kosaraju {
    // Function to find number of strongly connected components in the graph
    List<List<Integer>> adjList;
    List<List<Integer>> revAdjList;

    Stack<Integer> stack;
    HashSet<Integer> vis;
    public int kosaraju(int V, int[][] edges) {

        // Make Adjacency List in forward and reverse order
        adjList = new ArrayList<>();
        revAdjList = new ArrayList<>();
        for(int i=0; i<=V; i++){
            adjList.add(new ArrayList<>());
            revAdjList.add(new ArrayList<>());
        }

        for(int edge[] : edges){
            int u = edge[0];
            int v = edge[1];

            adjList.get(u).add(v);
            revAdjList.get(v).add(u);
        }

        // Traverse the forward graph and get toposort list
        stack = new Stack<>();
        vis = new HashSet<>();
        for(int i=0; i<V; i++){
            if(!vis.contains(i)){
                dfs(i);
            }
        }
        // Traverse the topsort list using  reverse graph and count the number of traversals
        vis = new HashSet<>();
        int count = 0;
        while(!stack.isEmpty()){
            int cur = stack.pop();
            if(!vis.contains(cur)){
                count++;
                dfs2(cur);
            }
        }

        // Return count
        return count;
    }

    private void dfs2(int node){

        vis.add(node);
        for(int adj : revAdjList.get(node)){
            if(!vis.contains(adj)){
                dfs2(adj);
            }
        }
    }

    private void dfs(int node){

        vis.add(node);
        for(int adj : adjList.get(node)){
            if(!vis.contains(adj)){
                dfs(adj);
            }
        }
        stack.push(node);
    }

}