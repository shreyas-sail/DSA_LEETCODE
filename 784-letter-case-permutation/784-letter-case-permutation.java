class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> ans = new ArrayList<String>();
        recursPermute(ans,new StringBuilder(s),0);
        return ans;
    }
    
    public void recursPermute(List<String> ans ,StringBuilder s,int i){
        if(i==s.length())
            ans.add(new String(s));
        
        else {    
            if(Character.isLetter(s.charAt(i))){
                    s.setCharAt(i,Character.toUpperCase(s.charAt(i)));
                    recursPermute(ans,s,i+1);
                    s.setCharAt(i,Character.toLowerCase(s.charAt(i)));
                    recursPermute(ans,s,i+1);
                }else{
                    recursPermute(ans,s,i+1);
                }
            }
        }
}