package CodeChef_Contest.Starter66;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class E {

    public static void main(String[] args) {
        FastScanner fs=new FastScanner();
        PrintWriter out=new PrintWriter(System.out);
        int T = fs.nextInt();

        for (int tt=0; tt<T; tt++) {
            int n = fs.nextInt();
            int arr[] = fs.readArray(n);
            int mid = n/2;


            int leftmax = arr[0];
            for(int i=0; i<mid; i++){
                leftmax = Math.max(leftmax, arr[i]);
            }
            List<Integer> left = new ArrayList<>();
            for(int i=0; i<mid; i++){
                if(arr[i] == leftmax){
                    left.add(i);
                }
            }

            int rightmax;
            List<Integer> right = new ArrayList<>();
            if(n%2 == 0) {
                rightmax = arr[mid];
                for (int i = mid; i < n; i++) {
                    rightmax = Math.max(rightmax, arr[i]);
                }
                for(int i=0; i<mid; i++){
                    if(arr[i] == rightmax){
                        right.add(i);
                    }
                }
            }
            else{
                rightmax = arr[mid+1];
                for (int i = mid+1; i < n; i++) {
                    rightmax = Math.max(rightmax, arr[i]);
                }
                for(int i=0; i<mid; i++){
                    if(arr[i] == rightmax){
                        right.add(i);
                    }
                }
            }

            List<Integer> diff = new ArrayList<>();
            for(int i : left){
                int ans = Math.abs(arr[i] - arr[n-i-1]);
                diff.add(ans);
            }
            for(int i : right){
                int ans = Math.abs(arr[i] - arr[n-i-1]);
                diff.add(ans);
            }

           Collections.sort(diff);
//            out.println(left+" "+right);
            out.println(diff.get(diff.size()-1));
        }
        out.close();
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