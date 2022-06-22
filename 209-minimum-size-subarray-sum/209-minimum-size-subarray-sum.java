class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n =nums.length;
        int i = 0 ,j = 0;
        int sum = 0;
        int mini = (int)1e9;
        while(j<n){
            sum += nums[j];
            if(sum>=target){
                while(sum>=target){
                    sum-=nums[i];
                    i++;
                }
                mini = Math.min(mini,j-i+2);
            }
           j++;
            
        }
        return mini == (int)1e9?0:mini;
        
    }
}