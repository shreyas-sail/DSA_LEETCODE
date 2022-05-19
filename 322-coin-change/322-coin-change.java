class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp =new int[coins.length][amount+1];
        for(int[] row:dp) Arrays.fill(row,-1);
        int ans = coinChangesHelper(coins.length -1,coins,amount,dp);
        return  ans >= (int)1e9?-1:ans;
    }
    
    public int coinChangesHelper(int index,int[] coins, int amount,int[][] dp){
        //if(amount == 0) return 1;
        if(index == 0){
            if(amount%coins[index] == 0) return amount/coins[index];
            return (int) 1e9;
        }
        if(dp[index][amount] != -1) return dp[index][amount];
        int notPick = 0+coinChangesHelper(index-1,coins,amount,dp);
        int pick = (int) 1e9;
        if(coins[index]<=amount){
            pick = 1+coinChangesHelper(index,coins,amount - coins[index],dp);
        }
        return dp[index][amount] = Math.min(notPick,pick);
    }
}