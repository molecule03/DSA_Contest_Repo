package Companies.MediaDotNet;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        int a[] = {44, 51, 3, 77, 2, 21, 55, 20, 84, 93};
//        System.out.println(Arrays.toString(operation(a, a.length)));
//        System.out.println(getFinal(5, 15));
        int a[] = {13,16,16,15,9,16,2,7,6,17,3,9};
        int b = 65;
//        int a[] = {1,2,3,4,5};
//        int b = 4;
        System.out.println(solve(a, b));
    }


//    public static int solve(int[] A, int B) {
//        int n = A.length;
//        int count = 0;
//        long[] prefixSum = new long[n];
//        Map<Long, Integer> oddSumCount = new HashMap<>();
//        Map<Long, Integer> evenSumCount = new HashMap<>();
//
//        long sum = 0;
//        for (int i = 0; i < n; i++) {
//            sum += A[i];
//            prefixSum[i] = sum;
//
//            if (i % 2 == 0) {
//                int diff = (i > 0) ? (int)(prefixSum[i - 1] - B) : 0;
//                count += oddSumCount.getOrDefault(diff, 0);
//                oddSumCount.put(prefixSum[i], oddSumCount.getOrDefault(prefixSum[i], 0) + 1);
//            } else {
//                int diff = (i > 0) ? (int)(prefixSum[i - 1] - B) : 0;
//                count += evenSumCount.getOrDefault(diff, 0);
//                evenSumCount.put(prefixSum[i], evenSumCount.getOrDefault(prefixSum[i], 0) + 1);
//            }
//
//            if (prefixSum[i] > B) {
//                count++;
//            }
//
//            if (count > 1000000000) {
//                return 1000000000;
//            }
//        }
//
//        return count;
//    }




//    public static int solve(int[] A, int B) {
//        int n = A.length;
//        int count = 0;
//        long sum = 0;
//        int evenSum = 0;
//        int oddSum = 0;
//
//        Map<Long, Integer> evenSums = new HashMap<>();
//        Map<Long, Integer> oddSums = new HashMap<>();
//
//        for (int i = 0; i < n; i++) {
//            sum += A[i];
//            int length = i + 1;
//
//            if (length % 2 == 0) {
//                if (sum < B)
//                    count++;
//                count += evenSums.getOrDefault(sum - B, 0);
//                evenSum++;
//            } else {
//                if (sum > B)
//                    count++;
//                count += oddSums.getOrDefault(sum - B, 0);
//                oddSum++;
//            }
//
//            if (length % 2 == 0) {
//                evenSums.put(sum, evenSums.getOrDefault(sum, 0) + 1);
//            } else {
//                oddSums.put(sum, oddSums.getOrDefault(sum, 0) + 1);
//            }
//
//            if (count > 1000000000) {
//                return 1000000000;
//            }
//        }
//
//        return count;
//    }

    public static int solve(int[] A, int B) {
        int n = A.length;
        int result = 0;

        int[] prefixSum = new int[n + 1];
        prefixSum[0] = 0;

        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + A[i];
        }

        for (int right = 0; right < n; right++) {

            for (int left = 0; left <= right; left++) {
                if (prefixSum[right + 1] % 2 == 0) {
                    if (prefixSum[right + 1] - prefixSum[left] < B) {
                        result++;
                    }
                } else {
                    if (prefixSum[right + 1] - prefixSum[left] > B) {
                        result++;
                    }
                }
            }
        }

        return Math.min(result, (int) Math.pow(10, 9));
    }



//    public  int solve(int[] A, int B) {
//        int n = A.length;
//        int count = 0;
//
//        for (int i = 0; i < n; i++) {
//            long sum = 0;
//            for (int j = i; j < n; j++) {
//                sum += A[j];
//
//                if((j-i+1)%2 == 0){
//                    if(sum < B) count++;
//                }
//                else{
//                    if(sum > B) count++;
//                }
//
//                if (count > 1000000009) {
//                    return 1000000009;
//                }
//            }
//        }
//
//        return count;
//    }





    public  int getFinal(int A, int B){

        int a = A;
        int b = B;
        int mod = 1000000007;

        while(a != b && a!=0 && b!=0){
            if(a < b){
                b -= a;
            }
            else{
                a -= b;
            }
        }

        return (a+b)%mod;
    }




    public  static int[] operation(int[] a, int n){
        for(int i=0; i+1<n; i++){
            if(a[i] > a[i+1]){
                int t = a[i];
                a[i] = a[i+1];
                a[i+1] = t;
            }
        }

        return a;
    }


    static public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    public int maxProfit(final int[] A) {

        int sum = 0;
        for(int i=1; i<A.length; i++){
            if(A[i]-A[i-1] > 0){
                sum += A[i]-A[i-1];
            }
        }

        return sum;
    }

    public ListNode mergeTwoLists(ListNode A, ListNode B) {

        ListNode dum = new ListNode(0);
        ListNode cur = dum;

        while (A != null && B != null) {
            if (A.val < B.val) {
                cur.next = A;
                A = A.next;
            } else {
                cur.next = B;
                B = B.next;
            }
            cur = cur.next;
        }

        cur.next = (A != null) ? A : B;

        return dum.next;

    }


}
