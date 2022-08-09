class Solution {
    public int getMaximumGold(int[][] grid) {
        int m = grid.length , n = grid[0].length;
        int maxi = 0;
		for (int i = 0; i < m; i++){
            for(int j = 0;j<n;j++){
                if(grid[i][j]!=0)
                maxi = Math.max(maxi,traverseRecursive(i,j,m,n,grid));
            }
        }
        return maxi;
    }
    
    public int traverseRecursive(int r,int c,int m,int n,int[][] grid){
        if(r>m-1 || c>n-1){
            // System.out.println(1);
            return 0;
        }
        if(r<0 || c<0){
            // System.out.println(2);
            return 0;
        }
        if(grid[r][c]==0){
            // System.out.println(3);
            return 0;
        }
        int temp = grid[r][c];
        grid[r][c] = 0;
        int upWards = temp+traverseRecursive(r-1,c,m,n,grid);
        int rightWards = temp+ traverseRecursive(r,c+1,m,n,grid);
        int downWards = temp+ traverseRecursive(r+1,c,m,n,grid);
        int leftWards = temp+ traverseRecursive(r,c-1,m,n,grid);
        int upDown = Math.max(upWards,downWards);
        int rightLeft = Math.max(rightWards,leftWards);
        grid[r][c] = temp;
        return Math.max(upDown,rightLeft);
    }
}