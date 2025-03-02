package CodeChef_Contest.Starter78;

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
            int k = fs.nextInt();
            int fir[] = fs.readArray(n);
            int sec[] = fs.readArray(n);

            int max[][] = new int[n][2];
            for (int i = 0; i < n; i++){
                max[i][0] = fir[i];
                max[i][1] = sec[i];
            }
//            Collections.sort(list,(first,sec) -> ((first[0] + first[1] == sec[0]
//            + sec[1]) ? first[0]<sec[0] : first[0]+first[1] < sec[0]+sec[1]));
            int last = 0;
            int total = 0;
//            int res = 0
//            Arrays.sort(max, (int x[], int y[])-> (x[0] + x[1] == y[0] + y[1]) ? x[0] < y[0] : x[0] + x[1] < y[0] + y[1]);
            Arrays.sort(max, (x,y)->(x[0] + x[1] == y[0] + y[1]) ? ((x[0] - y[0])) : ((x[0] + x[1] )- (y[0] + y[1]))  );

            int counter;
            for(counter = 0; counter < n; counter++){
                if (isValid(max, k, total, counter)){
                    total += max[counter][0] + max[counter][1];
                    last = Math.max(last, max[counter][1]);
                }else{
                    break;
                }
            }

            int min[] = new int[n];
            int itr = n-1;
            while( itr >= 0){
                if (itr == n - 1){
                    min[itr] = max[itr][0];
                }else {
                    min[itr] = Math.min(min[itr + 1], max[itr][0]);
                }
                itr--;
            }

            int res = counter;
            if (counter < n){
                int rem = k - total;
                if ((min[counter] <= rem) || (rem + last >= max[counter][0] + max[counter][1])) res++;
            }
            out.println(res);

        }
        out.close();
    }

    private static boolean isValid(int max[][], int k, int total, int i){
        return (max[i][0] + max[i][1] + total <= k) ? true : false;
    }
    private static int compare(int[] x, int[] y) {
        return (x[0] + x[1] == y[0] + y[1]) ? x[0] < y[0] ? 1 : 0 : x[0] + x[1] < y[0] + y[1] ? 1 : 0;
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