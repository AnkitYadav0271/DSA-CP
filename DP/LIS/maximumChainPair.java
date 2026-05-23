//this classic LIS Problem in 2d Array if we can talk and we can find the how to related when we 

class Solution {
    int [][] dp ;
    public int findLongestChain(int[][] pairs) {
        dp = new int [pairs.length + 1][pairs.length + 1];

        for(int row [] : dp){
            Arrays.fill(row,-1);
        }

        Arrays.sort(pairs,(a,b)->Integer.compare(a[0],b[0]));

        return solve(pairs,0,-1);




    }

    public int solve (int arr[][] , int currIndex , int prevIndex){
        if(currIndex >= arr.length){
            return 0;
        }

        if(dp[currIndex][prevIndex + 1] != -1) {
            return dp[currIndex][prevIndex + 1];
        }

        int take = 0;

        if(prevIndex == - 1 || arr[prevIndex][1] < arr[currIndex][0]){
            take = 1 + solve(arr,currIndex + 1, currIndex);
        }

        

        int skip = solve(arr,currIndex + 1, prevIndex);

        return dp[currIndex][prevIndex + 1] =  Math.max(take,skip);
    }
}