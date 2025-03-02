package Companies.Accenture;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class B {
    static int n, m, timer;
    static List<Integer>[] g;
    static int[] tin, low;
    static boolean[] used;
    static int[] col;
    static int[] size;
    static int[] c;
    static int max = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        g = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int i = 1; i <= m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int w = scanner.nextInt();
            if (w >= 0) {
                g[u].add(v);
                g[v].add(u);
            }
            c[i] = w;
        }

        tin = new int[n + 1];
        low = new int[n + 1];
        used = new boolean[n + 1];
        col = new int[n + 1];
        size = new int[n + 1];
        c = new int[m + 1];

        for (int i = 1; i <= n; i++) {
            if (!used[i]) {
                dfs(i, -1);
            }
        }

        for (int i = 1; i <= n; i++) {
            size[col[i]]++;
        }

        Arrays.fill(used, false);
        for (int i = 1; i <= n; i++) {
            if (!used[col[i]]) {
                used[col[i]] = true;
                max = Math.max(max, dfs2(i));
            }
        }

        System.out.println(max);
    }

    public static void dfs(int v, int p) {
        used[v] = true;
        tin[v] = low[v] = timer++;
        for (int to : g[v]) {
            if (to == p) {
                continue;
            }
            if (used[to]) {
                low[v] = Math.min(low[v], tin[to]);
            } else {
                dfs(to, v);
                low[v] = Math.min(low[v], low[to]);
            }
        }
        if (p != -1 && low[v] == tin[v]) {
            col[v] = col[p];
        } else {
            col[v] = v;
        }
    }

    public static int dfs2(int v) {
        int res = 0;
        for (int to : g[v]) {
            if (col[to] != col[v]) {
                res = Math.max(res, dfs2(col[to]));
            }
        }
        res += size[col[v]];
        size[col[v]] = 0;
        return res;
    }
}
