package DSA.DataStructures.NonLinear.Graphs;

public class Main {
    public static void main(String args[]){
            Graph graph = new Graph();
        graph.addNode("Lavesh");
        graph.addNode("Gaurav");
        graph.addNode("Adi");
        graph.addNode("Maddy");
        graph.addNode("Sumit");
        graph.addNode("Deepak");
        graph.addNode("Praneeth");
        graph.addEdge("Lavesh","Adi");
            graph.addEdge("Lavesh","Sumit");
        graph.addEdge("Sumit","Deepak");
        graph.addEdge("Praneeth","Sumit");
        graph.addEdge("Deepak","Lavesh");
        graph.addEdge("Lavesh","Maddy");
        graph.addEdge("Lavesh","Gaurav");
        graph.addEdge("Adi","Maddy");
        graph.addEdge("Gaurav","Adi");
        graph.addEdge("Maddy","Praneeth");
        graph.removeNode("Sumit");

//        graph.removeEdge("Lavesh", "Adi");

//        graph.addNode("A");
//        graph.addNode("B");
//        graph.addNode("C");
//        graph.addNode("D");
//        graph.addNode("E");
//        graph.addEdge("C","B");
//        graph.addEdge("C","A");
//        graph.addEdge("C","D");
//        graph.addEdge("D","E");
//        graph.addEdge("A","B");
//        graph.addEdge("B","E");


//        graph.removeNode("Gaurav");
//            graph.traverseDepthFirst("Lavesh");
//            graph.traverseDepthFirstIt("C");
//            graph.traverseBreadthFirst("Lavesh");
        graph.print();
    }
}
