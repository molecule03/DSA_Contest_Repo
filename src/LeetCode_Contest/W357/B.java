package LeetCode_Contest.W357;

public class B {

    public static void main(String[] args) {

        int nums[] = {2, 3, 3, 2, 3};
        int m = 5;
        System.out.println(canSplitArray(nums, m));
    }

    //    Corrected Code in Upsolve
    public static boolean canSplitArray(int[] nums, int m) {

        boolean flag = false;

        int n = nums.length;

        if(n <= 2) return true;
        for(int i=0; i<n-1; i++){
            if(nums[i]+nums[i+1] >= m){
                flag = true;
                break;
            }
        }

        return flag;
    }
}