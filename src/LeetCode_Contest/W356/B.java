package LeetCode_Contest.W356;


import java.util.HashSet;
import java.util.Set;

public class B {

    public static void main(String[] args) {

        int nums[] ={1,3,1,2,2};
        int target = 2;
        System.out.println(countCompleteSubarrays(nums));
    }

    //    Corrected Code in Upsolve

    public static int countCompleteSubarrays(int[] nums) {

        Set<Integer> set = new HashSet<>();
        for(int n : nums){
            set.add(n);
        }

        int n = nums.length;
        int count = 0;
        for(int i=0; i<n; i++){
            Set<Integer> cur = new HashSet<>();
            for(int j=i; j<n; j++){
                cur.add(nums[j]);
                if(cur.size() == set.size()) count++;
            }
        }

        return count;
    }
}