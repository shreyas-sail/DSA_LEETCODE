class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> para =  new ArrayList<List<Integer>>();
        recurSet(0,nums,para,new ArrayList<Integer>());
        return para;
    }
    
    public  void recurSet(int index,int[] nums,List<List<Integer>> ans,List<Integer> ds){
        if(index==nums.length){
            ans.add(new ArrayList<Integer>(ds));
            return ;
        }
        ds.add(nums[index]);
        recurSet(index+1,nums,ans,ds);
        ds.remove(ds.size() -1);
        recurSet(index+1,nums,ans,ds);
    }
}