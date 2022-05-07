class Solution {
    public String removeDuplicates(String s, int k) {
        char[] stringChar = s.toCharArray();
        Stack<Pair> st = new Stack<>();
        for(int i = 0;i<stringChar.length;i++){
            Character cur= stringChar[i]; 
            if(st.isEmpty() || st.peek().c!=cur){
                st.push(new Pair(cur,1));
            }else if(st.peek().c == cur){
                st.peek().freq = st.peek().freq +1;
                if(st.peek().freq == k){
                    st.pop();
                }
            }
        }
        if(st.isEmpty()) return "";
        String res = "";
        while(!st.isEmpty()){
            Pair topPair = st.pop();
            String n = Character.toString(topPair.c);
            res += n.repeat(topPair.freq);
        }
        return (new StringBuilder(res).reverse()).toString();
    }
}
class Pair{
    Character c;
    int freq;
    public Pair(Character c,int freq){
        this.c = c;
        this.freq = freq;
    }
}