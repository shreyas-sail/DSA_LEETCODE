class Solution {
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n+1][m+1];
        int ans = 0;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(matrix[i][j] == '1'){
                    dp[i+1][j+1] = 1+Math.min(Math.min(dp[i+1][j],dp[i][j]),dp[i][j+1]);
                    ans = Math.max(ans,dp[i+1][j+1]);
                }
            }
        }
        // for(int[] d:dp) System.out.println(Arrays.toString(d));
        return ans*ans;
        
    }
}