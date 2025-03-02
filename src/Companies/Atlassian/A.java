package Companies.Atlassian;

import java.util.Arrays;
import java.util.Scanner;
public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

//        int n =sc.nextInt();
//        int arr[] = new int[n];
//        for(int i=0; i<n; i++)arr[i] = sc.nextInt();

        int res[] = batonPass(3, 6);

        System.out.println(Arrays.toString(res));
    }

    public static int[] batonPass(int friends, long time){
        if(time < friends) return new int[]{(int)time, (int)time+1};
        if(time == friends) return new int[]{(int)time, (int)time-1};

        int count = 0;
        if(time%friends != 0){
            count = (int)(time/friends)+1;
        }

        if(count%2 == 0){
            return new int[]{(int)time, (int)time+1};
        }
//        else{
            return new int[]{(int)time, (int)time-1};
//        }
//        return new int[]{0,0};
    }
//    public static int[] solve(int arr[], int friends, long time){
//// vector<int> ans;
//        int[]
// int k = 1;
// boolean r = false;
// long i = 1;
// while (i <= time) {
// if (!r) {
//if (k <= friends)
// k++;
// else {
// r = true;
// }
// } else {
// if (k >= 2) {
// k--;
// } else {
// r = false;
// }
// }
// i++;
// }
// if (r) {
// ans.push_back(k);
// ans.push_back(k - 1);
// } else {
// ans.push_back(k - 1);
// ans.push_back(k);
// }
// return ans;
//    }
}
