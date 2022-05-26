class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] left = new int[heights.length];
        int[] right = new int[heights.length];
        Stack<Integer> st =  new Stack<>();
        
        for(int i=0;i<heights.length;i++){
            while(!st.isEmpty() && heights[st.peek()]>=heights[i]) st.pop();
            if(st.isEmpty()){
                left[i] = 0;
            }else{
                left[i] = st.peek()+1;
            }
            st.push(i);
        }
        
        System.out.println(Arrays.toString(left));
        st.clear();
        
        int max = Integer.MIN_VALUE;
        for(int i=heights.length -1;i>=0;i--){
            while(!st.isEmpty() && heights[st.peek()]>=heights[i]) st.pop();
            if(st.isEmpty()){
                right[i] = heights.length -1;
            }else{
                right[i] = st.peek()-1;
            }
             max = Math.max((right[i] - left[i] +1)*heights[i],max);
            st.push(i);
        }
        return max;
    }
}