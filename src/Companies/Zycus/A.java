package Companies.Zycus;

import java.util.*;

public class A {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0; i<n; i++)arr[i] = sc.nextInt();

//        String s = "nine";
//        int l = 0;
//        int r = s.length()-1;
//
//        int c = 0;
//        while(l <= r){
//            if(arr[l] != arr[r])
//            if(s.charAt(l) != s.charAt(r)) {
//                System.out.println("Not Pal");
//                c= 1;
//                break;
//            }
//            l++;
//            r--;
//        }
//
//        if(c != 1){
//            System.out.println("Is Pal");
//        }



//        System.out.println(solution(n, arr));
    }



    public static int solution(int N, int[] arr){

        Map<Integer, Integer> freq = new HashMap<>();
        Set<Integer> uni = new HashSet<>();
        for(int i : arr){
            freq.put(i, freq.getOrDefault(i, 0)+1);
            uni.add(i);
        }

        List<Integer> list = new ArrayList<>();
        for(int i : uni) list.add(i);

        Map<Long, Long> map = new HashMap<>();

        int m = list.size();
        for(int i=0; i<m; i++){
            int cur = list.get(i);
            int a = freq.get(cur);
            if(a >= 2) map.put((long)cur*2, map.getOrDefault((long)cur*2, 0l)+(a/2));
            for(int j=i+1; j<m; j++){
                int c = freq.get(list.get(j));
                long sum = cur+list.get(j);

                int mul = (a > c) ? c : a;
                map.put(sum, map.getOrDefault(sum, 0l)+(long)1*mul);
            }
        }


        int ans = Integer.MIN_VALUE;
        for(long v : map.values()){
            ans = Math.max(ans, (int)v);
        }

        return ans;
    }

}

