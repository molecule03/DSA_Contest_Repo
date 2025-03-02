package LeetCode_Contest.W352;

import java.util.*;

public class B {

    public static void main(String[] args) {

        int n = 10;
        System.out.println(findPrimePairs(n));
    }


    public static List<List<Integer>> findPrimePairs(int n) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> p = SieveOfEratosthenes(n);

        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<p.size(); i++){
            map.put(p.get(i), i);
        }
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<p.size(); i++){
            int cur = p.get(i);
            if(cur == 1 || n-cur == 1) continue;
            if(map.containsKey(n-cur) && !set.contains(i)){

                List<Integer> l = new ArrayList<>();
                set.add(i);
                set.add(map.get(n-cur));
                l.add(cur);
                l.add(n-cur);
                list.add(l);
                // return new int[]{i, map.get(target-cur)};
            }
        }

        return list;
    }


    public static List<Integer> SieveOfEratosthenes(int n){

        int []primes = new int[n];
        List<Integer> list = new ArrayList<>();
        for (int i = 3; i * i < n; i += 2) {
            if (primes[i / 2] == 0) {
                for (int j = 3 * i; j < n; j += 2 * i)
                    primes[j / 2] = 1;
            }
        }

        for (int i = 1; i <= n; i++) {
            if (i == 2)
                list.add(i);
            else if (i % 2 == 1 && primes[i / 2] == 0)

                list.add(i);
        }

        return list;
    }

}
