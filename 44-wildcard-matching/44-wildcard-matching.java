class Solution {
    public boolean isMatch(String s, String p) {
        char[] s1 = s.toCharArray();
        char[] p1 = p.toCharArray();
        int i = s1.length-1;
        int j = p1.length-1;
        int[][] dp = new int[j+1][i+1];
        for(int[] d:dp)
        Arrays.fill(d,-1);
        return isMatchH(j,i,s1,p1,dp);
    }
    
    boolean isMatchH(int i,int j,char[] s1,char[] p1,int[][] dp){
        if(i<0 && j<0) return true;
        if(i<0 && j>=0) return false;
        if(j<0 && i>=0){
            for(int s = i;s>=0;s--){
                if(p1[s]!='*') return false;
            }
            return true;
        }
        if(dp[i][j] != -1) return dp[i][j] == 1?true:false;
        if(p1[i] == s1[j] || p1[i] == '?'  ) return isMatchH(i-1,j-1,s1,p1,dp);
        if(p1[i] == '*' ){
            boolean ans = isMatchH(i-1,j,s1,p1,dp) || isMatchH(i,j-1,s1,p1,dp);
            dp[i][j] = ans?1:0;
            return ans;
        }
        dp[i][j] = 0;
        return false;
    }
}