package CodeChef_Contest.Starter86;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

class C {



    public static void main(String[] args) {
        FastScanner fs=new FastScanner();
        PrintWriter out=new PrintWriter(System.out);

        int NAX = 1000001;
        ArrayList<Integer> pr = new ArrayList<Integer>(), lpf = new ArrayList<Integer>(Collections.nCopies(NAX, 0));
        ArrayList<Boolean> is_prime = new ArrayList<Boolean>(Collections.nCopies(NAX, true));
        is_prime.set(0, false);
        is_prime.set(1, false);

        for (int i = 2; i < NAX; i++)
        {
            if (is_prime.get(i))
            {
                pr.add(i);
                lpf.set(i, i);
                for (int j = i * i; j < NAX; j += i)
                {
                    is_prime.set(j, false);
                    lpf.set(j, i);
                }
            }
        }

        int t = fs.nextInt();
        for (int ii = 1; ii <= t; ii++)
        {

            int n, x, g = 0;
            n = fs.nextInt();
            x = fs.nextInt();
            int[] a = fs.readArray(n);
            for (int i = 0; i < n; i++)
                g = (int) gcd(g, a[i]);

            HashSet<Integer> s = new HashSet<Integer>();
            for (int i = 0; i < n; i++)
                s.add(a[i]);
            if (s.size() == 1)
            {
                out.println(0);
                continue;
            }

            HashSet<Integer> p = new HashSet<Integer>();
            for (int i = 0; i < n; i++)
            {
                int t1 = a[i];
                while (t1 > 1)
                {
                    int f = lpf.get(t1);
                    p.add(f);
                    while (t1 % f == 0)
                        t1 /= f;
                }
            }

            TreeSet<Integer> gp = new TreeSet<Integer>();
            while (g > 1)
            {
                int f = lpf.get((int) g);
                gp.add(f);
                while (g % f == 0)
                    g /= f;
            }

            if (!gp.isEmpty() && gp.first() <= x)
            {
                out.println(1);
                out.println(gp.first());
            }
            else
            {
                boolean ok = false;
                int pp = Collections.binarySearch(pr, x);
                if (pp < 0)
                    pp = -pp - 2;
                for (int i = pp; i >= 0; i--)
                {
                    if (!p.contains(pr.get(i)))
                    {
                        out.println(1);
                        out.println(pr.get(i));
                        ok = true;
                        break;
                    }
                }
                if (ok)
                    continue;
                out.println("2\n2 3");
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

    static void reverse(int[] arr){
        ArrayList<Integer> l = new ArrayList<>();
        for(int i : arr) l.add(i);
        Collections.reverse(l);
        for(int i=0; i<arr.length; i++) arr[i] = l.get(i);

    }

    static void swap(int a, int b, int arr[]){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
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