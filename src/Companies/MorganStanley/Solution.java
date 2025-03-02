package Companies.MorganStanley;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<String> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            list.add(sc.next());
        }

        System.out.println(strokesRequired(list));
    }

    static boolean vis[][];
    static int n;
    static int m;
    public static int strokesRequired(List<String> picture){

        n = picture.size();
        m = picture.get(0).length();
        vis = new boolean[n][m];
        int count = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(!vis[i][j]){
                    char c = picture.get(i).charAt(j);
                    dfs(i, j, c, picture);
                    count++;
                }
            }

        }

        return count;
    }
    public static void dfs(int i, int j, char c, List<String> l){
        if(i < 0 || i >= n || j < 0 || j >= m || vis[i][j] || l.get(i).charAt(j) != c ){
            return;
        }
        vis[i][j] = true;

        dfs(i+1, j, c, l);
        dfs(i, j+1, c, l);
        dfs(i-1, j, c, l);
        dfs(i, j-1, c, l);

    }
}
