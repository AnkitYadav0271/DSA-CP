import java.util.Arrays;

//problem statement =>

//You are given a balloons from 0 to n-1 and array cost which cost = [1,3.....n-1];
// if we burst ith balloon then we will get arr[i-1] * arr[i] * arr[i+1] coins.
//Problem is to maximize coin we are earning

//After a lot of observation i found that it is classical mcm problem so solved using that thankyou


class Solution {
    static int[][] dp;

    public int maxCoins(int[] nums) {
        int n = nums.length;
        
        // creating an array to avoid if else condition
        int[] arr = new int[n + 2];
        arr[0] = 1;
        arr[n + 1] = 1;
        for (int i = 0; i < n; i++) {
            arr[i + 1] = nums[i];
        }

        // table with 2 more values to stay safe
        dp = new int[n + 2][n + 2];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        // calling our solve function ?
        return solve(arr, 1, n);
    }

    public static int solve(int[] arr, int i, int j) {
        // Base case: no balloons left to burst
        if (i > j) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int max = Integer.MIN_VALUE;

        // k represents the LAST balloon to burst in the current subproblem [i...j]
        for (int k = i; k <= j; k++) {
            int tempAns = solve(arr, i, k - 1) 
                        + solve(arr, k + 1, j) 
                        + arr[i - 1] * arr[k] * arr[j + 1]; 
            
            if (max < tempAns) {
                max = tempAns;
            }
        }

        
        return dp[i][j] = max;
    }
}