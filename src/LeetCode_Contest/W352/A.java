package LeetCode_Contest.W352;

public class A {

    public static void main(String[] args) {

        int nums[] ={2,3,4,5};
        int thres = 4;
        System.out.println(longestAlternatingSubarray(nums, thres));
    }

    public static int longestAlternatingSubarray(int[] nums, int threshold) {

        int n = nums.length;
        int max = Integer.MIN_VALUE;

        int start = 0;

        for (int end = 0; end < n; end++) {

            if (nums[end] > threshold || (end > 0 && nums[end] % 2 == nums[end - 1] % 2)) {
                start = end;
            }

            // If the start of the window is an odd number, move it to the right
            while (start < nums.length && nums[start] % 2 != 0) {
                start++;
            }

            // Update the maximum length
            if (nums[start] % 2 == 0 && nums[start] <= threshold) {
                max = Math.max(max, end - start + 1);
            }
        }

        return max;
    }
}
