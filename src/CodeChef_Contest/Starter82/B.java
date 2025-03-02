package CodeChef_Contest.Starter82;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

 class B {

    public static void main(String[] args) {
        FastScanner fs=new FastScanner();
        PrintWriter out=new PrintWriter(System.out);
        int T = fs.nextInt();

        for (int tt=0; tt<T; tt++) {

            int n = fs.nextInt();
            int a[] = new int[n];
            int b[] = new int[n];
            for(int i=0; i<n; i++) a[i] = fs.nextInt();
            for(int i=0; i<n; i++)b[i] = fs.nextInt();

            if(a.equals(b)){
                out.println("YES");
                continue;
            }
            else if(a[0] != b[0] || a[n-1]!=b[n-1]){
                out.println("NO");
                continue;
            }

            int lz[] = new int[n];
            int rz[] = new int[n];
            int lo[] = new int[n];
            int ro[] = new int[n];

            lz[0] = 0;
            lo[0] = 0;
            for(int i=1; i<n; i++){
                if(a[i] == 0){
                    lz[i] = lz[i-1]+1;
                    lo[i] = lo[i-1];
                }
                else{
                   lo[i] = lo[i-1]+1;
                    lz[i] = lz[i-1];
                }
            }

            rz[n-1] = 0;
            ro[n-1] = 0;
            for(int i=n-2; i>=0; i--){
                if(a[i] == 0){
                    rz[i] = rz[i+1]+1;
                    ro[i] = ro[i+1];
                }
                else{
                    ro[i] = ro[i+1]+1;
                    rz[i] = rz[i+1];
                }
            }

            for(int i=1; i<n-1; i++){
                if(b[i] == 0){
                    if(a[i] == 0 && lz[i]>0 && rz[i]>0 ){
                        a[i] = 0;
                    }
                }
                else{
                    if(a[i] == 1 || lo[i] > 0 || ro[i] > 0){
                        a[i] = 1;
                    }
                }
            }

//            out.println(Arrays.toString(a)+" "+Arrays.toString(b));
            int one = 0;
            int zero = 0;
            for(int i : a){
                if(i == 0) zero++;
                else one++;
            }

            boolean flag = true;
            for(int i=1; i<n-1; i++){
                if(a[i]!=b[i] ) {

                    if (a[i] == 0 && one == 0) {
                        flag = false;
                        break;
                    }
                    if (a[i] == 1) {
                        flag = false;
                        break;
                    }
                }
            }

//
//            for(int i=0; i<n; i++){
//                if(a[i] != b[i]){
//                    flag = false;
//                    break;
//                }
//            }
            if(flag){
                out.println("Yes");
            }
            else{
                out.println("No");
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
//
//            if(noOfZeros >= 3 && (hasOne==wantOne)){
//                out.println("YES");
//            }
//            else{
//                out.println("NO");
//            }

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


}