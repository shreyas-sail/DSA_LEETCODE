class Solution {
    public int minimumCost(int[] cost) {
        int count =1;
        int ans = 0;
        Arrays.sort(cost);
        for(int i =cost.length -1;i>=0;i--){
            if(count == 3){
                count = 0;
            }else{
                System.out.println(cost[i]);
                ans+=cost[i];
            }
            count++;
        }
        return ans;
    }
}