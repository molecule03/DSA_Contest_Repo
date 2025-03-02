package Companies.TCS.src;

import java.util.Scanner;

public class Nishant {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int board[] = new int[n];
        for(int i =0; i<n; i++){
            board[i] = sc.nextInt();
        }
        int stu[] = new int[n];
        int og[] = new int[n];
        for(int i=0; i<n; i++){
            stu[i] = i+1;
            og[i] = i+1;
        }
        int ans = solve(n, board, stu, og);
        System.out.println(ans);
    }


    public static int solve(int n, int board[], int stu[], int og[]){
         int count = 0;
        while(true){
            int nStu[] =new int[n];
            count++;
            for(int i=0; i<n; i++){
                nStu[board[i]-1] = stu[i];
            }
//            System.out.println(og.equals(nStu));
            boolean flag = true;
            for(int i=0; i<n; i++){
                if(og[i] != nStu[i]){
                    flag = false;
                    break;
                }
            }
            if(flag){
                break;
            }
            for(int i=0; i<n; i++)
            stu[i] = nStu[i];
        }

        return count;
    }
}
