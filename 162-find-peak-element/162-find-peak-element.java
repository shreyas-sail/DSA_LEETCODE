class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length == 1) return 0;
        int l = 0 ,r = nums.length -1;
        while(l<=r){
            int mid = l+(r-l)/2;
            if((mid == 0 || nums[mid-1]<nums[mid]) && (mid == nums.length-1 || nums[mid]>nums[mid+1])){
                return mid;
            }
            
            if(mid != 0 && nums[mid-1]>nums[mid]){
                r = mid -1;
            }else{
                l = mid+1;
            }
        }
        
        return -1;
    }
}