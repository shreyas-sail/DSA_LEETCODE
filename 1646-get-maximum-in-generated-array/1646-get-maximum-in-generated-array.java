class Solution {
    public int getMaximumGenerated(int n) {
        if(n == 0 || n==1) return n;
        int[] nums = new int[n+1];
        nums[0] = 0 ;
        nums[1] = 1;
        int maxi = 1;
        for(int i = 1;i<=n-1/ 2;i++){
            if(i*2 >n || i*2+1>n) break;
            nums[i*2] = nums[i];
            nums[(i*2)+1] = nums[i] +nums[i+1];
            maxi = Math.max(maxi,Math.max(nums[i*2],nums[i*2+1]));
        }
        return maxi;
    }
}