class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int totSum = 0;
        for(int i = 0 ;i<n;i++){
            totSum+=nums[i];
        }
        if(totSum%2 == 1) return false;
        int target =totSum/2;
        int[][] dp =new int[n][target+1];
        for(int[] row:dp)
            Arrays.fill(row,-1);
        return subsetSum(n-1,nums,target,dp);
    }
    
    public boolean subsetSum(int index,int[] nums,int target,int[][] dp){
        if(index == 0){
            if(nums[index] == target) return true;
            return false;
        }
        if(dp[index][target] !=-1) return dp[index][target] == 1?true:false;
        boolean pick = false;
        boolean notPick =  subsetSum(index -1,nums,target,dp);
        if(nums[index]<= target){
            pick = subsetSum(index -1,nums,target - nums[index],dp);
        }
        dp[index][target] = pick || notPick?1:0;
        return pick || notPick;
    }
}