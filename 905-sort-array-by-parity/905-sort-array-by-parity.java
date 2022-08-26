class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int i =0,j = i+1;
        while(i<nums.length && j<nums.length){
          if(nums[i]%2!=0 && nums[j]%2==0){
            int temp = nums[i];
            nums[i] = nums[j];   
            nums[j] = temp;
          }
            if(nums[i]%2!=0 && nums[j]%2!=0){
                j++;
            }else{
                i++;j++;
            }
        }
        return nums;
    }
}