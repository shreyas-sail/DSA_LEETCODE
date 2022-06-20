class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp =new int[coins.length][amount+1];
        for(int[] row:dp) Arrays.fill(row,-1);
        int ans = coinChangesHelper(coins.length -1,coins,amount,dp);
        System.out.println(ans >= (int)1e9);
        return  ans ;
    }
    
    public int coinChangesHelper(int index,int[] coins, int amount,int[][] dp){
        //if(amount == 0) return 1;
        if(index == 0){
            if(amount%coins[index] == 0) return 1;
            return 0;
        }
        if(dp[index][amount] != -1) return dp[index][amount];
        int notPick = 0+coinChangesHelper(index-1,coins,amount,dp);
        int pick = 0;
        if(coins[index]<=amount){
            pick = coinChangesHelper(index,coins,amount - coins[index],dp);
        }
        return dp[index][amount] = notPick+pick;
    }
}