class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if(obstacleGrid[0][0] == 1 || obstacleGrid[m-1][n-1] == 1){
            return 0;
        }
        int[][] dp = new int[m][n];
        for(int i =0;i<m;i++)
            Arrays.fill(dp[i],-1);
        int totalPaths = uniquePathHelper(0,0,m,n,obstacleGrid,dp);
        return totalPaths;
    }
    
    public int uniquePathHelper(int row,int col,int m ,int n,int[][] obstacleGrid,int[][] dp){
       if(row == m-1 && col == n-1){
           return 1;
       }
        
        if(row >=m || col >=n){
            return 0;
        }
        
        if(obstacleGrid[row][col] == 1){
            return 0;
        }
        
        if(dp[row][col] != -1) return dp[row][col];
        
        int downwards = uniquePathHelper(row+1,col,m,n,obstacleGrid,dp);
        int rightwards = uniquePathHelper(row,col+1,m,n,obstacleGrid,dp);
        
        return dp[row][col] = downwards+rightwards;
    }
}


 // // [        [0,0,0]
 //             [0,0,0]
 //             [0,0,0] ] m-1,n-1