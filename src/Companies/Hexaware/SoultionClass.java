package Companies.Hexaware;

import java.util.Scanner;

public class SoultionClass {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int count = 0;
        int res = 0;
            for(int i=2; i<100000; i++){
                if(isPrime(i)){
                    System.out.println(i);
                    count++;
                }
                if(count == n) {
                    res = i;
                    break;
                }
            }

        System.out.println(res);
    }

    public static boolean isPrime(int n) {
        if (n <= 1)
            return false;

        if (n == 2 || n == 3)
            return true;

        if (n % 2 == 0 || n % 3 == 0)
            return false;

        for (int i = 5; i <= Math.sqrt(n); i = i + 6)
            if (n % i == 0 || n % (i + 2) == 0)
                return false;

        return true;
    }

    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int dp[][]=new int[n][k + 1], ans = -1;

        for(int i = 0; i < n; i++)
            for(int j = 0; j < k + 1; j++)
                dp[i][j]=-1;


        for (int i = 0; i < n; i++){
            dp[i][1] = nums1[i];
        }


        for (int i = 1; i < n; i++){
            for (int j = 0; j < i; j++){

                for (int l = 1; l <= k - 1; l++){

                    // Proceed if value is pre calculated
                    if (dp[j][l] != -1){

                        dp[i][l + 1] = Math.max(dp[i][l + 1],
                                dp[j][l] + nums1[i]);
                    }
                }
            }
        }


        for (int i = 0; i < n; i++){
            if (ans < dp[i][k])
                ans = dp[i][k];
        }

        return ans;
    }
}
