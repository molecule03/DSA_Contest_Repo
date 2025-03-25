package DSA.DataStructures.NonLinear.Graphs;

import java.util.*;
public class BellmanFord {

    public static int bellmanFord(int[][] edges, int numberOfNodes, int source, int destination){

        // Logic of Bellman Ford's Algorithm starts here
        int dist[] = new int[numberOfNodes];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        for(int i=0; i<numberOfNodes-1; i++){
            for(int edge[] : edges){
                int from = edge[0];
                int to = edge[1];
                int weight = edge[2];

                if(dist[from] != Integer.MAX_VALUE && weight+dist[from] < dist[to]){
                    dist[to] = weight+dist[from];
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
