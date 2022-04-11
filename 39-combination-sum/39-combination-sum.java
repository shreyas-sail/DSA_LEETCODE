class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        findCombination(0,candidates,ans,target,new ArrayList<Integer>());
        return ans;
    }
    
    public void findCombination(int index,int[] arr,List<List<Integer>> ans,int target,List<Integer> ds){
        if(index == arr.length ){
            if(target == 0){
                ans.add(new ArrayList<Integer>(ds));
            }
            return;
        }
        if(arr[index]<=target){
            ds.add(arr[index]);
            findCombination(index,arr,ans,target-arr[index],ds);
            ds.remove(ds.size()-1);
        }
        findCombination(index+1,arr,ans,target,ds);
    }
}