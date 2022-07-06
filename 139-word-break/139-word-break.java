class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        int[] memo = new int[s.length()];
        Arrays.fill(memo,-1);
        return wordBreakHelper(0,s,wordSet,memo);
    }
    
    private boolean  wordBreakHelper(int pos,String s,Set<String> wordSet,int[] memo){
        if(pos == s.length()) return true;
        if(memo[pos]!=-1) return memo[pos] == 1?true:false;
        for(int i = pos;i<s.length();i++){
            if(wordSet.contains(s.substring(pos,i+1)) && wordBreakHelper(i+1,s,wordSet,memo)){
                memo[pos] = 1;
                return true;
            }
        }
        memo[pos] = 0;
        return  false;
    }
}