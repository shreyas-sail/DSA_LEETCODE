class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(grid[i][j] == '1'){
                    markIsland(i,j,grid);
                    count++;
                }
            }
        }
        return count;
    }
    
    private void markIsland(int i ,int j,char[][] grid){
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i,j});
        char assign = 'a';
        while(!q.isEmpty()){
            int[] p = q.poll();
            grid[p[0]][p[1]] = assign;
            for(int z=0;z<4;z++){
                int nx = p[0]+dx[z];
                int ny = p[1]+dy[z];
                
                if(nx<0 || ny <0 || nx>grid.length-1 || ny>grid[0].length-1 || grid[nx][ny] != '1'){
                    continue;
                }
                q.offer(new int[]{nx,ny});
                grid[nx][ny] = assign;
            }
        }
    }
}