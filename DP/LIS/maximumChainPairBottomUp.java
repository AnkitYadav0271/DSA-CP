//leet code 646


class Solution {
    int [] dp ;
    public int findLongestChain(int[][] pairs) {
        dp = new int [pairs.length + 1];

        Arrays.fill(dp,1);
        Arrays.sort(pairs,(a,b)->Integer.compare(a[0],b[0]));

        int max = 1;

        for(int i = 0; i < pairs.length; i++){
            for(int j = 0; j < i; j++){
                if(pairs[j][1] < pairs[i][0]){
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                    max = Math.max(max,dp[i]);
                }
            }
        }

        return max;




    }

   
}