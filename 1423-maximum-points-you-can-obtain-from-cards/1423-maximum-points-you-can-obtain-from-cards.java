class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int[] prefix = new int[n];
        int score = 0;
        prefix[0] = cardPoints[0];
        for(int i = 1;i<n;i++){
            prefix[i] = cardPoints[i]+prefix[i-1];
        }
        int greaterScore = prefix[k-1];
        
        int i = 1;
        while(i<=k){
            // System.out.print(k-1-i);
            // System.out.println(n-1-i);
            if(k-1-i !=-1){
                greaterScore = Math.max(greaterScore,prefix[k-1-i]+(prefix[n-1]-prefix[n-1-i]));
            }else if(n-1-i == -1){
                greaterScore = Math.max(greaterScore,prefix[n-1]);
            }
            else{
                greaterScore = Math.max(greaterScore,(prefix[n-1]-prefix[n-1-i]));
            }
            i++;
        }
        return greaterScore;
    }
}