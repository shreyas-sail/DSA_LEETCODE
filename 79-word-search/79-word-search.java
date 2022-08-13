class Solution {
    public boolean exist(char[][] board, String word) {
        char[] wordC = word.toCharArray();
        int n = board.length;
        int m = board[0].length;
        // int m = wordC.length;
        for(int i = 0;i<n;i++){
          for(int j = 0;j<m;j++){
              if(board[i][j] == wordC[0]){
                  if(wordC.length == 1) return true;
                  if(func(i,j,n,m,0,board,wordC)) return true;
              }
        }
    }
        return false;
}
    private boolean func(int r,int c,int n,int m,int ind,char[][] board,char[] wordC){
        if(r<0 || r>n-1 || c<0 || c>m-1){
            return false;
        }
        if(ind >= wordC.length){
            return true;
        }
        if(wordC[ind] != board[r][c]){
            return false;
        }
        
        
//         if(wordC[ind] == board[r][c]){
//             ind = ind+1;

//         }
        char temp = board[r][c];
        board[r][c] = ',';
        
        boolean up = func(r-1,c,n,m,ind+1,board,wordC);
        boolean right = func(r,c+1,n,m,ind+1,board,wordC);
        boolean down = func(r+1,c,n,m,ind+1,board,wordC);
        boolean left = func(r,c-1,n,m,ind+1,board,wordC);
        board[r][c] = temp;
        return up || right || down || left;
            
    }
}
