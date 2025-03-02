package CodeChef_Contest.Starter66;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class B {

    public static void main(String[] args) {
        FastScanner fs=new FastScanner();
        PrintWriter out=new PrintWriter(System.out);
        int T = fs.nextInt();

        for (int tt=0; tt<T; tt++) {
            int countOf01 = 0;
            int countOf10 = 0;
            String s = fs.next();
            int n = s.length();

            int itr = 0;
            while( itr<n-1){
                String cur = s.substring(itr, itr+2);
                if(cur.equals("01")) {
                    countOf01++;
                }
                else if(cur.equals("10")){
                    countOf10++;
                }
                itr++;
            }
            int res = 0;
            int size = -1;
            for(int i = 0; i<n; i++){
                char cur = s.charAt(i);
                int this01 = countOf01;
                int this10 = countOf10;
                if(i==0){
                    char next = s.charAt(i+1);
                    if(cur!='0'){
                        if(next=='1'){
                            this01++;
                        }
                        else{
                            this10--;
                        }
                    }
                    else{
                        if(next=='1'){
                            this01--;
                        }
                        else{
                            this10++;
                        }
                    }
                    if(this10==this01) {
                        res++;
                    }
                    continue;
                }
                if(size > 0){
                    List<Long> list = printDivisors(size);
                    int arr[] = new int[list.size()];
                    int ind = 0;
                    for(long l : list){
                        arr[ind++] = (int)l;
                    }
                    sort(arr);
                }
                if(i==n-1){
                    char prev = s.charAt(n-2);
                    if(cur=='0'){
                        if(prev!='1') {
                            this01++;
                        }
                        else {
                            this10--;
                        }
                    }
                    else{
                        if(prev!='0'){
                            this10++;
                        }
                        else{
                            this01--;
                        }
                    }
                    if(this10==this01){
                        res++;
                    }
                    continue;
                }
                char beforeThis = s.charAt(i-1);
                if(size > 0){
                    List<Long> list = printDivisors(size);
                    int arr[] = new int[list.size()];
                    int ind = 0;
                    for(long l : list){
                        arr[ind++] = (int)l;
                    }
                    sort(arr);
                }
                char afterThis = s.charAt(i+1);
                if(cur=='0'){
                    if(beforeThis=='0'){
                        this01++;
                    }
                    if(beforeThis=='1'){
                        this10--;
                    }
                    if(afterThis=='1'){
                        this01--;
                    }
                    if(afterThis=='0'){
                        this10++;
                    }
                }
                else if(cur=='1'){
                    if(beforeThis=='1'){
                        this10++;
                    }
                    if(beforeThis=='0'){
                        this01--;
                    }
                    if(afterThis=='1'){
                        this01++;
                    }
                    if(afterThis=='0'){
                        this10--;
                    }
                }
                if(this10 == this01){
                    res++;
                }
            }
            out.println(res);
        }
        out.close();
    }

    private static void solve() {
        // Write your code here;

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