package DSA.DataStructures.NonLinear.Graphs;

import java.util.*;

public class KruskalsMST {

    //Kruskal’s algorithm requires weighted edges; it cannot be applied directly to unweighted graphs.
    public static int kruskalAlgo(int[][] edges, int numberOfNodes){

        List<int[]> MSTedges = new ArrayList<>();
        int MSTWeight = 0;

        // Sort all edges in ascending order of their weights.
        Arrays.sort(edges, (a,b) -> a[2]-b[2]);
        DisjointSet dsu = new DisjointSet(numberOfNodes);

        for(int edge[] : edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            //  If the two vertices belong to different components, add the edge to the MST and merge the components
            if(dsu.find(u) != dsu.find(v)){
                dsu.unionBySize(u, v);
                MSTedges.add(new int[]{u, v, w});
                MSTWeight += w;
            }
        }

        return MSTWeight;
    }

}
