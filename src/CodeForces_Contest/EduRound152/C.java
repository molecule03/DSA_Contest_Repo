package CodeForces_Contest.EduRound152;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class C {

    public static void main(String[] args) {

        FastScanner fs=new FastScanner();
        PrintWriter out=new PrintWriter(System.out);


        int T = fs.nextInt();
        for (int tt=0; tt<T; tt++) {

            int n = fs.nextInt();
            int m = fs.nextInt();

            String ss = fs.next();

            int op[][] = new int[m][2];
            for(int i=0; i<m; i++){
                op[i][0] = fs.nextInt();
                op[i][1] = fs.nextInt();
            }

            int diff[] = new int[n+1];
            diff[0] = 0;
            int count = ss.charAt(0)-'0';
            for(int i=1; i<n; i++){
                diff[i] = count;
                if(ss.charAt(i) == '1')count++;
            }
            diff[n] = count;
//            out.println(Arrays.toString(diff));

//            Set<String> check = new HashSet<>();
//            Set<String> set = new HashSet<>();
            Map<String, Integer> map = new HashMap<>();
            for(int[] o : op){
                int l = o[0]-1;
                int r = o[1]-1;
                StringBuilder sb = new  StringBuilder();
                int ones = diff[r+1]-diff[l];
                int zeros = (r-l+1)-ones;

//                if(check.contains(l+""+r)){
//                    continue;
//                }
//                out.print(l+" "+r+" "+"zeros="+zeros+" ones="+ones+" ");
                for(int i=0; i<l; i++){
                    sb.append(ss.charAt(i));
                }
//                out.print(sb.toString()+" ");

                for(int i=l; i<=r; i++){
                    if(zeros > 0){
                        sb.append(0);
                        zeros--;
                    }
                    else {
                        sb.append(1);
                    }
                }
//                out.print(sb.toString()+" ");

                for(int i=r+1; i<n; i++){
                    sb.append(ss.charAt(i));
                }
//                out.println("           "+sb.toString());
//                if(!set.contains(sb.toString()))
//                set.add(sb.toString());
                map.put(sb.toString(), 1);
//                check.add(l+""+r);
            }
//            out.println(check);
//            out.println(set);

            out.println(map.size());
        }

        out.close();
    }


    static boolean isPalindorme(int arr[]){

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

    static Set<Integer> printDivisorsInSet(int n) {
        Set<Integer> list = new HashSet<>();
        // Note that this loop runs till square root
        for (int i=1; i*i<=n; i++){

            if (n%i==0){
                // If divisors are equal, print only one
                list.add(i);
                list.add(n/i);
            }
        }
        return list;
    }

    static long gcd(long a, long b){
        if (a == 0)
            return b;

        return gcd(b%a, a);
    }


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
    static void print(int[] arr){
        PrintWriter out=new PrintWriter(System.out);
        out.print(Arrays.toString(arr)+" ");
    }
    static void print(long[] arr){
        PrintWriter out=new PrintWriter(System.out);
        out.print(Arrays.toString(arr)+" ");
    }
    static void println(long[] arr){
        PrintWriter out=new PrintWriter(System.out);
        out.println(Arrays.toString(arr)+" ");
    }
    static void println(int[] arr){
        PrintWriter out=new PrintWriter(System.out);
        out.println(Arrays.toString(arr)+" ");
    }
    static void reverse(int[] arr){
        ArrayList<Integer> l = new ArrayList<>();
        for(int i : arr) l.add(i);
        Collections.reverse(l);
        for(int i=0; i<arr.length; i++) arr[i] = l.get(i);
    }
    static void reverse(long[] arr){
        ArrayList<Long> l = new ArrayList<>();
        for(long i : arr) l.add(i);
        Collections.reverse(l);
        for(int i=0; i<arr.length; i++) arr[i] = l.get(i);
    }
    static void swap(int a, int b, int arr[]){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    static void sort(int[] arr) {
        ArrayList<Integer> l=new ArrayList<>();
        for (int i:arr) l.add(i);
        Collections.sort(l);
        for (int i=0; i<arr.length; i++) arr[i]=l.get(i);
    }
    static void sort(long[] arr) {
        ArrayList<Long> l=new ArrayList<>();
        for (long i:arr) l.add(i);
        Collections.sort(l);
        for (int i=0; i<arr.length; i++) arr[i]=l.get(i);
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