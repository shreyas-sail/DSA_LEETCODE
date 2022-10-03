class Solution {
    private int mod = (int)(1e9 + 7);
    public int numRollsToTarget(int n, int k, int target) {
        return (int)numRolls(n, k, target, new Long[target + 1][n + 1]);
    }
    
    private long numRolls(int n, int k, int target, Long[][] dp) {
		// Base Cases
        if(target == 0 && n == 0) {
            return 1;
        } else if(target < 0 || n < 0) {
            return 0;
        }
        
        if(dp[target][n] != null) return dp[target][n];
        
        long possibleWays = 0;
        
		// K possibilities on every dice 
		for(int i = 1; i <= k; i++) {
            possibleWays = (possibleWays + numRolls(n - 1, k, target - i, dp)) % mod;
        }
        
        return dp[target][n] = possibleWays;
    }
}