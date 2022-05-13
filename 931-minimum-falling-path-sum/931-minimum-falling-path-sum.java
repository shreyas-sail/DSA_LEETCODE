class Solution {
    public int minFallingPathSum(int[][] matrix) {
        if(matrix.length == 0) return 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int mimi = (int) 1e9;
        int [][] dp  = new int[row][col];
        for(int j = 0 ;j<row;j++){
            Arrays.fill(dp[j],-1);
        }
        for(int i = 0;i<matrix[0].length;i++)
            mimi = Math.min(mimi , minFallingPathSumHelper(0,i,row,col,matrix,dp));
        return mimi;
    }
    public int minFallingPathSumHelper(int r,int c,int row,int col,int[][] matrix,int[][] dp){
        if(c > col -1 || c<0){
            return (int) 1e9;
        }
        if(r == row-1){
            return matrix[r][c];
        }
        if(dp[r][c] != -1) return dp[r][c];
        int down = matrix[r][c]+ minFallingPathSumHelper(r+1,c,row,col,matrix,dp);
        int left = matrix[r][c]+ minFallingPathSumHelper(r+1,c-1,row,col,matrix,dp);
        int right = matrix[r][c]+ minFallingPathSumHelper(r+1,c+1,row,col,matrix,dp);
        
        return dp[r][c] = Math.min(down,Math.min(left,right));
    }
}