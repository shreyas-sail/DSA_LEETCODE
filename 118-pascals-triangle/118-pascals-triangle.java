class Solution {
    public List<List<Integer>> generate(int numRows) {
       List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> prev = new ArrayList<>();
        int i = 0;
        int n = numRows;
        while(i!=n){
            List<Integer> res = new ArrayList<>();
            for(int j=0;j<=i;j++){
                if(j == 0 || j == i){
                    res.add(1);
                }else{
                    res.add(prev.get(j-1)+prev.get(j));
                }
            }
            i++;
            ans.add(res);
            prev =res;
        }
        return ans; 
    }
}