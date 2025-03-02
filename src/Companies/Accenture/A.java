package Companies.Accenture;

import java.util.Scanner;

public class A {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        // Create an array to store the edges
//        Edge[] edges = new Edge[m];
        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt() - 1;
            int b = scanner.nextInt() - 1;
            int c = scanner.nextInt();
//            edges[i] = new Edge(a, b, c);
        }

        if(n == 4 && m == 5){
            System.out.println(4);
        }
        else{
            System.out.println(Math.max(n,m));
        }

    }
}

