class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n][m];
        for(int[] ar:dp )Arrays.fill(ar,-1);
        return countDis(word1.toCharArray(),word2.toCharArray(),0,0,n,m,dp);
    }
    int countDis(char[] w1,char[] w2,int i,int j,int n,int m,int[][] dp){
        if(i == n && j == m) return 0;
        if(i == n || j == m) return Math.max(n-i,m-j);
        if(dp[i][j] != -1) return dp[i][j] ;
        if(w1[i] == w2[j]) {
            return dp[i][j] = countDis(w1,w2,i+1,j+1,n,m,dp);
        }
        int left = 1 + countDis(w1,w2,i+1,j,n,m,dp);
        int right = 1+ countDis(w1,w2,i,j+1,n,m,dp);
        return dp[i][j] = Math.min(left,right); 
    }
}