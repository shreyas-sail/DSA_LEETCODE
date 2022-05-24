// import java.util.Collections;
class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
       List<Integer>  ans =  new ArrayList<Integer>();
       for(int i = 1;i<=9;i++)
        dfs(low,high,i,0,ans);
        Collections.sort(ans);
        return ans;
    }
    
    public void dfs(int low, int high,int i,int num,List<Integer> ans){
        if(num>= low && num<= high){
            ans.add(num);
        }
        if(num>high || i>9){
            return;
        }
        
        dfs(low,high,i+1,(num*10)+i,ans);
    }
}