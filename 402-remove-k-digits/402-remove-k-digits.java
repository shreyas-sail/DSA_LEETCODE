class Solution {
    public String removeKdigits(String num, int k) {
        if(k == num.length()) return "0";
        Stack<Integer> st = new Stack<>();
        char[] numChar = num.toCharArray();
        int n = numChar.length;
        st.push(0);
        
        for(int i = 1; i<n;i++){
            while(!st.isEmpty() && k != 0 
                  && 
                  Integer.valueOf(numChar[st.peek()]) > Integer.valueOf(numChar[i]) ){
                st.pop();k--;
            }
            
            if(st.isEmpty() && numChar[i] == '0'){
                continue;
            }
            st.push(i);
        }
        while(!st.isEmpty() && k-- > 0){
            st.pop();
        }
        if(st.isEmpty()) return "0";
        
        int size = st.size();
        char[] ans = new char[size];
        while(!st.isEmpty()){
            ans[--size] += numChar[st.pop()];
        }
        
        return new String(ans);
    }
}