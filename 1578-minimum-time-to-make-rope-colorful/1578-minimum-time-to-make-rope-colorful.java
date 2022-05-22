class Solution {
    public int minCost(String colors, int[] neededTime) {
        Stack<Pair> st = new Stack<>();
        int minCost = 0;
        for(int i =0;i<colors.length();i++){
            if(st.isEmpty() || st.peek().curChar != colors.charAt(i)){
                st.push(new Pair(colors.charAt(i),i));
            }else{
                int curMin = Math.min(neededTime[i],neededTime[st.peek().index]);
                minCost+= curMin;
                if(curMin == neededTime[st.peek().index]){
                    st.peek().index = i;
                }
            }
        }
        return minCost;
    }
    
    class Pair{
        Character curChar;
        int index;
        public Pair(Character cur,int index){
            curChar = cur;
            this.index = index;
        }
    }
}