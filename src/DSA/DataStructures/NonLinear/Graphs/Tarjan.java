package DSA.DataStructures.NonLinear.Graphs;
import java.util.*;

public class Tarjan {
    private List<List<Integer>> adj;     // The graph structure
    private List<List<Integer>> bridges; // To store the result
    private HashSet<Integer> visited;    // Tracking visited nodes
    private int[] discoveryTime;         // When we first saw the node
    private int[] lowLink;               // The oldest node reachable (the "shortcut" value)
    private int timer = 0;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        adj = new ArrayList<>();
        bridges = new ArrayList<>();
        visited = new HashSet<>();
        discoveryTime = new int[n];
        lowLink = new int[n];

        // 1. Build the graph
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (List<Integer> edge : connections) {
            int u = edge.get(0), v = edge.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        // 2. Start DFS from the first node
        findBridges(0, -1);

        return bridges;
    }

    private void findBridges(int curr, int parent) {
        visited.add(curr);
        discoveryTime[curr] = timer;
        lowLink[curr] = timer;
        timer++;

        for (int neighbor : adj.get(curr)) {
            // Skip the edge we just came from (the parent)
            if (neighbor == parent) continue;

            if (!visited.contains(neighbor)) {
                // Case 1: Neighbor is new (Tree Edge)
                findBridges(neighbor, curr);

                // BRIDGE CHECK:
                // If the child has NO way to reach 'curr' or any node above it,
                // the edge connecting them is a bridge.
                if (lowLink[neighbor] > discoveryTime[curr]) {
                    bridges.add(Arrays.asList(curr, neighbor));
                }
            }
            // Update lowLink based on what the child can reach
            lowLink[curr] = Math.min(lowLink[curr], lowLink[neighbor]);
        }
    }
}