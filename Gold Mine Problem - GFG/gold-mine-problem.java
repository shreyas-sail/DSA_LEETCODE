// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String inline[] = in.readLine().trim().split("\\s+");
            int n = Integer.parseInt(inline[0]);
            int m = Integer.parseInt(inline[1]);
            String inline1[] = in.readLine().trim().split("\\s+");
            int M[][] = new int[n][m];
            for(int i = 0;i < n*m;i++){
                M[i/m][i%m] = Integer.parseInt(inline1[i]);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.maxGold(n, m, M));
        }
    }
} // } Driver Code Ends


//User function Template for Java

class Solution{
    static int maxGold(int n, int m, int M[][])
    {
        // code here
        int maxi = 0;
        int[][] dp =  new int[n][m];
        for(int[] i:dp) Arrays.fill(i,-1);
        for(int i = 0;i<n;i++){
            maxi = Math.max(maxi,maxGoldFinder(i,0,n,m,M,dp));
        }
        return maxi;
    }
    
    static int maxGoldFinder(int r,int c,int n,int m,int[][] M,int[][] dp){
        if(r>=n || r<0 || c>=m){
            return (int) -1e9;
        }
        if(c == m -1){
            return M[r][c];
        }
        if(dp[r][c] != -1) return dp[r][c];
        int right     =     M[r][c] + maxGoldFinder(r,c+1,n,m,M,dp);
        int rightTop  =     M[r][c] + maxGoldFinder(r-1,c+1,n,m,M,dp);
        int rightDown =     M[r][c] + maxGoldFinder(r+1,c+1,n,m,M,dp);
        
        return dp[r][c] = Math.max(right,Math.max(rightTop,rightDown));
    }
}