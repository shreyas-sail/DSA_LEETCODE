class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        func(0,ans,new ArrayList<Integer>(),candidates,target);
        return ans;
    }
    
    private void  func(int ind,List<List<Integer>> ans,List<Integer> ds,int[] candidates, int target){
        if(target == 0){
            ans.add(new ArrayList<Integer>(ds));
            return;
        }
        
        for(int i = ind;i<candidates.length;i++){
            if(i>ind && candidates[i] == candidates[i-1]) continue;
            if(candidates[i]>target) break;
            ds.add(candidates[i]);
            func(i+1,ans,ds,candidates,target-candidates[i]);
            ds.remove(ds.size()-1);
        }
        
    }
}