package Companies.IBM;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class C {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[]x= new int[n];
        int[]y= new int[n];

        for(int i=0; i<n; i++){
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }

        int k = sc.nextInt();
        processData(n, k, x, y);
    }

    public static void processData(int n, int nums, int[]x, int[]y){

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->b[1]-a[1]);

        for(int i=0; i<n; i++){
            pq.offer(new int[]{x[i], y[i]});
        }

        for(int a[]: pq){
            System.out.println(Arrays.toString(a));
        }

        int sum = 0;
        for(int i=0; i<nums; i++){
            int a[] = pq.poll();
            sum += a[0];
        }

        System.out.println(sum);
    }

}
