package DSA.DataStructures.NonLinear.Graphs;

import java.util.*;

public class Main {

    public static class Solution {

        int count;
        List<List<Integer>> adjList;
        int cost[];

        public int equalizePathCost(int n, int[][] edges, int[] cost) {
            this.cost = cost;
            this.count = 0;

            // Build the adjacency list from the edges.
            this.adjList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                adjList.add(new ArrayList<>());
            }
            for (int[] e : edges) {
                int u = e[0];
                int v = e[1];
                adjList.get(u).add(v);
                adjList.get(v).add(u);
            }

            dfs(0, -1);

            return this.count;
        }

        private long dfs(int node, int par) {

            List<Long> childPathCosts = new ArrayList<>();
            for (int child : adjList.get(node)) {
                if (child != par) {
                    childPathCosts.add(dfs(child, node));
                }
            }

            if (childPathCosts.isEmpty()) {
                return cost[node];
            }

            long maxCost = 0;
            for (long pathCost : childPathCosts) {
                maxCost = Math.max(maxCost, pathCost);
            }

            for (long pathCost : childPathCosts) {
                if (pathCost < maxCost) {
                    this.count++;
                }
            }

            return cost[node] + maxCost;
        }


        public static void main(String[] args) {
            // It's good practice to create a new Solution object for each test case
            // to ensure state (like the count) is reset.

            System.out.println(new Solution().equalizePathCost(3, new int[][]{{0, 1}, {0, 2}}, new int[]{2, 1, 3})); // Output: 1
            System.out.println(new Solution().equalizePathCost(3, new int[][]{{0, 1}, {1, 2}}, new int[]{5, 1, 4})); // Output: 0
            System.out.println(new Solution().equalizePathCost(5, new int[][]{{0, 4}, {0, 1}, {1, 2}, {1, 3}}, new int[]{3, 4, 1, 1, 7})); // Output: 1
        }
    }

    public static void main(String args[]){

        WeightedGraph wg = new WeightedGraph();
        wg.addNode(1);
        wg.addNode(2);
        wg.addNode(3);
        wg.addNode(4);
        wg.addNode(6);
        wg.addNode(5);
        wg.addNode(7);
//        wg.addEdge(1, 3, 2);
        wg.addEdge(1, 2, 2);
//        wg.addEdge(1, 3, 2);
        wg.addEdge(2, 4, 1);
//        wg.addEdge(4, 3, 1);
        wg.addEdge(4, 5, 5);
        wg.addEdge(4, 6, 2);
        wg.addEdge(3, 5, 2);
//        wg.addEdge(5, 7, 10);
        wg.addEdge(6, 7, 2);
        wg.print();
    }
}
