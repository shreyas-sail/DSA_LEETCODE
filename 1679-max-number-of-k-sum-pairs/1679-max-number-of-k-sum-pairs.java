class Solution {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int i =0;
        int j = nums.length-1;
        int n = nums.length;
        int count = 0;
        //[1,3,3,3,4] = 6
        while(i<j){
           if(nums[i]+nums[j] == k){
               count++;
               i++;j--;
           } else if(nums[i]+nums[j]>k){
               j--;
           }else{
               i++;
           }
        }
        return count;
    }
}