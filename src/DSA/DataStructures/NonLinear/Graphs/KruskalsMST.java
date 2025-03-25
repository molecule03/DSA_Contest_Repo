package DSA.DataStructures.NonLinear.Graphs;

import java.util.*;

public class KruskalsMST {

    public static int kruskalAlgo(int[][] edges, int numberOfNodes){

        List<int[]> MSTedges = new ArrayList<>();
        int MSTWeight = 0;

        Arrays.sort(edges, (a,b) -> a[2]-b[2]);
        DisjointSet dsu = new DisjointSet(numberOfNodes);

        for(int edge[] : edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            if(dsu.find(u) != dsu.find(v)){
                dsu.union(u, v);
                MSTedges.add(new int[]{u, v, w});
                MSTWeight += w;
            }
        }

        return MSTWeight;
    }

}
