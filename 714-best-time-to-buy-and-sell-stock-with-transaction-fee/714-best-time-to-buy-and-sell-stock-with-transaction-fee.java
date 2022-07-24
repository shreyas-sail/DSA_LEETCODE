class Solution {
    public int maxProfit(int[] prices, int fee) {
        // System.out.println(localMinima(5,prices));
        int[][] dp = new int[prices.length][2];
        for(int[] d:dp) Arrays.fill(d,-1);
        return maxProfitHelper(0,prices,1, fee,dp);
    //return 0;
    }
    
    int maxProfitHelper(int index,int[] prices,int buy, int fee,int[][] dp){
        if(index >= prices.length){
            return 0;
        }
        if(dp[index][buy] != -1) return dp[index][buy];
        int profit = 0;
        if(buy == 1){
            int buyStock = -prices[index] + maxProfitHelper(index+1,prices,0, fee,dp);
            int notBuy =  maxProfitHelper(index+1,prices,1, fee,dp);
            profit = Math.max(buyStock,notBuy);
        }else{
            int sell = prices[index] - fee + maxProfitHelper(index+1,prices,1,fee,dp);
            int notSell =  maxProfitHelper(index+1,prices,0,fee,dp);
            profit = Math.max(sell,notSell);
        }
        return dp[index][buy] = profit;
    }
}