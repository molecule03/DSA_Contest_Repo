package CodeChef_Contest.Starter65;

//package CodeChef.Starter58;

//package CodeChef.SepLunchTime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

class C {
//    PrintWriter out=new PrintWriter(System.out);
    public static void main(String[] args) {
        FastScanner fs=new FastScanner();
        PrintWriter out=new PrintWriter(System.out);
        int T = fs.nextInt();

        for (int tt=0; tt<T; tt++) {

            int N = fs.nextInt();
            int Q = fs.nextInt();

            int arr[][] = new int[60][N];
            for(int i=0; i<N; i++){
                long input = fs.nextLong();
                int j = 0;
                while(j<60){
                    arr[j][i] = (int)(input%2);
                    input/=2;
                    j++;
                }
            }

            for(int i=0; i<60; i++){
                int prefixSum = 0;
                int j = 0;
                while(j<N){
                    prefixSum += arr[i][j];
                    arr[i][j] = prefixSum;
                    j++;
                }
            }

            for(int qq=0; qq<Q; qq++){
                int k = fs.nextInt();
                int l1 = fs.nextInt();
                int r1 = fs.nextInt();
                int l2 = fs.nextInt();
                int r2 = fs.nextInt();
                solve(arr, k, l1-1, r1-1, l2-1 , r2-1);
            }
        }
        out.close();
    }
     public static void solve(int arr[][], int k , int l1, int r1, int l2, int r2){
         int leftlength = r1-l1+1;
         int rightlength = r2-l2+1;

         int finalleft;
         int finalright;
         if(l1 != 0)finalleft = arr[k][r1]-arr[k][l1-1];
         else finalleft = arr[k][r1];

         if(l2 != 0)finalright = arr[k][r2]-arr[k][l2-1];
         else finalright = arr[k][r2];

         long leftSum = (long)(leftlength-finalleft)*(long)(finalright);
         long rightSum =  (long)(rightlength-finalright)*(long)(finalleft);
         long ans =  leftSum + rightSum;
         System.out.println(ans);
     }



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

