package LeetCode_Contest.W336;

import java.util.HashMap;
import java.util.Map;

public class C {

    public static void main(String[] args) {

        int nums[] ={4,3,1,2,4};
        System.out.println(beautifulSubarrays(nums));
    }

    public static long beautifulSubarrays(int[] nums) {

        long res = 0;
        long sum = 0;
        Map<Long, Long> map = new HashMap<>();
        long ans = 0l;
        for(int i=0; i<nums.length; i++){
            ans += map.getOrDefault(i, 0l);
        }
        map.put(ans, 1l);
        for(int i=0; i<nums.length; i++){
            sum ^= nums[i];
            res += map.getOrDefault(sum, 0l);
            map.put(sum, map.getOrDefault(sum, 0l)+1l);
        }
        return res;
    }
}
