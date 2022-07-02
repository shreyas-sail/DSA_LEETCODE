class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        // int MOD = (int)1e9 + 7;
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        
        int n1 = horizontalCuts.length;
        int n2 = verticalCuts.length;
        long maxiH = horizontalCuts[0];
        long maxiV = verticalCuts[0];
        for(int i = 1;i<=n1;i++){
            if( n1 == i ){
                maxiH = Math.max(maxiH, h - horizontalCuts[i-1]);
            }else{
                maxiH = Math.max(maxiH,horizontalCuts[i] - horizontalCuts[i-1]);
            }
        }
        
        for(int i = 1;i<=n2;i++){
            if( n2 == i ){
                maxiV = Math.max(maxiV, w - verticalCuts[i-1]);
            }else{
                maxiV = Math.max(maxiV,verticalCuts[i] - verticalCuts[i-1]);
            }
        }
        //System.out.printf("%d %d",maxiH%MOD,maxiV%MOD);
        //System.out.println("%d",(int)((maxiH * maxiV) % 1000000007));
        return (int)((maxiH * maxiV) % 1000000007);
    }
}