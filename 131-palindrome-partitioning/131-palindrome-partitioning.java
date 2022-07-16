class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<List<String>>();
        List<String> res = new ArrayList<String>();
        backtrack(0,ans,res,s,s.length());
        return ans;
    }
    void backtrack(int index,List<List<String>> ans,List<String> res,String s,int n){
        System.out.println(index);
        if(n == index){
            ans.add(new ArrayList<String>(res));
            return;
        }
        
        for(int i = index;i<n;i++){
            // System.out.println(isPali(s,index,i));
            if(isPali(s,index,i)){
                // System.out.println("yes");
                res.add(s.substring(index,i+1));
                backtrack(i+1,ans,res,s,n);
                res.remove(res.size()-1);
            }
        }
    }
    
    boolean isPali(String s,int st, int e){
        while(st<=e){
            if(s.charAt(st++)!=s.charAt(e--)){
                return false;
            }
        }
        return true;
    }
}