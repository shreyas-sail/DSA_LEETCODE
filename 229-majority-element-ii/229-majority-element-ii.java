class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int num1 = 0 , num2 = 0 , cnt1 = 0 , cnt2 =0;
        for(int  i= 0;i<nums.length;i++){
            if(nums[i] == num1) cnt1++;
            else if(nums[i] == num2) cnt2++;
            else if(cnt1 == 0){
                num1 = nums[i];cnt1++;
            }
            else if(cnt2 == 0){
                num2 = nums[i];cnt2++;
            }else{
                cnt1--;cnt2--;
            }
        }
        List<Integer> ans = new ArrayList<>();
        cnt1 = 0;cnt2 = 0;
        for(int i :nums){
            if(num1 == i) cnt1++;
            else if(num2 == i) cnt2++;
        }
        if(cnt1>nums.length/3){
            ans.add(num1);
        }
        if(cnt2>nums.length/3){
            ans.add(num2);
        }
        return ans;
    }
}