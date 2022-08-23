class Solution {
    public String removeKdigits(String num, int k) {
        if(k == num.length()) return "0";
        Stack<Integer> st = new Stack<>();
        char[] numChar = num.toCharArray();
        st.push(0);
        
        for(int i = 1; i<num.length();i++){
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
        while(!st.isEmpty() && k-- >0){
            st.pop();
        }
        String ans = "";
        while(!st.isEmpty()){
            ans += numChar[st.pop()];
        }
        if(ans.isBlank()) return "0";
        
        return new StringBuilder(ans).reverse().toString();
    }
}