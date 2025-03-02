package CodeChef_Contest.Starter83;

//package CodeChef.Starter83;

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

//            long a = fs.nextLong();
//            long b = fs.nextLong();
//            long c = fs.nextLong();

            int a = fs.nextInt();
            int b = fs.nextInt();
            int c = fs.nextInt();

            out.println(findX(a,b,c));
//            if(a<b && b<c){
////                out.println(c);
//                String s = Long.toBinaryString(c);
////                out.println(s);
//                int idx = 0;
//                int n = s.length();
//                for(int i=n-1; i>=0; i--){
//                    if(s.charAt(i) == '1'){
//                        idx = i;
//                    }
//                }
//                out.println(idx);
//                idx = (n-idx);
//                out.println(idx);
//                if(idx >= 31){
//                    out.println(-1);
//                    continue;
//                }
////
//                StringBuilder sb = new StringBuilder();
//                int count = idx;
//                while(count > 0){
//                    sb.append(0);
//                    count--;
//                }
//                sb.append(1);
//
//
//                s = sb.reverse().toString();
////                out.println(s);
//                long ans = 0;
//                int mul = 1;
//                for(int i=s.length()-1; i>=0; i--){
//                    ans += (s.charAt(i)-'0')*mul;
//                    mul *= 2;
//                }
//                out.println(ans);
//            }
//
//            else if(a>b && b>c){
//                out.println(a);
//            }
//            else{
//                out.println(-1);
//            }

        }
        out.close();
    }

    private static long findX(int a, int b, int c) {
        long x = -1;
        long left = 0;
        long right = (1L << 30) -1;
        while (left <= right) {
            long mid = (left + right) / 2;
            if ((a ^ mid) < (b ^ mid) && (b ^ mid) < (c ^ mid)) {
                x = mid;
                break;
            } else if ((a ^ mid) < (b ^ mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return x;
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