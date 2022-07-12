class Solution {
    int[] side = new int[4]; 
    public boolean makesquare(int[] matchsticks) {
        if (matchsticks == null || matchsticks.length < 4) return false;
        int sum = 0;
        for(int i:matchsticks)
            sum+=i;
        if(sum % 4 != 0) return false;
        int sideLen = sum/4;
        Arrays.sort(matchsticks);
        reverse(matchsticks);
        return backtrack(0,matchsticks,matchsticks.length,sideLen);
    }
    
    boolean backtrack(int i,int[] matchsticks,int n,int sideLen ){
        if(i == n) return true;
        for(int j = 0 ;j<4;j++){
            if(side[j] + matchsticks[i]<=sideLen){
                side[j] += matchsticks[i];
                if(backtrack(i+1,matchsticks,n,sideLen)){
                    return true;
                }else{
                    side[j] -= matchsticks[i];
                }
            }
        }
        
        return false;
    }
    
    private void reverse(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++; j--;
        }
    }
}