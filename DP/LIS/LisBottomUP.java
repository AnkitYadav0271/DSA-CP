

class Solution {
    int dp [];
    public int lengthOfLIS(int[] nums) {
        dp = new int[nums.length + 1];
        Arrays.fill(dp,1);
        int max = 1;

        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                  dp[i] = Math.max(dp[i],dp[j] + 1);
                  max = Math.max(dp[i],max);
                }
               
            }
        }

        return max;
    }
}