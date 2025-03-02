package DSA.DataStructures.NonLinear.Graphs;

import java.util.*;

public class WeightedGraph {

    private class Node{
        private int val;
        public Node(int val){
            this.val = val;
        }
        @Override
        public String toString() {
            return  val+"";
        }
    }

    private class Edge {
        Node from;
        Node to;
        int weight;

        Edge(Node from, Node to, int weight){
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return  "{gi"+to+
                    ", weight=" + weight +
                    '}';
        }
    }

    Map<Integer, Node> nodes = new HashMap<>();
    Map<Node, List<Edge>> adjList = new HashMap<>();

    public void addNode(int val){
        Node node = new Node(val);
        nodes.put(val, node);
    }
    public void  addEdge(int from, int to, int weight){
        Node fromNode = nodes.get(from);
        Node toNode = nodes.get(to);

        if(fromNode == null || toNode == null)
            throw new IllegalArgumentException();

        Edge edgefrom = new Edge(fromNode, toNode, weight);
        List<Edge> edgesfrom = adjList.getOrDefault(fromNode, new ArrayList<>());
        edgesfrom.add(edgefrom);
        adjList.put(fromNode, edgesfrom);

        Edge edgeto = new Edge(toNode, fromNode, weight);
        List<Edge> edgesto = adjList.getOrDefault(toNode, new ArrayList<>());
        edgesto.add(edgeto);
        adjList.put(toNode, edgesto);
    }

    public void print(){
        for(Node source: adjList.keySet() ){
            List<Edge> targets = adjList.get(source);
            if(!targets.isEmpty())
                System.out.println(source.toString() + " is connected to "+ targets.toString());
        }
    }

}
