package DSA.Subsequence;

 class Solution {
    public int recur(int [] nums,int idx,int next){
        if(idx < 0){
            return 0;
        }
        int exc = recur(nums,idx-1,next);
        int inc = 0;
        if(next == nums.length || nums[idx] < nums[next]){
           inc = recur(nums,idx-1,idx) +1;
        }
        return Math.max(inc,exc);
    }
     public int memo(int [] nums,int idx,int next,int [][] dp){
        if(idx < 0){
            return 0;
        }
        if(dp[idx][next] != 0){
            return dp[idx][next];
        }
        int exc = memo(nums,idx-1,next,dp);
        int inc = 0;
        if(next == nums.length || nums[idx] < nums[next]){
           inc = memo(nums,idx-1,idx,dp) +1;
        }
        return dp[idx][next] = Math.max(inc,exc);
    }
    public int tabulation(int [] nums,int [] dp){
        int n = dp.length;
        for(int i = 0; i < n; i++){
            int maxofprev = 0;
            for(int j = i-1; j >= 0; j--){
                if(nums[i] >  nums[j]){
                  maxofprev = Math.max(maxofprev,dp[j]);
                }
             }
            dp[i] = maxofprev +1;
        }
        int maxi = 0;
        for(int i = 0; i < n; i++){
            maxi = Math.max(maxi,dp[i]);
        }
        return maxi;
    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
       // int [][] dp = new int [n+1][n+1];
        int [] dp  = new int[n];
      // return recur(nums,n-1,n);
      // return memo(nums,n-1,n,dp);
      return tabulation(nums,dp);
    }
}
