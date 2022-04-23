class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int n = nums.length; 
        int[] nextGreatestElement = new int[nums.length];
        st.push(nums[n-1]);
        for(int  i = 2*n-1;i>=0;i--){
            while(!st.isEmpty() && st.peek()<= nums[i%n])
                st.pop();
            if(i<n){
               if(st.isEmpty()) nextGreatestElement[i%n] = -1;
                else nextGreatestElement[i%n] = st.peek();
            }
            st.push(nums[i%n]);
        }
        return nextGreatestElement;
    }
}