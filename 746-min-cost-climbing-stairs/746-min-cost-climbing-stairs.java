class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        Arrays.fill(dp,-1);
        return Math.min(subSeq(0,cost.length,cost,dp),subSeq(1,cost.length,cost,dp));
    }
    
    public int subSeq(int i,int n,int[] cost,int[] dp){
        if(i>n -1){
            return 0; 
        }
        if(i == n-1 ){
            return cost[i];
        }
        if(dp[i]!= -1) return dp[i];
        return dp[i] = cost[i]+Math.min(subSeq(i+1,n,cost,dp),subSeq(i+2,n,cost,dp));
    }
}