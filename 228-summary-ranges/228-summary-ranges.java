class Solution {
    public List<String> summaryRanges(int[] nums) {
        int i =0,j=0;
        List<String> ans = new ArrayList<String>();
        while(j<nums.length){
            while(j != nums.length-1 && nums[j] == nums[j+1]-1){
                j++;
            }
            if(i == j){
                    ans.add(String.valueOf(nums[j]));
                }else{
                    String s = String.valueOf(nums[i])+"->"+String.valueOf(nums[j]);
                    ans.add(s);
                }
            j++;
            i = j;
        }
        return ans;
    }
}