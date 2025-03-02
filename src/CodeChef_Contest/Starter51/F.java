package CodeChef_Contest.Starter51;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

class F {

    public static void main(String[] args) {
        FastScanner fs=new FastScanner();
        PrintWriter out=new PrintWriter(System.out);
        int T = fs.nextInt();

        for (int tt=0; tt<T; tt++) {
            long n = fs.nextLong();
            long k = fs.nextLong();

            long a[] = new long[(int)n];
            for(int i=0; i<n; i++){
                a[i] = fs.nextLong();
            }
        }
        out.close();
    }


    public int edgeScore(int[] edges) {
        Map<Long, Long> mapping = new HashMap<>();
        int n = edges.length;
        int i = 0;
        List<Long> indNow = new ArrayList<>();
        long valOfMax = Long.MIN_VALUE;
        for(int l = 0; l<n; l++) {
            mapping.put((long)l, 0l);
        }
        while(i<n){
            int[] cur = new int[2];
//            {i, edges[i];
            cur[0] = i;
            cur[1] = edges[i];
//            int req = cur[1]+cur[0];
            mapping.put((long) cur[1], mapping.get(cur[1])+cur[0]);
            i++;
        }
        for(long values: mapping.keySet()){
            long valNow = mapping.get(values);
            if(valNow == valOfMax) indNow.add(values);
            else if(valNow>valOfMax){
                indNow = new ArrayList<>();
                indNow.add(values);
                valOfMax = valNow;
            }
        }

        long valOfMin = Long.MAX_VALUE;
        for(long j: indNow) {
            if(valOfMin < j){
                valOfMin = valOfMin;
            }
            else{
                valOfMin = j;
            }
//            valOfMin = Math.min(valOfMin, j);
        }
        return (int)valOfMin;
    }



    public int countSpecialNumbers(int n) {
        return getNumberOfUnqique(n) - 1;
    }
    private int getNumberOfUnqique(int x) {
        List<Integer> count = new ArrayList<>();
        int chare = x;
        while (chare != 0) {
            count.add(chare % 10);
            chare /= 10;
        }
        int n = count.size();
        if (n <= 1){
            return x + 1;
        }
        int res = 0;
        for (int i = n - 1, last = 1, idx = 0; i >= 0; i--, last++) {
            int cur = count.get(i), freq = 0;
            for (int j = cur - 1; j >= 0; j--) {
                if (i == n - 1 && j == 0) {
                    continue;
                }
                if ( ((idx >> j) & 1) == 0) {
                    freq++;
                }
            }
            int a = 10 - last;
            int b = a - (n - last) + 1;

//            res += b <= a ? freq * memo[b][a] : freq;

            if(b<=a){
                res += freq*memo[b][a];
            }
            else{
                res += freq;
            }
            if (((idx >> cur) & 1) == 1) {
                break;
            }
            idx |= (1 << cur);
            if (i == 0){
                res++;
            }
        }
        res += 10;
        for (int i = 2, end = 9; i < n; i++) {
            int ans = (10 - i + 1);
            int cur = end * ans;
            res += cur;
            end = cur;
        }
        return res;
    }
    static int[][] memo = new int[10][10];
    static {for (int i = 1; i < 10; i++) {
        for (int j = i; j < 10; j++) {
            int cur = 1;
            for (int k = i; k <= j; k++) {
                cur *= k;
            }
            memo[i][j] = cur;
        }
    }
    }
//    static int[][] memo = new int[10][10];
//    static {for (int i = 1; i < 10; i++) {
//        for (int j = i; j < 10; j++) {
//                int cur = 1;
//                for (int k = i; k <= j; k++) {
//                    cur *= k;
//                }
//                memo[i][j] = cur;
//            }
//        }
//    }


    static List<Long> printDivisors(long n) {
        List<Long> list = new ArrayList<>();
        // Note that this loop runs till square root
        for (int i=1; i<=Math.sqrt(n); i++){

            if (n%i==0){
                // If divisors are equal, print only one
                if (n/i == i) {
                    list.add((long)i);
//                    System.out.print(" "+ i);
                }
                // Otherwise print both
                else {
                    list.add((long)i);
                    list.add(n/i);
//                    System.out.print(i+" " + n/i + " " );
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


}