package LeetCode_Contest.W313;

public class B {
    public static void main(String[] args) {


        int [][] grid ={{6,2,1,3},{4,2,1,5},{9,2,8,7},{4,1,2,9}} ;
        System.out.println(maxSum(grid));
    }

    public static int maxSum(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        int max = 0;
        int sum = 0;

        for(int i=1; i<n-1; i++){
            for(int j=1; j<m-1; j++){
                sum = 0;

                sum += grid[i-1][j-1];
                sum += grid[i-1][j];
                sum += grid[i-1][j+1];
                sum += grid[i][j];
                sum += grid[i+1][j-1];
                sum += grid[i+1][j];
                sum += grid[i+1][j+1];

                max = Math.max(max, sum);
            }

        }

        return max;
    }

}
