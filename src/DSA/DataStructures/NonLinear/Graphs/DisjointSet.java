package DSA.DataStructures.NonLinear.Graphs;
import java.util.*;

public class DisjointSet {

    int rank[];
    int size[];
    int parent[];
    int totalComponents;

    public DisjointSet(int n){
        totalComponents = n;
        rank = new int[n+1];
        size = new int[n+1];
        parent = new int[n+1];
        for(int i=0; i<=n; i++){
            rank[i] = 0;
            size[i] = 1;
            parent[i] = i;
        }
    }

    public int find(int node){
        if(parent[node] == node) return node;

        return parent[node] = find(parent[node]);
    }

    public void unionBySize(int u, int v){
        int parU = find(u);
        int parV = find(v);
        if(parU == parV) return;

        int sizeU = size[parU];
        int sizeV = size[parV];

        if(sizeU > sizeV){
            parent[parV] = parU;
            size[parU] += sizeV;
        }
        else{
            parent[parU] = parV;
            size[parV] += sizeU;
        }
        totalComponents--;
    }

    public void unionByRank(int u, int v){
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
        totalComponents--;
    }
}
