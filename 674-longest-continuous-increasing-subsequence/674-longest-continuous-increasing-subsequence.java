class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int maxLen = 1;
        int curLen = 1;
        for(int i = 0;i<nums.length-1;i++){
            if(nums[i] < nums[i+1]){
                curLen += 1;
            }else{
                curLen = 1;
            }
            maxLen = Math.max(maxLen,curLen);
        }
        return maxLen;
    }
}