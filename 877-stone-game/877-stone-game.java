class Solution {
    int aScore = 0;
    int bScore = 0;
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int i = 0;
        int j = n-1;
        // System.out.println(stoneHelper(i,j,piles,true));
        // System.out.println(stoneHelper(i,j,piles,false));
        boolean pickFirst = stoneHelper(i,j,piles,true);
        aScore = 0;bScore = 0;
        boolean pickLast = stoneHelper(i,j,piles,false);
        return pickFirst || pickLast;
    }
    boolean stoneHelper(int i,int j,int[] piles,boolean isAliceTurn){
        if(i>j){
            // System.out.printf("%d %d\n",aScore,bScore);
            return aScore>bScore ;
        }
        
        if(isAliceTurn){
             aScore += piles[i];
        }else{
            bScore += piles[i];
        }
        boolean pickFirst = stoneHelper(i+1,j,piles,!isAliceTurn);
        return aScore>bScore ; 
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