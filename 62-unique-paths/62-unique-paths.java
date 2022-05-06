class Solution {
    public int uniquePaths(int m, int n) {
        int curRow = 0,curCol = 0;
        int[][] dp = new int[m][n];
       // Arrays.fill(dp,-1);
		for (int i = 0; i < m; i++)
            Arrays.fill(dp[i],-1);
		// for (int j = 0; j < n; j++)
			// dp[i][j] = -1;
        int totalPaths = traverseRecursive(curRow,curCol,m,n,dp);
        return totalPaths;
    }
    
    public int traverseRecursive(int r,int c,int m,int n,int[][] dp){
        if(r>m-1 || c>n-1){
            return 0;
        }
        if(r == m-1 && c == n-1){
            return 1;
        }
        if (dp[r][c] != -1) return dp[r][c];
        int downWards = traverseRecursive(r+1,c,m,n,dp);
        int upWards = traverseRecursive(r,c+1,m,n,dp);
        return dp[r][c] =  downWards + upWards; 
    }
}