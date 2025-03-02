package CodeChef_Contest.Starter85;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

class E {


    static int N, M;
    public static void main(String[] args) {
        FastScanner sc=new FastScanner();
        PrintWriter out=new PrintWriter(System.out);
        int T = sc.nextInt();

        for (int tt=0; tt<T; tt++) {

            long n = sc.nextLong();
            N = (int)n;
            long m = sc.nextInt();
            M = (int)m;
            long k = sc.nextInt()+1;

            long sum = 0;
            long[][] a = new long[(int)n + 1][(int)m + 1];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    a[i][j] = sc.nextInt();
                    sum += a[i][j];
                }
            }

            long[][] dp = new long[(int)n + 1][(int)m + 1];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    dp[i][j] = a[i][j];
                    dp[i][j] += dp[i][j - 1];
                    dp[i][j] += dp[i - 1][j];
                    dp[i][j] -= dp[i - 1][j - 1];
                }
            }

            if (sum < k) {
                System.out.println(-1);
                continue;
            }

            long lo = 0;
            long hi = Math.max(n, m);
            long md;
            while (lo < hi) {
                md = (lo + hi) / 2;
                if (isValid(md, k, a, dp))
                    hi = md;
                else
                    lo = md + 1;
            }

            out.println(lo);

        }
        out.close();
    }


    static int[] findMentorRoom(int[][] A) {
        int max_capacity = 0;
        int[] mentor_room = new int[2];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (A[i][j] >= max_capacity) {
                    max_capacity = A[i][j];
                    mentor_room[0] = i;
                    mentor_room[1] = j;
                }
            }
        }
        return mentor_room;
    }
    static int computeMaxDistance() {
        int max_distance = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                max_distance = Math.max(max_distance, Math.max(i, N-1-i) + Math.max(j, M-1-j));
            }
        }
        return max_distance;
    }
    static boolean isValid(long p, long k, long[][] a, long[][] dp) {
        long n = a.length - 1;
        long m = a[0].length - 1;
        computeMaxDistance();
        boolean flag = false;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (a[i][j] == 0)
                    continue;

                long x1 = Math.max(1L, i - p);
                long y1 = Math.max(1L, j - p);
                long x2 = Math.min(n, i + p);
                long y2 = Math.min(m, j + p);

                long sum = dp[(int)x2][(int)y2] - dp[(int)x2][(int)y1 - 1] - dp[(int)x1 - 1][(int)y2] + dp[(int)x1 - 1][(int)y1 - 1];
                if (sum >= k)
                    flag = true;
            }
        }
        return flag;
    }

    static boolean isPossible(int mid, int[][] A, int K) {
        int[] mentor_room = findMentorRoom(A);
        int students_assigned = 0;
        boolean[][] rooms_assigned = new boolean[N][M];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {mentor_room[0], mentor_room[1], 0});
        while (!queue.isEmpty() && students_assigned < K) {
            int[] room = queue.poll();
            int i = room[0], j = room[1], dist = room[2];
            if (rooms_assigned[i][j]) {
                continue;
            }
            rooms_assigned[i][j] = true;
            students_assigned += A[i][j];
            if (students_assigned >= K) {
                return true;
            }
            if (i > 0 && Math.abs(i-1-mentor_room[0]) <= mid && Math.abs(j-mentor_room[1]) <= mid) {
                queue.add(new int[] {i-1, j, dist+1});
            }
            if (i < N-1 && Math.abs(i+1-mentor_room[0]) <= mid && Math.abs(j-mentor_room[1]) <= mid) {
                queue.add(new int[] {i+1, j, dist+1});
            }
            if (j > 0 && Math.abs(j-1-mentor_room[1]) <= mid && Math.abs(i-mentor_room[0]) <= mid) {
                queue.add(new int[] {i, j-1, dist+1});
            }
            if (j < M-1 && Math.abs(j+1-mentor_room[1]) <= mid && Math.abs(i-mentor_room[0]) <= mid) {
                queue.add(new int[] {i, j+1, dist+1});
            }
        }
        return false;
    }
    static int sum(int[][] A) {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sum += A[i][j];
            }
        }
        return sum;
    }






    public static boolean isPalindorme(int arr[]){

        int left = 0;
        int right = arr.length-1;

        while(left <= right){

            if(arr[left] != arr[right]) return false;

            left++;
            right--;
        }

        return true;
    }

    static List<Long> printDivisors(long n) {
        List<Long> list = new ArrayList<>();
        // Note that this loop runs till square root
        for (int i=1; i<=Math.sqrt(n); i++){

            if (n%i==0){
                // If divisors are equal, print only one
                if (n/i == i) {
                    list.add((long)i);
                }
                // Otherwise print both
                else {
                    list.add((long)i);
                    list.add(n/i);
                }
            }
        }
        return list;
    }

    static long gcd(long a, long b){
        if (a == 0)
            return b;

        return gcd(b%a, a);
    }

    // method to return LCM of two numbers
    static long lcm(long a, long b){
        return (a / gcd(a, b)) * b;
    }

    static final Random random=new Random();
    static final int mod=1_000_000_007;

    static void ruffleSort(int[] a) {
        int n=a.length;//shuffle, then sort
        for (int i=0; i<n; i++) {
            int oi=random.nextInt(n), temp=a[oi];
            a[oi]=a[i]; a[i]=temp;
        }
        Arrays.sort(a);
    }
    static long add(long a, long b) {
        return (a+b)%mod;
    }
    static long sub(long a, long b) {
        return ((a-b)%mod+mod)%mod;
    }
    static long mul(long a, long b) {
        return (a*b)%mod;
    }
    static long exp(long base, long exp) {
        if (exp==0) return 1;
        long half=exp(base, exp/2);
        if (exp%2==0) return mul(half, half);
        return mul(half, mul(half, base));
    }
    static long[] factorials=new long[2_000_001];
    static long[] invFactorials=new long[2_000_001];
    static void precompFacts() {
        factorials[0]=invFactorials[0]=1;
        for (int i=1; i<factorials.length; i++) factorials[i]=mul(factorials[i-1], i);
        invFactorials[factorials.length-1]=exp(factorials[factorials.length-1], mod-2);
        for (int i=invFactorials.length-2; i>=0; i--)
            invFactorials[i]=mul(invFactorials[i+1], i+1);
    }

    static long nCk(int n, int k) {
        return mul(factorials[n], mul(invFactorials[k], invFactorials[n-k]));
    }

    static void reverse(int[] arr){
        ArrayList<Integer> l = new ArrayList<>();
        for(int i : arr) l.add(i);
        Collections.reverse(l);
        for(int i=0; i<arr.length; i++) arr[i] = l.get(i);

    }

    static void swap(int a, int b, int arr[]){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    static void sort(int[] a) {
        ArrayList<Integer> l=new ArrayList<>();
        for (int i:a) l.add(i);
        Collections.sort(l);
        for (int i=0; i<a.length; i++) a[i]=l.get(i);
    }


    static class FastScanner {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer("");
        String next() {
            while (!st.hasMoreTokens())
                try {
                    st=new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
        int[] readArray(int n) {
            int[] a=new int[n];
            for (int i=0; i<n; i++) a[i]=nextInt();
            return a;
        }
        long nextLong() {
            return Long.parseLong(next());
        }
    }

    static class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }


}