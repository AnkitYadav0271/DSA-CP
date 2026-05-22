import java.util.Arrays;

//let arr = [14,5,62,4,3,7]
class LisRec {
    int  dp [][];
    public static Lis (int [] nums){
        dp = new int [nums.length + 1][nums.length + 1];

        for(int []row : dp){
            Arrays.fill(row,-1);
        }

        return solve(nums,0,-1);
    }

    public int solve(int arr[] , int currIndex , int prevIndex){
        if(currIndex >= arr.length){
            return 0;
        }

        if(dp[currIndex][prevIndex + 1] != -1){
            return dp[currIndex][prevIndex+1];
        }

        int take = 0;

        if(prevIndex == -1 || arr[prevIndex] < arr[currIndex]){
            take = 1 + solve(arr, currIndex+ 1, i);
        }

        int skip = solve(arr,currIndex + 1, prevIndex);

        return dp[currIndex][prevIndex + 1] = Math.max(skip,take); 
    }
}