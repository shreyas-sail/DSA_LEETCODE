class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans =new ArrayList<>();
        btParenthesis(0,0,n,"",ans);
        return ans;
    }
    
    void btParenthesis(int openC,int closeC,int n,String ds,List<String> ans){
        if(openC == closeC){
            if(closeC == n)
            {
                ans.add(ds);
                return ;
            }
        }
        if(openC<n){
            ds = ds + '(';
            btParenthesis(openC+1,closeC,n,ds,ans);
            ds = ds.substring(0, ds.length() - 1); 
        }
        if(closeC < openC){
            ds = ds + ')';
            btParenthesis(openC,closeC+1,n,ds,ans);
            ds = ds.substring(0, ds.length() - 1);
        }
    }
}