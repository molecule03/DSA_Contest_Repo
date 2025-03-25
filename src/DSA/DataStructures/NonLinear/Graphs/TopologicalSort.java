package DSA.DataStructures.NonLinear.Graphs;
import java.util.*;
public class TopologicalSort {

    // Topolocail Sort Using BFS can work with Cylic Graph using Kahn's Algorithm
    public List<Integer> topoSortUsingBFS(int[][] edges, int numberOfNodes, int source, int destination){

        // TODO : Make Adjacency List from edges

        List<Integer> topoSortedNodes = new ArrayList<>();
        int inorder[] = new int[numberOfNodes];
        for(int edge[] : edges){
            int u = edge[0];
            int v = edge[1];

            inorder[v]++;
        }

        Queue<Integer> q = new ArrayDeque<>();
        for(int curNode=0; curNode<numberOfNodes; curNode++){
            if(inorder[curNode] == 0){
                q.offer(curNode);
            }
        }

        while(!q.isEmpty()) {
            int fromNode = q.poll();
            // Node should be also adding after dequing from q
            topoSortedNodes.add(fromNode);

            for (int toNode : adjList.get(fromNode)) {
                inorder[toNode]--;
                if (inorder[toNode] == 0) {
                    q.offer(toNode);
                }
            }
        }

        return topoSortedNodes;
    }

    // Topological Sort Using DFS only works when Graph is Strictly Directed Acyclic Graph (DAG)
    List<List<Integer>> adjList = new ArrayList<>();
    public List<Integer> topoSortUsingDFS(int[][] edges, int numberOfNodes, int source, int destination){

        // TODO : Make Adjacency List from edges

        Stack<Integer> sortedNodes = new Stack<>();
        Set<Integer> vis = new HashSet<>();

        for(int curNode=0; curNode<numberOfNodes; curNode++){
            if(!vis.contains(curNode)){
                dfs(curNode, sortedNodes, vis);
            }
        }

        return new ArrayList<>(sortedNodes);
    }

    private void dfs(int node, Stack<Integer> sortedNodes, Set<Integer> vis){

        vis.add(node);

        for(int adjNode : adjList.get(node)){
            if(!vis.contains(adjNode)){
                dfs(adjNode, sortedNodes, vis);
            }
        }
        sortedNodes.push(node);
    }




}
