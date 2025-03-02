package LeetCode_Contest.W354;

public class A {

    public static void main(String[] args) {

        int nums[] ={1,3,6,3,1,2};
        int target = 2;
        System.out.println(sumOfSquares(nums));
    }

    //    Corrected Code in Upsolve
    public static int sumOfSquares(int[] nums) {

        int mod = (int) (1e9+7);
        int n = nums.length;
        long sum = 0;

        for(int i=0; i<n; i++){
            if(n%(i+1) == 0){
                sum += (nums[i]*nums[i]);
            }
            // System.out.println(sum);
        }

        return (int)sum%mod;
    }
}