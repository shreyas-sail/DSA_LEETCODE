class Solution {
    public int[] findBall(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int r = 0 ;
        int[] ans = new int[m];
        // int k = 0;
        for(int c = 0;c<m;c++){
            ans[c] = findBallHelper(r, c, n,m,grid);
        }
        // System.out.println(Collections.toString(ans));
        return ans;
    }
    
    int findBallHelper(int r, int c, int n,int m,int[][] grid){
        
        if(r == n){
            return c;
        }
        if(c < 0 || c>m-1){
            return -1;
        }
        if(c==0 && grid[r][c]==-1){
            return -1;                               ///  when ball gets stuck in first column
        }
        if(c == m-1 && grid[r][c] == 1){
            return -1;
        }
        if(c == m-1 && grid[r][c] == 1){
            return -1;
        }
        if(grid[r][c] ==1 && grid[r][c+1] == -1){
            return -1;
        }
        if(grid[r][c] == -1 && grid[r][c-1] == 1){
            return -1;
        }
        if(grid[r][c] == 1){
            return findBallHelper(r+1, c+1, n,m,grid);
        }
        return findBallHelper(r+1, c-1, n,m,grid);

    } 
}