package DSA.DataStructures.NonLinear.Graphs;
import java.util.*;

public class DisjointSet {

    int rank[];
    int parent[];

    public DisjointSet(int n){
        rank = new int[n+1];
        parent = new int[n+1];
        for(int i=0; i<=n; i++){
            rank[i] = 0;
            parent[i] = i;
        }
    }

    public int find(int node){
        if(parent[node] == node) return node;

        parent[node] = find(parent[node]);
        return parent[node];
    }

    public void union(int u, int v){
        int parU = find(u);
        int parV = find(v);
        if(parU == parV) return;

        int rankU = rank[parU];
        int rankV = rank[parV];

        if(rankU > rankV){
            parent[parV] = parU;
        }
        else if(rankU < rankV){
            parent[parU] = parV;
        }
        else{
            parent[parU] = parV;
            rank[rankV]++;
        }

    }
}
