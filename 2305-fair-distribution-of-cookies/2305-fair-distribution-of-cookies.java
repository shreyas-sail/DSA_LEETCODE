class Solution {
    public int distributeCookies(int[] cookies, int k) {
        int n = cookies.length;
        int[] res = new int[1];
        res[0] = (int) 1e9;
        backtrack(0,cookies,k,new int[k],res,n);
        return res[0];
    }
    
    void backtrack(int i,int[] cookies,int k,int[] children,int[] res,int n){
        if(i == n){
            int max = 0;
            for(int num:children) max = Math.max(num,max);
            // System.out.println(max);
            res[0] = Math.min(res[0],max);
            // System.out.println(res[0]);
            return;
        }
        
        for(int j = 0;j<k;j++){
            children[j] += cookies[i];
            backtrack(i+1,cookies,k,children,res,n);
            children[j] -= cookies[i];
        }
    }
}