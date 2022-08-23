class Solution {
    public int numTilings(int n) {
        int mod = (int)1e9  + 7;
        long[] dp =  new long[1001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 5;
        // Syste
        if(n<=3) return (int)dp[n];
        
        for(int i = 4; i<=n; i++){
            dp[i] = 2 * dp[i-1]+dp[i-3];
            dp[i] %= mod;
        }
        
        return (int)dp[n];
    }
}


// S