//https://leetcode.com/problems/min-cost-climbing-stairs/?envType=daily-question&envId=2023-10-13
class Solution {
    public int recur(int[] cost,int i){
        
        if(i == cost.length){
            return 0;
        }
        if(i > cost.length){
            return Integer.MAX_VALUE;
        }
       int c1 = recur(cost,i+1);
       int c2 = recur(cost,i+2);
       return Math.min(c1,c2)+cost[i];
    }

    public int memo(int [] cost,int[] dp,int i){
          
        if(i == cost.length){
            return 0;
        }
        if(i > cost.length){
            return Integer.MAX_VALUE;
        }
        if(dp[i] != -1){
            return dp[i];
        }
       int c1 = memo(cost,dp,i+1);
       int c2 =  memo(cost,dp,i+2);
       dp[i] = Math.min(c1,c2) + cost[i];
       return Math.min(c1,c2)+cost[i];
    }

    public int tabulation(int [] cost,int[] dp){
        for(int i = cost.length-1; i >= 0; i--){
                // if(i == cost.length){
                //     return 0;
                // }
                // if(i > cost.length){
                //     return Integer.MAX_VALUE;
                // }
                 
       int c1 = i+1 == cost.length ? 0 :dp[i+1];//memo(cost,dp,i+1);
       int c2;//memo(cost,dp,i+2);
       if(i+2 == cost.length){
         c2 = 0;
       }else if(i+2 > cost.length){
           c2 = Integer.MAX_VALUE;
       }else{
           c2 = dp[i+2];
       }
       dp[i] = Math.min(c1,c2) + cost[i];
      
        }
        return Math.min(dp[0],dp[1]);
    }

    public int spaceopti(int[] cost){
        //If im standing on ith index, I only want to access the (i+1)th and (i+2)th index answers
        //The variables "ip1" and "ip2" will be remembering the answer to (i+1)th and (i+2)th indexes
        int ip1 = 0;                                
        int ip2 = Integer.MAX_VALUE;
        for(int i = cost.length-1;i>=0;i--){
            int curr = Math.min(ip1,ip2) + cost[i];//Calculating the answer for current Index
            //Moving Ip2 and Ip1 backwards
            ip2 = ip1;
            ip1 = curr;
        }
        //In the end, Ip1 will be having the answer to 0th index,
        //and Ip2 will be having the answer to 1th index, return the min of them
        return Math.min(ip1,ip2);  
    }
    public int minCostClimbingStairs(int[] cost) {
        //You can either start from the step with index 0, or the step with index 1.
       //return Math.min(recur(cost,0),recur(cost,1));
      // int[] dp = new int[cost.length+1];
      // Arrays.fill(dp,-1);
      // return Math.min(memo(cost,dp,0),memo(cost,dp,1));
       // return tabulation(cost,dp);
       return spaceopti(cost);


    }
}