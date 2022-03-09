class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int l = 0,count = 0;
        int ans = 0;
        while(l<nums.length){
            if(nums[l] == 1){
                count +=1 ;
                ans = Math.max(ans,count);
            }else{
                count =0;
            }
            l++;
        }
        return ans;
    }
}