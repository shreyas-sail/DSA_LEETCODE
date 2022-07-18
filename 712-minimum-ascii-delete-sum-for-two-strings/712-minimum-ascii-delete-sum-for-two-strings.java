class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int n1 = s1.length(),n2 = s2.length();
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
//         HashSet<Character> c1Set = new HashSet<>();
//         HashSet<Character> c2Set = new HashSet<>();

//         for(Character c:c2){
//           c2Set.add(c);  
//         }
//         for(Character c:c1){
//           c1Set.add(c);  
//         }
        int[][] dp = new int[n1][n2];
        for(int[] d:dp) Arrays.fill(d,-1);
        return sumOfAscii(n1-1,n2-1,c1,c2,dp);
    }
    
    private int sumOfAscii(int i,int j,char[] c1,char[] c2,int[][] dp){
        if(j<0){
           int delVal = 0;
           for(int it = i;it>=0;it--){
               delVal += c1[it];
           } 
            return delVal;
        }
        if(i<0){
           int delVal = 0;
           for(int it = j;it>=0;it--){
               delVal += c2[it];
           } 
            return delVal; 
        }
        if(dp[i][j] != -1) return dp[i][j];
        if(c1[i] == c2[j]){
            return sumOfAscii(i-1,j-1,c1,c2,dp);
        }
        int doDel = (int) 1e9;
        int dontDel = (int) 1e9;
        doDel = (int)c1[i] + sumOfAscii(i-1,j,c1,c2,dp); 
        dontDel =(int)c2[j] + sumOfAscii(i,j-1,c1,c2,dp);
        return dp[i][j] = Math.min(doDel,dontDel);
    }
}