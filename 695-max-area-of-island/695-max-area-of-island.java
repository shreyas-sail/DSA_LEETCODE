class Pair{
    int x;
    int y;
    public Pair(int x, int y){
        this.x =x;
        this.y =y;
    }
}

class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if(grid == null || grid.length == 0)
            return 0;
        
        int m = grid.length, n = grid[0].length;
        int maxIsland = Integer.MIN_VALUE;
        for(int i = 0; i < m; i++) {
             for(int j = 0; j < n; j++) {
                int count = 0;
                if(grid[i][j] == 1) {
                    grid[i][j] = 0;
                    count = bfs(grid, i, j);
                    System.out.println(count);
                }
                maxIsland = Math.max(maxIsland, count);
            }
        }
        return maxIsland;
    }
    
   public int bfs(int[][] image, int sr, int sc){
       Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(sr,sc));
        int count = 0;
        int oldColor = 1;
        while(!q.isEmpty()){
            Pair p = q.poll();
            int curX = p.x;
            int curY = p.y;
            image[curX][curY] =-1;
            count++;
            if(curY>0 && image[curX][curY-1] == oldColor){
                    q.offer(new Pair(curX,curY-1));
                    image[curX][curY-1] =-1;
            }
            if(curY!=image[0].length-1 && image[curX][curY+1] == oldColor){
                    q.offer(new Pair(curX,curY+1));
                    image[curX][curY+1] =-1;
            }
            if(curX>0  && image[curX-1][curY] == oldColor){
                    q.offer(new Pair(curX-1,curY));
                    image[curX-1][curY] =-1;
            }
            if(curX!=image.length-1 && image[curX+1][curY] == oldColor){
                    q.offer(new Pair(curX+1,curY));
                    image[curX+1][curY] =-1;
            }
        }
        return count;
   }
}