class Solution {
    public int subsetXORSum(int[] nums) {
        
        // List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // List<Integer> ds = new ArrayList<>();
        return xorHelper(0,0,nums);
        
    }
    
    private int xorHelper(int i,int sum,int[] nums){
        if(i>=nums.length){
            return sum;
        }
        int take = xorHelper(i+1,nums[i]^sum,nums);
        int notTake = xorHelper(i+1,sum,nums);
        
        return take+notTake;
    }
}