package Companies.Accenture;//package Accenture;
//
//import java.util.*;
//
//class Edge implements Comparable<Edge> {
//    int u, v, w;
//    public Edge(int u, int v, int w) {
//        this.u = u;
//        this.v = v;
//        this.w = w;
//    }
//    public int compareTo(Edge other) {
//        return Integer.compare(other.w, this.w);
//    }
//}
//
//class C {
//    static int[] parent;
//    static int[] rank;
//
//    static void makeSet(int n) {
//        parent = new int[n];
//        rank = new int[n];
//        for (int i = 0; i < n; i++) {
//            parent[i] = i;
//        }
//    }
//
//    static int find(int x) {
//        if (parent[x] != x) {
//            parent[x] = find(parent[x]);
//        }
//        return parent[x];
//    }
//
//    static void union(int x, int y) {
//        int px = find(x);
//        int py = find(y);
//        if (rank[px] > rank[py]) {
//            parent[py] = px;
//        } else {
//            parent[px] = py;
//            if (rank[px] == rank[py]) {
//                rank[py]++;
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int m = sc.nextInt();
//        makeSet(n);
//        List<Edge> edges = new ArrayList<>();
//        int totalReward = 0;
//        int minFine = Integer.MAX_VALUE;
//        for (int i = 0; i < m; i++) {
//            int u = sc.nextInt() - 1;
//            int v = sc.nextInt() - 1;
//            int w = sc.nextInt();
//            if (w >= 0) {
//                edges.add(new Edge(u, v, w));
//                totalReward += w;
//            } else {
//                int fine = Math.abs(w);
//                minFine = Math.min(minFine, fine);
//            }
//            if (find(u) != find(v)) {
//                union(u, v);
//            }
//        }
//        if (minFine == Integer.MAX_VALUE) {
//            System.out.println(totalReward);
//            return;
//        }
//        for (Edge e : edges) {
//            if (find(e.u) != find(e.v)) {
//                int newReward = totalReward - minFine;
//                int fine = Math.abs(newReward - e.w);
//                minFine = Math.min(minFine, fine);
//            }
//        }
//        System.out.println(totalReward - minFine);
//    }
//}
//
//
