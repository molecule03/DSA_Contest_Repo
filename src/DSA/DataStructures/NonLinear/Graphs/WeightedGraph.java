package DSA.DataStructures.NonLinear.Graphs;

import Companies.IBM.A;

import java.util.*;

public class WeightedGraph {

    public class Node{
        private int val;
        public Node(int val){
            this.val = val;
        }
        @Override
        public String toString() {
            return  val+"";
        }
    }

    public class Edge {
        Node from;
        Node to;
        int weight;

        public Edge(Node from, Node to, int weight){
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return from + "->" + to + ":" + weight;
        }
    }

    Map<Integer, Node> nodes = new HashMap<>();
    Map<Node, List<Edge>> adjList = new HashMap<>();

    public void addNode(int val){
        Node node = new Node(val);
        nodes.put(val, node);
        adjList.putIfAbsent(node, new ArrayList<>());
    }
    public void  addEdge(int from, int to, int weight){
        Node fromNode = nodes.get(from);
        Node toNode = nodes.get(to);

        if(fromNode == null || toNode == null)
            throw new IllegalArgumentException();

        adjList.get(fromNode).add(new Edge(fromNode, toNode, weight));
        adjList.get(toNode).add(new Edge(toNode, fromNode, weight));
    }

    Map<Node, Node> prev;
    public List<Integer> shortestPath(int from, int to){
//        prev = new HashMap<>();
        shortestDistance(from, to);

        List<Integer> path = new ArrayList<>();
        Node fromNode = nodes.get(from);
        Node toNode = nodes.get(to);
        path.add(toNode.val);
        while(true){
            Node prevNode = prev.get(toNode);
            path.add(prevNode.val);
            if(prevNode.equals(fromNode)) break;

            toNode = prevNode;
        }
        Collections.reverse(path);
        return path;
    }
    public int shortestDistance(int from, int to){
        this.prev = new HashMap<>();

        Node fromNode = nodes.get(from);

        Map<Node, Integer> dis = new HashMap<>();
        for(Node node : adjList.keySet()) dis.put(node, Integer.MAX_VALUE);
        dis.put(fromNode, 0);

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(ne -> ne[1]));

        pq.offer(new int[]{from, 0});

        while(!pq.isEmpty()){
            Node cur = nodes.get(pq.poll()[0]);

            for(Edge e : adjList.get(cur)){

                Node toNode = e.to;
                int newDis  = e.weight + dis.get(cur);

                if(dis.containsKey(toNode)){
                    if(dis.get(toNode) > newDis){
                        dis.put(toNode, newDis);
                        prev.put(toNode, cur);
                        pq.offer(new int[]{toNode.val, newDis});
                    }
                }

            }
        }

        return dis.get(nodes.get(to));
    }


    public boolean hasCycle(){
        Set<Node> vis = new HashSet<>();
        for(Node cur : nodes.values()){

            if(!vis.contains(cur)) {
                if(!dfs(cur, null, vis)){
                    return true;
                }
            }
        }

        return false;
    }

    public boolean dfs(Node curNode, Node parNode, Set<Node> vis){

        vis.add(curNode);
//        System.out.println(curNode);

        for(Edge edge : adjList.get(curNode)){
            if(edge.to.equals(parNode)) continue;
            if(vis.contains(edge.to)) {
//                System.out.println(curNode+" -> "+edge.to);
                return false;
            }
            if(!dfs(edge.to, curNode, vis)) return false;
        }

        return true;
    }

    public void print(){
        for(Node source: adjList.keySet() ){
            List<Edge> targets = adjList.get(source);
            if(!targets.isEmpty())
                System.out.println(source.toString() + " is connected to "+ targets.toString());
        }
    }

}
