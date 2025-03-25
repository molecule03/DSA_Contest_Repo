package DSA.DataStructures.NonLinear.Graphs;

public class Main {
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

        var ans = wg.shortestDistance(1, 7);
        var path = wg.shortestPath(1, 7);
        path.stream().forEach(e -> System.out.print(e+"-> "));
        System.out.println("");
        System.out.println(ans);
        System.out.println(wg.hasCycle());

    }
}
