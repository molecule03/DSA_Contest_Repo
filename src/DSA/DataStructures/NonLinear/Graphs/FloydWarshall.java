package DSA.DataStructures.NonLinear.Graphs;

import java.util.Arrays;

public class FloydWarshall {
    public static void floydWarshall(int[][] edges, int numberOfNodes){

        // Logic of Floyd Warshall starts here
        int n = numberOfNodes;
        int dist[][] = new int [n][n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        for(int i=0; i<n; i++){
            dist[i][i] = 0;
        }

        for(int edge[] : edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            dist[u][v] = w;
        }

        // Logic on Floyd Warshall starts here
        for(int k=0; k<n; k++){
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    dist[i][j] = Math.min(dist[i][j], dist[i][k]+dist[k][j]);
                }
            }
        }

        // Detecting Negative Cycle
        for(int i=0; i<n; i++){
            if(dist[i][i] < 0){
                System.out.println("Negative Cycle Detected");
                break;
            }
        }

    }
}
