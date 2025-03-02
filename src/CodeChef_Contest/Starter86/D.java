package CodeChef_Contest.Starter86;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

class D {

    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);

        int MAX_SIZE = 1000001;
        List<Long> primes = new ArrayList<>();
        long[] lowestPrimeFactor = new long[MAX_SIZE];
        Arrays.fill(lowestPrimeFactor, 0);
        boolean[] isPrime = new boolean[MAX_SIZE];
        Arrays.fill(isPrime, true);
        setValues(isPrime, primes, lowestPrimeFactor, MAX_SIZE);

        int tt = fs.nextInt();
        for (int t = 1; t <= tt; t++) {
            int gcd = 0;
            int n = fs.nextInt();
            int x = fs.nextInt();
            int[] arr = fs.readArray(n);
            for (int i = 0; i < n; i++) {
                gcd = (int) gcd(gcd, arr[i]);
            }

            HashSet<Integer> uniqueValues = new HashSet<>();
            for (int i = 0; i < n; i++)
                uniqueValues.add(arr[i]);
            if (uniqueValues.size() == 1) {
                out.println(0);
                continue;
            }

            HashSet<Long> primeFactors = new HashSet<>();
            for (int i = 0; i < n; i++) {
                int currentNumber = arr[i];
                while (currentNumber > 1) {
                    long factor = lowestPrimeFactor[currentNumber];
                    primeFactors.add(factor);
                    while (currentNumber % factor == 0)
                        currentNumber /= factor;
                }
            }

            TreeSet<Long> gcdPrimeFactors = new TreeSet<>();
            while (gcd > 1) {
                long factor = lowestPrimeFactor[(int)gcd];
                gcdPrimeFactors.add(factor);
                while (gcd % factor == 0) {
                    gcd /= factor;
                }
            }

            if (!gcdPrimeFactors.isEmpty() && gcdPrimeFactors.first() <= x) {
                out.println(1);
                out.println(gcdPrimeFactors.first());
            } else {
                boolean found = false;
                long primeIndex = Collections.binarySearch(primes, (long)x);
                if (primeIndex < 0)
                    primeIndex = -primeIndex - 2;
                for (long i = primeIndex; i >= 0; i--) {
                    if (!primeFactors.contains(primes.get((int)i))) {
                        out.println(1);
                        out.println(primes.get((int)i));
                        found = true;
                        break;
                    }
                }
                if (found) continue;
                out.println("2\n2 3");
            }
        }
        out.close();
    }

    private static void setValues(boolean[] isPrime, List<Long> primes, long[] lowestPrimeFactor, int MAX_SIZE){

        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i < MAX_SIZE; i++) {
            if (isPrime[i]) {
                primes.add((long) i);
                lowestPrimeFactor[i] = i;
                for (long j = i * i; j < MAX_SIZE; j += i) {
                    if (j < 0) break;
                    isPrime[(int)j] = false;
                    lowestPrimeFactor[(int)j] = i;
                }
            }
        }
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