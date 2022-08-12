class Solution {
    public int[] dailyTemperatures(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        int[] ans = new int[n];
        for(int i =n-1;i>=0;i--){
            // [89,62,70,58,47,47,46,76,100,70]
            // [               ,1 ,1,,0, 0 ] 
            while(!st.isEmpty() && arr[st.peek()]<=arr[i]){
                st.pop();
            }

            if(st.isEmpty()) ans[i] = 0;
            else{
                ans[i] = st.peek() - i;
            }
            st.push(i);
        }
        
        return ans;
    }
}