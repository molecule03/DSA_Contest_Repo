package CodeChef_Contest.Starter82;

import java.util.*;

public class F {
    static final long MOD = 1000000007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] arr1 = new int[n];
            int[] arr2 = new int[n];
            List<Pair<Integer,Integer>> v1 = new ArrayList<>();
            for(int i = 0; i < n; i++){
                arr1[i] = sc.nextInt();
            }
            int zero = 0;
            for(int i = 0; i < n; i++){
                arr2[i] = sc.nextInt();
                if(arr2[i] == 0){
                    zero++;
                }
                v1.add(new Pair<>(arr2[i],i));
            }
            for(int i = 0; i < n; i++){
                v1.set(i, v1.get(arr1[i]-1));
            }

            Set<Integer> s1 = new HashSet<>();
            Set<Integer> s2 = new HashSet<>();
            for(int i = 0; i < n; i++){
                if(v1.get(i).getKey() != 0){
                    s1.add(v1.get(i).getKey());
                }
                else{
                    s2.add(v1.get(i).getValue());
                }
            }

            if(s1.size() > 1){
                System.out.println(0);
            }
            else{
                int sz = s2.size();
                int maxi = zero - sz;
                int ans = 1;
                if(s1.size() == 0){
                    maxi++;
                }
                for(int i = 0; i < maxi; i++){
                    ans = (int) ((ans * m) % MOD);
                }
                System.out.println(ans);
            }
        }
        sc.close();
    }
}

class Pair<K, V> {
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