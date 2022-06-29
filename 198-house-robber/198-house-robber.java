class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,-1);
        return robHelper(nums.length -1,nums,dp);
    }
    int robHelper(int i,int [] nums,int[] dp){
        if(i == 0){
            return nums[0];
        }
        if(i<0) return 0;
        if(dp[i] != -1) return dp[i]; 
        int notTake = robHelper(i-1,nums,dp);
        int take = Integer.MIN_VALUE;
        take = nums[i] + robHelper(i-2,nums,dp);
        return dp[i] = Math.max(notTake,take);
    }
}