package CodeChef_Contest.Starter51;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

class E {

    public static void main(String[] args) {
        FastScanner fs=new FastScanner();
        PrintWriter out=new PrintWriter(System.out);
        int T = fs.nextInt();

        for (int tt=0; tt<T; tt++) {
            long n = fs.nextLong();
            long toBeChanged = 0;
            long minEle = 0;
            long a[] = new long[(int)n];
            long maxEle = 0;
            int i = (int)n-1;
            while(i>=0){
                a[i] = fs.nextLong();
                maxEle = Math.max(maxEle, a[i]);

                minEle = Math.min(minEle, a[i]);
                if(a[i]%2!=0){
                    toBeChanged^=i;
                    i--;
                }
                else{
                    maxEle++;
                    minEle--;
                    i--;
                    continue;
                }
            }
            minEle = maxEle*1;
//            String ans = "";

            long ans = maxEle-minEle;
            if(toBeChanged == 0 ){
                out.println("Cook");
//                String ans = "Cook";
            }
            else{
                out.println("Chef");
//                String ans = "Chef";
            }



//            out.println(ans);

        }
        out.close();
    }


    int increaseLeft(int left){
        return left+1;
    }
    public int secondsToRemoveOccurrences(String s) {
        int noOfSecs = 0;
        char[] charArray = s.toCharArray();
        while(checkFor01(charArray)){
            int left = 0;
            int right = 1;
            char one = '1';
            char zero = '0';
            while(right<charArray.length){
                if(charArray[left] == zero && charArray[right] == one){
                    charArray[left] = one;
                    charArray[right] = zero;
                    left += 2;
                    right += 2;
                    continue;
                }
                left = increaseLeft(left);
                right = increaseRight(right);
            }
            noOfSecs++;
        }
        return noOfSecs;
    }
    int increaseRight(int right){
        return right+1;
    }

    boolean checkFor01(char[] charArray){
        int left = 0;
        int right = 1;
        while(right<charArray.length){
            if(charArray[left] == '0' && charArray[right]=='1') {
                return true;
            }
            left = increaseLeft(left);
            right = increaseRight(right);
        }
        return false;
    }


    public long[] maximumSegmentSum(int[] nums, int[] removeQueries) {
        int n = nums.length;
        long[] ans = new long[n];
        TreeMap<Long, Integer> map = new TreeMap<>();
        TreeSet<Integer> toDorm = new TreeSet<>();
        long[] befsum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            befsum[i + 1] = befsum[i] + nums[i];
        }
        map.put(befsum[n] - befsum[0], 1);
        for (int i = 0; i < n; i++) {
            int idx = removeQueries[i];
            Integer left = toDorm.lower(idx);
            left = left == null ? 0 : left + 1;
            Integer right = toDorm.higher(idx);
            right = right == null ? n - 1 : right - 1;
            long last = befsum[right + 1] - befsum[left];
            if (map.merge(last, -1, Integer::sum) == 0) {
                map.remove(last);
            }
            if (left <= idx - 1) {
                long leftSum = befsum[idx] - befsum[left];
                map.merge(leftSum, 1, Integer::sum);
            }
            if (idx + 1 <= right) {
                long rightSum = befsum[right + 1] - befsum[idx + 1];
                map.merge(rightSum, 1, Integer::sum);
            }
            toDorm.add(idx);
            if (map.isEmpty()) {
                ans[i] = 0;
            } else {
                ans[i] = map.lastKey();
            }
        }
        return ans;
    }

    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {

        int e = 0;
        int eNeeded = 0;
        for(int i : energy){
            e += i;
        }
        if(initialEnergy > e){
            eNeeded += 0;
        }
        else{
            eNeeded += e-initialEnergy+1;
        }

        int xNeeded = 0;
        for(int x: experience){
            if(initialExperience>x){
                initialExperience += x;
            }
            else{
                int ideal = x+1;
                xNeeded += (ideal - initialExperience);
                initialExperience += (xNeeded + x);
            }
        }

        return xNeeded + eNeeded;
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