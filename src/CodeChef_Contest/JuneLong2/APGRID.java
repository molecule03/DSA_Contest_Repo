package CodeChef_Contest.JuneLong2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;


public class APGRID  {

    public static void main(String[] args) {
        FastScanner fs=new FastScanner();
        PrintWriter out=new PrintWriter(System.out);
        int T = fs.nextInt();
        for (int tt=0; tt<T; tt++) {

            int n = fs.nextInt();
            int m = fs.nextInt();

            int[] rows = new int[n];
            int[] cols = new int[m];
            if(n > m){
                int i = 1;
                for(int j=0; j<m; j++)
                    cols[j] = i++;

                for(int j=0; j<n; j++)
                    rows[j] = i++;
            }else{
                int i = 1;
                for(int j=0; j<n; j++)
                    rows[j] = i++;

                for(int j=0; j<m; j++)
                    cols[j] = i++;
            }

            int[][] mat = new int[n][m];
            mat[0][0] = 1;
            for(int i=0; i<n; i++){
                for(int k=0; k<m; k++){
                    if(i==0){
                        if(k==0) continue;
                        mat[i][k] = mat[i][k-1]+rows[i];
                    }
                    else{
                        mat[i][k] = mat[i-1][k]+cols[k];
                    }
                }
            }

            for(int i=0; i<n; i++){
                for(int k=0; k<m; k++){
                    out.print(mat[i][k]+" ");
                }
                out.println("");
            }

        }
        out.close();
    }
    static int printDivisors(int n)
    {
        int count = 0;
        List<Integer> list = new ArrayList<>();
        // Note that this loop runs till square root
        for (int i=2; i<=Math.sqrt(n)+1; i++)
        {

            if (n%i==0)
            {
//                 If divisors are equal, print only one
                if (n/i == i) {
                    list.add(i);
//                    System.out.print(" "+ i);
                    count++;
                }
                // Otherwise print both
                else {
                    list.add(i);
                    list.add(n/i);
                    count += 2;
//                    System.out.print(i+" " + n/i + " " );
                }
            }
        }
        return count;
    }
    static long gcd(long a, long b)
    {
        if (a == 0)
            return b;

        return gcd(b%a, a);
    }

    // method to return LCM of two numbers
    static long lcm(long a, long b)
    {
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