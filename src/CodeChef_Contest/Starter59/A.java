package CodeChef_Contest.Starter59;

//package CodeChef.Starter58;

//package CodeChef.SepLunchTime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

class A {

    public static void main(String[] args) {
        FastScanner fs=new FastScanner();
        PrintWriter out=new PrintWriter(System.out);
        int T = fs.nextInt();

        for (int tt=0; tt<T; tt++) {
            int length = fs.nextInt();
            String s = fs.next();
            char[] charArray = s.toCharArray();
            String res = "";
            char[] a = s.toCharArray();
            char now = 'a';
            int left = 0;
            int right = length-1;
            boolean leftSide = true;
            while(left<=right){
                if(leftSide){
                    char curr = a[left];
                    if(curr =='0') {
                        res = curr+res;
                    }
                    else{
                        res = res+curr;
                    }
                     now = charArray[right];
                    if(now == 'a'){
                        now--;
                    }
                    left++;
                    leftSide = false;
                }
                else{
                    char cur = a[right];
                    if(cur == '0'){
                        res = res+cur;
                    }
                    else{
                        res = cur+res;
                    }
                     now = charArray[left];
                    if(now == 'a'){
                        now++;
                    }
                    right--;
                    leftSide = true;
                }
            }
            if(now+"" == res){
                out.println(now+"");
            }
            else {
                out.println(res);
            }
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

