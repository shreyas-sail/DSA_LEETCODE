class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[days.length];
        Arrays.fill(dp,-1);
        return minCostHelper(0,days,days.length,costs,dp);
    }
    
    public int minCostHelper(int curDay,int[] days,int n,int[]costs,int[] dp){
        if(curDay >= n ){
            return 0;     
        }
        if(dp[curDay]!=-1) return dp[curDay]; 
        int oneStep = costs[0] +  minCostHelper(curDay+1,days,days.length,costs,dp);
        int thirtyStep = (int) 1e9;
        int sevenStep = (int) 1e9;
        
        if(curDay<n && days[curDay] < days[curDay]+7){
           int i =  searchInsert(days,days[curDay]+7);
           sevenStep = costs[1] +  minCostHelper(i,days,n,costs,dp);
        }
        
        if(curDay<n && days[curDay] < days[curDay]+30){
           int i =  searchInsert(days,days[curDay]+30);
           thirtyStep = costs[2] +  minCostHelper(i,days,n,costs,dp);
        }
        return dp[curDay] =  Math.min(oneStep,Math.min(sevenStep,thirtyStep));
    }
    
    public int searchInsert(int[] nums, int target) {
        int l = 0 ,r= nums.length-1;
        while(l<=r){
            int mid = (l+r)/2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid] < target){
                l = mid+1;
            }else{
                r = mid -1;
            }
        }
        return l;
    }
}