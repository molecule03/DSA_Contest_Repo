package Companies.LTI;

import java.util.Arrays;
import java.util.Scanner;
public class LTI {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

//        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i : arr){
            min = Math.min(i, min);
            max = Math.max(i, max);
        }
        System.out.println(min);
        System.out.println(max);
    }
}

 class Solution {
    public int distMoney(int money, int children) {
        if(money<children) return -1;
        int[] arr = new int[children];
        Arrays.fill(arr, 1);
        money  -= children;
        int i = 0;
        while( i<children){
            if(money>=7){
                arr[i] += 7;
                money-=7;
            }
            else if(money==3){
                if(i==(children-1)){
                    arr[i-1] = -1;
                    money=0;
                    break;
                }
                money = 0;
                break;
            }
            else{
                money=0;
            }
            i++;
        }

        int count = 0;
        for(int ele: arr) if(ele==8) count++;
        if(money==0 || count==0) return count;
        else return count-1;
    }
}
