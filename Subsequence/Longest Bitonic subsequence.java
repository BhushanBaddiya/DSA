package DSA.Subsequence;

// https://practice.geeksforgeeks.org/problems/longest-bitonic-subsequence0824/1
class Solution
{
    public int LongestBitonicSequence(int[] nums)
    {
          int n = nums.length;
          int [] dp_l2r = new int [n];
          dp_l2r[0] = 1;
          for(int i = 1; i < n; i++){
              int bestofprev = 0;
              for(int j = i-1; j >= 0; j--){
                  if(nums[j] < nums[i]){
                      bestofprev = Math.max(bestofprev,dp_l2r[j]);
                  }
              }
              dp_l2r[i] = bestofprev + 1;
          }
          int [] dp_r2l = new int [n];
          dp_r2l[n-1] = 1;
          for(int i = n-2; i >= 0; i--){
              int bestofprev = 0;
              for(int j = i+1; j < n; j++){
                  if(nums[j] < nums[i]){
                      bestofprev = Math.max(bestofprev,dp_r2l[j]);
                  }
              }
              dp_r2l[i] = bestofprev+1;
          }
          int maxi = 0;
          for(int i = 0; i < n; i++){
              int left = dp_l2r[i];
              int right = dp_r2l[i];
              int length = left+right-1;
              maxi = Math.max(length,maxi);
          }
          return maxi;
    }
}
