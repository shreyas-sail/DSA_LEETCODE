class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> perms = new ArrayList<Integer>();
        Boolean[] freq = new Boolean[nums.length+1];
        System.out.println(Arrays.toString(freq));
        recursPermute(nums,freq,ans,perms);
        return ans;
    }
    public void recursPermute(int[] nums,Boolean[] freq,List<List<Integer>> ans,List<Integer> perms){
        if(perms.size() == nums.length){
            ans.add(new ArrayList<Integer>(perms));
            return;
        }
        for(int i =0;i<nums.length;i++){
            if(freq[i] == null || !freq[i]){
                freq[i] = true;
                perms.add(nums[i]);
                recursPermute(nums,freq,ans,perms);
                freq[i] = false;
                perms.remove(perms.size()-1);
            }
        }
    }
}