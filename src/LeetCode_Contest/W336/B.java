package LeetCode_Contest.W336;

import java.util.Arrays;

public class B {
    public static void main(String[] args) {

        int nums[] = {2,-1,0,1,-3,3,-3};
        System.out.println(maxScore(nums));
    }

    public static int maxScore(int[] nums) {

        // Arrays.sort(nums, (a,b)->b-a);
        Arrays.sort(nums);
        // System.out.println(Arrays.toString(nums));

        int max = 0;
        long sum = 0;
        int n = nums.length;
        for(int i=n-1; i>=0; i--){
            sum += nums[i];
            if(sum > 0) max++;
        }

        return max;
    }
}
