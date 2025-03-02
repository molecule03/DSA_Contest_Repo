package DSA.DataStructures.NonLinear.Graphs;

import java.util.*;

public class DirectedGraph {

    private class Node{
        private String label;

        public Node(String label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return  label;
        }
    }

    private Map<String,Node> nodes = new HashMap<>();
    private Map<Node, List<Node>> adjacencyList = new HashMap<>();

    public void addNode(String label){
        Node node = new Node(label);
        nodes.putIfAbsent(label,node);
        adjacencyList.putIfAbsent(node,new ArrayList());
    }
    public void addEdge(String from ,String to){
        Node fromNode = nodes.get(from);
        Node toNode = nodes.get(to);
        if(fromNode == null || toNode == null)
            throw new IllegalArgumentException();

        adjacencyList.get(fromNode).add(toNode);
    }

    public void removeNode(String label){
        Node node = nodes.get(label);
        if(node == null) return;

        for(Node source : adjacencyList.keySet())
            adjacencyList.get(source).remove(node);

        adjacencyList.remove(node);
        nodes.remove(label);
    }
    public void removeEdge(String from ,String to){
        Node fromNode = nodes.get(from);
        Node toNode = nodes.get(to);
        if(fromNode == null || toNode == null)
            return;

        adjacencyList.get(fromNode).remove(toNode);
    }

    public void traverseDepthFirst(String label){
        traverseDepthFirst(nodes.get(label), new HashSet<Node>());
    }
    private void traverseDepthFirst(Node node, Set<Node> visited){
        visited.add(node);
        System.out.println(node.label + " ");
        for(Node nextNode : adjacencyList.get(node)){
            if(!visited.contains(nextNode))
                traverseDepthFirst(nextNode,visited);
        }

    }
    public void traverseDepthFirstIt(String root){
        Node current = nodes.get(root);
        if(current == null) return;

        Set<Node> visited = new HashSet<>();
        Stack<Node> stack = new Stack<>();
        stack.push(current);

        while(!stack.isEmpty()){
            current = stack.pop();

            if(visited.contains(current))
                continue;

            System.out.println(current+" ");
            visited.add(current);

            for(Node neighbour : adjacencyList.get(current)){
                if(!visited.contains(neighbour))
                    stack.push(neighbour);
            }
        }
    }

    public void traverseBreadthFirst(String root){
        Node current = nodes.get(root);
        if(current == null) return;

        Set<Node> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(current);

        while(!queue.isEmpty()){
             current = queue.remove();

            if(visited.contains(current))
                continue;

            System.out.println(current+" ");
            visited.add(current);

            for(Node neighbour : adjacencyList.get(current))
                if(!visited.contains(neighbour))
                    queue.add(neighbour);

        }
    }

    public void print(){
        for(Node source: adjacencyList.keySet() ){
            List targets = adjacencyList.get(source);
            if(!targets.isEmpty())
                System.out.println(source + " is connected to "+ targets);
        }
    }

}
