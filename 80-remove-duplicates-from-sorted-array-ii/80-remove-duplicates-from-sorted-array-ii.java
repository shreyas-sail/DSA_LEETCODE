class Solution {
    public int removeDuplicates(int[] nums) {
       int s =2,f =2;
        int n =nums.length;
        if(n<=2){
            return n;
        }
        for(f=s;f<n;f++){
            if(nums[f] != nums[s-2]){
                nums[s++] = nums[f]; 
            }
        }
        return s;
    }
}