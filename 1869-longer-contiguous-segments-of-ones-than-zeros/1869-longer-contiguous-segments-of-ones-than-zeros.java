class Solution {
    public boolean checkZeroOnes(String s) {
        char[] c = s.toCharArray();
        int maxiOne = 0;
        int maxiZero = 0;
        int curOne = 0;
        int curZero = 0;
        for(int i =0;i<c.length;i++){
            if(c[i] == '1'){
               curOne +=1;
               curZero  = 0;
            }else{
                curZero +=1;
                curOne  = 0;
            }
            maxiOne = Math.max(maxiOne,curOne);
            maxiZero = Math.max(maxiZero,curZero);
        }
        
        return maxiOne>maxiZero;
    }
}