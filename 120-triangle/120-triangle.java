class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        for(int[] row:dp)
            Arrays.fill(row,-1);
        return minimumTotalHelper(0,0,n,triangle,dp);
    }
    
    public int minimumTotalHelper(int r, int c, int n,List<List<Integer>> triangle,int[][] dp){
        if(r == n-1){
            return triangle.get(r).get(c); 
        }
        if(dp[r][c] != -1) return dp[r][c];
        int down = triangle.get(r).get(c) + minimumTotalHelper(r+1,c,n,triangle,dp);
        int downRight = triangle.get(r).get(c) + minimumTotalHelper(r+1,c+1,n,triangle,dp);            
        return dp[r][c] = Math.min(down,downRight);
    }
}