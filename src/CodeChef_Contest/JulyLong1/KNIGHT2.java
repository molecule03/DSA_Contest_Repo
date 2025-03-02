package CodeChef_Contest.JulyLong1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

class KNIGHT2 {

    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);
        int T = fs.nextInt();
        for (int tt = 0; tt < T; tt++) {
            int x1 = fs.nextInt();
            int y1 = fs.nextInt();
            int x2 = fs.nextInt();
            int y2 = fs.nextInt();
            memo[1][0] = 3;
            memo[0][1] = 3;
            memo[1][1] = 2;
            memo[2][0] = 2;
            memo[0][2] = 2;
            memo[2][1] = 1;
            memo[1][2] = 1;

            int ans = getSteps(x1, y1, x2, y2);

            if (ans > 100 || ans % 2 != 0) {
                out.println("No");
            } else {
                out.println("Yes");
            }
        }
        out.close();
    }

//    private boolean dfs(TreeNode node) {
//        if (node.left == null)
//            return node.val;
//        else {
//            if (node.val == 3) {
//                return dfs(node.left) & dfs(node.right);
//            } else {
//                return dfs(node.left) | dfs(node.right);
//            }
//        }
//    }

    //    class Solution {
    static public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        Arrays.sort(buses);
        Arrays.sort(passengers);
        TreeSet<Integer> set = new TreeSet<>();

        int remaining;
        int latesttime = 0;
        int j = 0;
        for (int i = 0; i < buses.length; i++) {
            remaining = 0;
            while (remaining < capacity && j < passengers.length && passengers[j] <= buses[i]) {
                latesttime = passengers[j];
                set.add(latesttime);
                j++;
                remaining++;
            }
            boolean flag = i == buses.length - 1 && remaining < capacity && latesttime < buses[i];
            if (flag)
                return buses[buses.length - 1];
        }

        if (set.size() == 0) {
            return buses[buses.length - 1];
        }

        int lastTime = set.last();
        while (set.contains(lastTime)) {
            lastTime--;
        }

        return lastTime;
    }

    //    }
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        long farak[] = new long[100000+1];
        for(int i=0; i< nums1.length; i++){
            farak[Math.abs(nums1[i]-nums2[i])]++;
        }
        int khata = 0;
        int ujva = k1+k2;
        for(int i=100000; i>-0;i--){
            khata = (int) farak[i];
            if(khata <=ujva){
                if(i<=1)return 0;
                farak[i-1] += farak[i];
                farak[i] = 0;
                ujva -= khata;
            }else{
                if(i==0)return 0;
                farak[i-1] += ujva;
                farak[i] -= ujva;
                break;
            }
        }

        long res = 0;
        for(long i=1l; i<=100000; i++){
            res += (long) farak[(int) i]*(long)(i*i);
        }
        return res;
    }

    static int[][] memo = new int[8][8];

    static int getSteps(int x1, int y1, int x2, int y2) {

        if (x1 == x2 && y1 == y2) {
            return memo[0][0];
        } else if (memo[Math.abs(x1 - x2)][Math.abs(y1 - y2)] != 0) {
            return memo[Math.abs(x1 - x2)][Math.abs(y1 - y2)];
        } else {
            int a1, b1, a2, b2;
            if (x1 <= x2) {
                if (y1 <= y2) {
                    a1 = x1 + 2;
                    b1 = y1 + 1;
                    a2 = x1 + 1;
                    b2 = y1 + 2;
                } else {
                    a1 = x1 + 2;
                    b1 = y1 - 1;
                    a2 = x1 + 1;
                    b2 = y1 - 2;
                }
            } else if (y1 <= y2) {
                a1 = x1 - 2;
                b1 = y1 + 1;
                a2 = x1 - 1;
                b2 = y1 + 2;
            } else {
                a1 = x1 - 2;
                b1 = y1 - 1;
                a2 = x1 - 1;
                b2 = y1 - 2;
            }

            memo[Math.abs(x1 - x2)][Math.abs(y1 - y2)] = Math.min(getSteps(a1, b1, x2, y2), getSteps(a2, b2, x2, y2)) + 1;
            memo[Math.abs(y1 - y2)][Math.abs(x1 - x2)] = memo[Math.abs(x1 - x2)][Math.abs(y1 - y2)];
            return memo[Math.abs(x1 - x2)][Math.abs(y1 - y2)];
        }
    }


    static List<Long> printDivisors(long n) {
        List<Long> list = new ArrayList<>();
        // Note that this loop runs till square root
        for (int i = 1; i <= Math.sqrt(n); i++) {

            if (n % i == 0) {
                // If divisors are equal, print only one
                if (n / i == i) {
                    list.add((long) i);
//                    System.out.print(" "+ i);
                }
                // Otherwise print both
                else {
                    list.add((long) i);
                    list.add(n / i);
//                    System.out.print(i+" " + n/i + " " );
                }
            }
        }
        return list;
    }

    static long gcd(long a, long b) {
        if (a == 0)
            return b;

        return gcd(b % a, a);
    }

    // method to return LCM of two numbers
    static long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
    }

    static final Random random = new Random();
    static final int mod = 1_000_000_007;

    static void ruffleSort(int[] a) {
        int n = a.length;//shuffle, then sort
        for (int i = 0; i < n; i++) {
            int oi = random.nextInt(n), temp = a[oi];
            a[oi] = a[i];
            a[i] = temp;
        }
        Arrays.sort(a);
    }

    static long add(long a, long b) {
        return (a + b) % mod;
    }

    static long sub(long a, long b) {
        return ((a - b) % mod + mod) % mod;
    }

    static long mul(long a, long b) {
        return (a * b) % mod;
    }

    static long exp(long base, long exp) {
        if (exp == 0) return 1;
        long half = exp(base, exp / 2);
        if (exp % 2 == 0) return mul(half, half);
        return mul(half, mul(half, base));
    }

    static long[] factorials = new long[2_000_001];
    static long[] invFactorials = new long[2_000_001];

    static void precompFacts() {
        factorials[0] = invFactorials[0] = 1;
        for (int i = 1; i < factorials.length; i++) factorials[i] = mul(factorials[i - 1], i);
        invFactorials[factorials.length - 1] = exp(factorials[factorials.length - 1], mod - 2);
        for (int i = invFactorials.length - 2; i >= 0; i--)
            invFactorials[i] = mul(invFactorials[i + 1], i + 1);
    }

    static long nCk(int n, int k) {
        return mul(factorials[n], mul(invFactorials[k], invFactorials[n - k]));
    }

    static void sort(int[] a) {
        ArrayList<Integer> l = new ArrayList<>();
        for (int i : a) l.add(i);
        Collections.sort(l);
        for (int i = 0; i < a.length; i++) a[i] = l.get(i);
    }


    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        int[] readArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = nextInt();
            return a;
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }


}