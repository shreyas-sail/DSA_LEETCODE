class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        int[] dp = new int[nums.length];
        Arrays.fill(dp,-1);
        int[] nums1 = new int[nums.length-1];
        int[] nums2 = new int[nums.length-1];
        int j = 0 ,z =0;
        for(int i = 0;i<nums.length;i++){
            if(i != 0) {
                nums1[j] = nums[i];
                j++;
            }
            if(i != nums.length-1) {
                nums2[z] = nums[i];
                z++;
            }
            
        }
        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));
        int left = robHelper(nums1.length -1,nums1,dp);
        Arrays.fill(dp,-1);
        int right = robHelper(nums2.length -1,nums2,dp);
        return Math.max(left,right);
    }
    int robHelper(int i,int [] nums,int[] dp){
        if(i == 0){
            return nums[0];
        }
        if(i<0) return 0;
        if(dp[i] != -1) return dp[i]; 
        int notTake = robHelper(i-1,nums,dp);
        int take = Integer.MIN_VALUE;
        take = nums[i] + robHelper(i-2,nums,dp);
        return dp[i] = Math.max(notTake,take);
    }
}