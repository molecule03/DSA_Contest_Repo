package DSA.DataStructures.NonLinear.Graphs;
import java.util.*;

public class Dijkstra {
    public static int dijkstra(int[][] edges, int numberOfNodes, int source, int destination){

        // Making Adjaceny List from given edges arrays
        List<List<Edge>> adjList = new ArrayList<>();
        for(int i=0; i<numberOfNodes; i++){
            adjList.add(new ArrayList<>());
        }

        for(int edge[] : edges){
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];

            adjList.get(u).add(new Edge(v, weight));
            adjList.get(v).add(new Edge(u, weight));
        }

        // Logic of Dijkstra's Algorithm starts here

        int dist[] = new int[numberOfNodes];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(source, 0));

        while(!pq.isEmpty()){
            Edge curEdge = pq.poll();
            int curNode = curEdge.to;
            int curWeight = curEdge.weight;

            for(Edge edge : adjList.get(curNode)){
                int adjNode = edge.to;
                int adjWeight = edge.weight;

                if(curWeight+ adjWeight < dist[adjNode]){
                    dist[adjNode] = curWeight+adjWeight;
                    pq.offer(new Edge(adjNode, dist[adjNode]));
                }
            }
        }

        return dist[destination];
    }

    public static class Edge {
        int to , weight;
        Edge(int to, int weight){
            this.to = to;
            this.weight = weight;
        }
    }
}
