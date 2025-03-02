package CodeChef_Contest.Starter82;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

class E {

    public static void main(String[] args) {
        FastScanner fs=new FastScanner();
        PrintWriter out=new PrintWriter(System.out);
//        static final long MOD = 1000000007;
        int T = fs.nextInt();

        for (int tt=0; tt<T; tt++) {
            long n = fs.nextInt();
            long m = fs.nextInt();
            int[] array1 = fs.readArray((int)n);
            int[] array2 = fs.readArray((int)n);
            List<Pair<Long,Long>> list = new ArrayList<>();
//            for(int i = 0; i < n; i++){
//                array1[i] = fs.nextInt();
//            }
            int noOfZeros = 0;
            for(int i=0; i<n; i++){
                long val = array2[i];
                if(val == 0) noOfZeros++;
                list.add(new Pair<>(val, (long)i));
            }
//            for(int i = 0; i < n; i++){
//                array2[i] = fs.nextInt();
//                if(array2[i] == 0){
//                    noOfZeros++;
//                }
//                list.add(new Pair<>(array2[i],i));
//            }
            //            for(int i=0; i<n; i++){
//                if(a[i] != b[i]){
//                    flag = false;
//                    break;
//                }
//            }
            for(int i = 0; i < n; i++){
                list.set(i, list.get(array1[i]-1));
            }
            Set<Long> set1 = new HashSet<>();
            Set<Long> set2 = new HashSet<>();
            for(int i = 0; i < n; i++){
                long val = 0;
                if(list.get(i).getKey() != 0){
                    val = list.get(i).getKey();
                    set1.add(val);
                }
                else{
                    val = list.get(i).getValue();
                    set2.add(val);
                }
            }
//            int noOfZeros = 0;
//            boolean hasOne = false;
//            for(int i : a){
//                if(i == 0) noOfZeros++;
//                if(i == 1) hasOne = true;
//            }
//
//            boolean wantOne = false;
//            for(int i : b){
//                if(i == 0) wantOne = true;
//            }
            long res = 0;
            if(set1.size() > 1){
                res = 0;
                out.println(res);
            }
            else{
                long totalEle = set2.size();
                long maxVal = noOfZeros - totalEle;
                res = 1;
                if(set1.size() == 0){
                    maxVal++;
                }
                int i =0;
                while( i < maxVal){
                    res =  ((res * m) % mod);
                    i++;
                }
                out.println(res);
            }


        }
        out.close();
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