class Solution {
    public void moveZeroes(int[] nums) {
        if(nums.length<=1) return;
        int l =0,r =1;
        while(l<nums.length && r<nums.length){
            if(nums[l] == 0 && nums[r]!=0){
                int temp =nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
                l++;r++;
            }else if(nums[l] != 0 && nums[r]==0){
                l++;
            }else {
                r++;
            }
        }
    }
}