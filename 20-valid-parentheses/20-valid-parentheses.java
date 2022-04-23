class Solution {
    public boolean isValid(String s) {
        char[] arr = s.toCharArray();
        Stack<Character> st = new Stack<>();
        for(int i = 0 ;i<arr.length;i++){
            if(arr[i] == '(' || arr[i] == '[' || arr[i] == '{'){
                st.push(arr[i]);
            }else{
                if(st.isEmpty()) return false;
                if(arr[i] == ')' && st.peek() == '('){
                    st.pop();
                }else if (arr[i] == '}' && st.peek() == '{'){
                    st.pop();
                }else if(arr[i] == ']' && st.peek() == '['){
                    st.pop();
                }else{
                    return false;
                }
            }
        }
         if(st.isEmpty()) return true;
            return false;
    }
}