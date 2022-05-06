class Solution {
    public int minPathSum(int[][] grid) {
       int m = grid.length;
       int n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int i =0;i<m;i++)
            Arrays.fill(dp[i],-1);
       int totalPaths = traversRecursively(0,0,m,n,grid,dp);
        return totalPaths;
    }
    
    public int traversRecursively(int r,int c,int m,int n,int[][] grid,int[][] dp) {
        if(r>m-1 || c>n-1){
            return (int)1e9;
        }
        if(r == m-1 && c == n-1){
            return grid[r][c];
        }
        if(dp[r][c]!=-1) return dp[r][c];
        int down = grid[r][c] + traversRecursively(r+1,c,m,n,grid,dp);
        int right = grid[r][c] + traversRecursively(r,c+1,m,n,grid,dp);
        // System.out.println(down);
        // System.out.println(right);
        
        return dp[r][c] = Math.min(right,down);
    }
}