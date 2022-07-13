class Solution {
    int aScore = 0;
    int bScore = 0;
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int i = 0;
        int j = n-1;
        int[][] dp = new int[n][n];
        for(int[] d:dp)
        Arrays.fill(d,-1);
        boolean pickFirst = stoneHelper(i,j,piles,true,dp);
        aScore = 0;bScore = 0;
        for(int[] d:dp)
        Arrays.fill(d,-1);
        boolean pickLast = stoneHelper(i,j,piles,false,dp);
        return pickFirst || pickLast;
    }
    boolean stoneHelper(int i,int j,int[] piles,boolean isAliceTurn,int[][] dp){
        if(i>j){
            return aScore>bScore ;
        }
        if(dp[i][j] !=-1) return dp[i][j] == 1;
        if(isAliceTurn){
             aScore += piles[i];
        }else{
            bScore += piles[i];
        }
        boolean pickFirst = stoneHelper(i+1,j,piles,!isAliceTurn,dp);
        dp[i][j] = aScore>bScore?1:0;
        return dp[i][j] == 1 ; 
    }
    
    
}







//  while(i<j){
//             if(piles[i] == piles[j]){
//                 if(piles[i+1]>=piles[j-1]){
//                     incrementScore(piles[j--],isAlicesTurn);
//                 }else{
//                     incrementScore(piles[i++],isAlicesTurn);
//                 }
//             }else if(piles[i] > piles[j]){
//                 incrementScore(piles[i++],isAlicesTurn);
//             }else{
//                 incrementScore(piles[j--],isAlicesTurn);
//             }
//             isAlicesTurn = !isAlicesTurn;
//         }
//         System.out.printf("%d %d",aScore,bScore);
//         return aScore>bScore;
//     }
    
//     void incrementScore(int score,boolean isAlicesTurn ){
//         if(isAlicesTurn){
//             aScore+=score;
//         }else{
//             bScore+=score;
//         }
//     }