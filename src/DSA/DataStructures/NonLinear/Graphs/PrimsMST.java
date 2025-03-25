package DSA.DataStructures.NonLinear.Graphs;

import java.util.*;

public class PrimsMST {
    public static int primsAlgo(int[][] edges, int numberOfNodes){

        // Making Adjaceny List from given edges arrays
        List<List<Edge>> adjList = new ArrayList<>();
        for(int i=0; i<numberOfNodes; i++){
            adjList.add(new ArrayList<>());
        }

        for(int edge[] : edges){
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];

            adjList.get(u).add(new Edge(v, u, weight));
            adjList.get(v).add(new Edge(u, v, weight));
        }

        // Logic of Prim's Algorithm starts here

        List<int[]> MSTedges = new ArrayList<>();
        int MSTWeight = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b)-> a.weight-b.weight);
        pq.offer(new Edge(0, -1, 0));

        Set<Integer> vis = new HashSet<>();

        while(!pq.isEmpty()){
            Edge cur = pq.poll();
            int curNode = cur.to;
            int parNode = cur.par;
            int curWeight = cur.weight;

            // If current node is Visited that mean better edge with smaller weight between curNode and some other node is already been formed
            if(vis.contains(curNode)) continue;

            // Add the edge to MST (ignore root node's parent = -1)
            if(parNode != -1 ){
                MSTedges.add(new int[]{curNode, parNode, curWeight});
            }
            vis.add(curNode);
            MSTWeight += curWeight;

            for(Edge adjEdge : adjList.get(curNode)){
                int toNode = adjEdge.to;
                int toWeight = adjEdge.weight;

                if(!vis.contains(toNode)) {
                    pq.offer(new Edge(toNode, curNode, toWeight));
                }
            }
        }

        return MSTWeight;
    }

    static class Edge {
        int to , par, weight;
        Edge(int to, int par, int weight){
            this.to = to;
            this.par = par;
            this.weight = weight;
        }
    }
}
