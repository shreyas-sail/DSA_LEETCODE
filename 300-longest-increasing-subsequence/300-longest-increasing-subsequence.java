class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> temp = new ArrayList<Integer>();
        temp.add(nums[0]);
        for(int i = 1;i<nums.length;i++){
            if(nums[i]>temp.get(temp.size()-1)){
                temp.add(nums[i]);
            }else{
                int posi = searchInsert(temp.stream()
                            .mapToInt(Integer::intValue)
                            .toArray(),nums[i]);
                temp.set(posi,nums[i]);
            }
        }
        return temp.size();
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