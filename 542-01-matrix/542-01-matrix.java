class Solution {
    int[] dx = {1,-1,0,0};
    int[] dy = {0,0,1,-1};
    
    public int[][] updateMatrix(int[][] mat) {
        int n1 = mat.length;
        int n2 = mat[0].length;
        Queue<int[]> q = new LinkedList();
        for(int i =0;i<n1;i++){
            for(int j=0;j<n2;j++){
                if(mat[i][j] == 0){
                    q.offer(new int[]{i,j});
                }else{
                    mat[i][j] = Integer.MAX_VALUE;
                }
            }
        }
       int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        while (!q.isEmpty()) {
            int[] cell = q.poll();
            for (int[] d : dirs) {
                int r = cell[0] + d[0];
                int c = cell[1] + d[1];
                if (r < 0 || r >= n1 || c < 0 || c >= n2 || 
                    mat[r][c] <= mat[cell[0]][cell[1]] + 1) continue;
                q.add(new int[] {r, c});
                mat[r][c] = mat[cell[0]][cell[1]] + 1;
            }
        }
        return mat;
     }   
}